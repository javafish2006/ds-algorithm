package com.openmind.sort.swap;

import com.openmind.sort.BaseSortProcess;

public class BubbleSort extends BaseSortProcess {

    @Override
    protected int[] sort(int[] a) {
        int n = a.length, count = 0;
        boolean swapped;                         //optimised
        for (int i = 0; i < n - 1; i++) {        //need n-1 rounds
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {//round 0: j+1(max=n-1) < n ,j < n-1; round i , j < n-1-i
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swapped = true;
                }
                count++;
            }

            if (!swapped) {
                break;
            }
            //printArray(a);
        }
        System.out.printf("element: %s, O(n) = %s \n", n, count);  // n-1 + n-2 + …… + 1 = n (n + 1 ) /2
        return a;
    }

    public static void main(String[] args) {
        new BubbleSort().proceeding(10);
    }
}
