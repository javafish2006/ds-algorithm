package com.openmind.sort;

import java.util.Arrays;

public abstract class BaseTestSort {

    abstract int[] sort(int[] a);

    int[] customerArray() {
        return null;
    }

    static int[] genRandomArray(int count) {
        if (count <= 0) {
            count = 7;
        }

        int[] origin = new int[count];
        for (int i = 0; i < count; i++) {
            origin[i] = (int) (Math.random() * 100);
        }

        return origin;
    }

    static void printArray(int[] origin) {
        for (int t : origin) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    void proceeding(int n) {

        //init array, then print
        int[] origin = customerArray() == null ? genRandomArray(n) : customerArray();
        System.out.print("Origin: ");
        printArray(origin);

        //sorting & print
        int[] sorted = sort(origin);
        System.out.print("Sorted: ");
        printArray(sorted);

        //verify
        Arrays.sort(origin);
        System.out.print("verify: ");
        printArray(origin);
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;

    }
}
