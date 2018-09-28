package com.openmind.sort.insertion;

import com.openmind.sort.BaseSortProcess;

public class InsertionSort extends BaseSortProcess {

//    @Override
//    int[] sort(int[] a) {
//        int n = a.length, count = 0, pos, current;
//        for (int i = 1; i < n; i++) {
//            pos = i;
//            current = a[i];
//            for (int j = i - 1; j >= 0 && current < a[j]; j--) {
//                a[j + 1] = a[j];
//                pos = j;
//            }
//            if (pos != i) {
//                a[pos] = current;
//            }
//            printArray(a);
//        }
//        return a;
//    }


    @Override
    protected int[] sort(int[] a) {
        int n = a.length, count = 0, current, j;
        for (int i = 1; i < n; i++) {
            j = i - 1;
            current = a[i];
            while (j >= 0 && current < a[j]) {
                a[j + 1] = a[j];
                j--;
                count++;
            }
            a[j + 1] = current;
            printArray(a);
        }
        System.out.printf("element: %s, O(n) = %s \n", n, count);  // n-1 + n-2 + …… + 1 = n (n -1 ) /2
        return a;
    }

    public static void main(String[] args) {
        new InsertionSort().proceeding(10);
    }
}
