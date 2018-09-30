package com.openmind.sorting.swap;

import com.openmind.sorting.BaseSortProcess;

/**
 * 快速排序： 稳定排序 ， 时间复杂度为O(n) = n*logn
 */
public class QuickSort extends BaseSortProcess {

    @Override
    protected int[] sort(int[] a) {

        sort(a, 0, a.length - 1);
        return a;
    }

    void sort(int[] a, int low, int high) {
        if (low >= high) return;

        int p = partition(a, low, high);

        System.out.printf("current j: %s, pivot: %s \n", p, a[p]);
        printArray(a);
        System.out.println();

        sort(a, low, p - 1);
        sort(a, p + 1, high);
    }

    int partition(int[] a, int low, int high) {
        int pivot = a[low];
        int i = low, j = high;
        while (i < j) {

            //
            while (j > i && a[j] >= pivot) {
                j--;
            }

            //
            while (i < j && a[i] <= pivot) {
                i++;
            }

            if (a[i] > a[j]) {
                swap(a, i, j);
//                printArray(a);
            }
        }

        if (a[low] > a[j]) swap(a, low, j);

        return j;
    }

    @Override
    protected int[] customerArray() {
//        return new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 7, 3};
        return null;
    }

    public static void main(String[] args) {
        new QuickSort().proceeding(10);
    }
}
