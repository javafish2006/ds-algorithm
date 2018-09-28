package com.openmind.sort.insertion;

import com.openmind.sort.BaseSortProcess;

/**
 * Shell Sort:
 * CPU complexity:
 * Mem complexity:
 */
public class ShellSort extends BaseSortProcess {

    @Override
    protected int[] sort(int[] a) {

        int n = a.length;
        //(n/2, n/2/2, ..., 1)
        for (int gap = n / 2; gap > 0; gap /= 2) {
            //sub array insertion sort
            for (int i = gap; i < n; i++) {
                int j = i, tmp = a[j];
//                if (a[j] < a[j - gap]) {
                    while (j - gap >= 0 && tmp < a[j - gap]) {
                        a[j] = a[j - gap];
                        j -= gap;
                    }
                    a[j] = tmp;
//                    printArray(a);
//                }
            }
            System.out.println();
        }
        return a;
    }

    @Override
    protected int[] customerArray() {
//        return new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        return null;
    }

    public static void main(String[] args) {
        new ShellSort().proceeding(100);
    }
}
