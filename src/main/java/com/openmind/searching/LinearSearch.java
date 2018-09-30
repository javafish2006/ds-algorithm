package com.openmind.searching;

public class LinearSearch extends BaseSearchProcess {


    @Override
    protected int search(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected int[] customerArray() {
        return new int[]{55, 31, 34, 64, 48, 95, 27, 13, 74, 65};
    }

    public static void main(String[] args) {

        final LinearSearch search = new LinearSearch();
        search.proceeding(10, 27);
        System.out.println();
        search.proceeding(10, 7);
    }
}
