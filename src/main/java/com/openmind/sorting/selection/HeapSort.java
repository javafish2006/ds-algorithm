package com.openmind.sorting.selection;

import com.openmind.sorting.BaseSortProcess;

/**
 * Heap sorting : ascending
 * CPU complexity: O(nlogn) O(nlogn) O(nlogn)
 * Mem complexity: O(1)
 */
public class HeapSort extends BaseSortProcess {

    @Override
    protected int[] sort(int[] a) {
        int n = a.length;

        //1.build max heap, a[0, ..., n-1], bottom up
        //root of last element: ((n-1)-1)/2 = n/2 -1
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        //2. extract max element one by one to asceding seq
        for (int t = n - 1; t >= 0; t--) {

            //2.1 move max element（root） to end of array
            swap(a, t, 0);

            //2.2. rebuild max heap of the remaining elements, from root
            heapify(a, t, 0);
        }
        return a;
    }

    //len: size of heap; i: current root of subtree
    private void heapify(int[] a, int len, int i) {

        //initial root element as max, get indices of left/right child
        int max = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        //compare and swap
        if (l < len && a[l] > a[max]) {
            max = l;
        }

        if (r < len && a[r] > a[max]) {
            max = r;
        }

        //recursively
        if (max != i) {
            swap(a, i, max);
            heapify(a, len, max);
        }
    }

    public static void main(String[] args) {
        new HeapSort().proceeding(10);
    }
}
