package com.openmind.sorting;

/**
 * Merge sorting : ascedning
 * CPU complexity: O(nlogn) O(nlogn) O(nlogn)
 * Mem complexity: O(n)
 **/
public class MergeSort extends BaseSortProcess {

    @Override
    protected int[] sort(int[] a) {
        sort(a, 0, a.length - 1);
        return a;
    }

    void sort(int[] a, int left, int right) {
        if (left < right) {
            //mid-left = right-mid
            int mid = (left + right) / 2;

            //divide into tow part recursively
            sort(a, left, mid);
            sort(a, mid + 1, right);

            //merge divided part after comparison
            merge(a, left, mid, right);
        }
    }

    private void merge(int[] a, int left, int mid, int right) {
        //1.copy data to tmp left-sub array: a[left, mid], right-sub array: a[mid +1 , rigth]
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
//        int rightSize = right - (mid + 1) + 1;

        int[] L = new int[leftSize];
        for (int i = 0; i < leftSize; i++) {
            L[i] = a[left + i];
        }

        int[] R = new int[rightSize];
        for (int j = 0; j < rightSize; j++) {
            R[j] = a[mid + 1 + j];
        }

        //2.compare head of two sub array , set litter at a[start++]
        int start = left;
        int i = 0, j = 0;
        while (i < leftSize && j < rightSize) {
            if (L[i] <= R[j]) {
                a[start] = L[i];
                i++;
            } else {
                a[start] = R[j];
                j++;
            }
            start++;
        }

        //3.copy remaining elements of left/right sub array
        while (i < leftSize) {
            a[start] = L[i];
            start++;
            i++;
        }
        while (j < rightSize) {
            a[start] = R[j];
            start++;
            j++;
        }
    }

    public static void main(String[] args) {
        new MergeSort().proceeding(10);
    }
}
