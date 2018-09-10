package com.openmind.sort;

public abstract class BaseTestSort {

    abstract int[] sort(int[] a);

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
        int[] origin = genRandomArray(n);
        System.out.print("Origin: ");
        printArray(origin);

        //sorting & print
        origin = sort(origin);
        System.out.print("Sorted: ");
        printArray(origin);
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;

    }
}
