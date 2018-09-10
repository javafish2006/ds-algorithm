package com.openmind.sort;

/**
 * 简单选择排序 Selection Sort
 * complex: O(n^2)
 * storage: O(n)
 */
public class SimpleSelectionSort extends BaseTestSort {

    @Override
    int[] sort(int[] a) {
        int min, count = 0, n = a.length;
        for (int i = 0; i < n - 1; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
                count++;
            }
            if (min != i) {
                swap(a, i, min);
            }
//            printArray(a);
        }
        System.out.printf("element: %s, O(n) = %s \n", n, count);  // n-1 + n-2 + …… + 1 = n (n -1 ) /2
        return a;
    }

    public static void main(String[] args) {
        new SimpleSelectionSort().proceeding(10);
    }

}
