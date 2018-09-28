package com.openmind.sort;

import java.util.Arrays;
import java.util.stream.Stream;

public abstract class BaseSortProcess {

    protected abstract int[] sort(int[] a);

    protected int[] customerArray() {
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

    protected static void printArray(int[] origin) {
        for (int t : origin) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public void proceeding(int n) {

        //init array, then print
        int[] origin = customerArray() == null ? genRandomArray(n) : customerArray();
        System.out.print("Origin: ");
        printArray(origin);

        int[] tmp = origin.clone();

        //sorting & print
        int[] sorted = sort(origin);
        System.out.print("Sorted: ");
        printArray(sorted);

        //verify
        Arrays.sort(tmp);
        System.out.print("verify: ");
        printArray(tmp);
    }

    protected void swap(int[] a, int i, int j) {
        if(a[i] == a[j]){
            return ;
        }
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
