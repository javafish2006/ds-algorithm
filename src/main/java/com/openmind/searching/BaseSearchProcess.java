package com.openmind.searching;

public abstract class BaseSearchProcess {

    protected abstract int search(int[] a, int key);

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

    public void proceeding(int n, int key) {
        int[] a = customerArray() == null ? genRandomArray(n) : customerArray();
        System.out.print("Origin: ");
        printArray(a);

        final int indices = search(a, key);
        System.out.printf("search indices of %s: %s", key, indices);
    }

}
