package com.openmind.sorting.selection;

import com.openmind.sorting.BaseSortProcess;

/**
 * Selection Sort: ascending
 * complexity: O(n) O(n^2) O(n^2)
 * storage: O(1)
 */
public class SelectionSort extends BaseSortProcess {

    @Override
    protected int[] sort(int[] a) {
        int min, count = 0, n = a.length;
        //3. recursive one by one since a[0]
        for (int i = 0; i < n - 1; i++) {
            min = i;

            //1.comparison, pick the min element in  a[i, n]
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
                count++;
            }

            //2.placed the min element at a[i]
            if (min != i) {
                swap(a, i, min);
            }
//            printArray(a);
        }
        System.out.printf("element: %s, O(n) = %s \n", n, count);  // n-1 + n-2 + …… + 1 = n (n -1 ) /2
        return a;
    }

    public static void main(String[] args) {
        new SelectionSort().proceeding(10);
    }

}
