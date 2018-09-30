package com.openmind.searching;

import java.util.Arrays;

public class BinarySearch extends BaseSearchProcess {


    @Override
    protected int search(int[] a, int key) {
        //check start
        System.out.printf("check indices of %s: %s \n", key, Arrays.binarySearch(a, key));
        //check end

        int min = 0, max = a.length - 1, mid = (min + max) / 2;
        while (min <= max) {
            if (key == a[mid]) {
                return mid;
            }

            if (key < a[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }

            mid = (min + max) / 2;

        }
        return -1;
    }

    @Override
    protected int[] customerArray() {
        int[] sorted = new int[]{55, 31, 34, 64, 48, 95, 27, 13, 74, 65};
        Arrays.sort(sorted);
        return sorted;
    }

    public static void main(String[] args) {
        final BinarySearch search = new BinarySearch();
        search.proceeding(10, 74);
        System.out.println();
        search.proceeding(10, -74);
    }
}
