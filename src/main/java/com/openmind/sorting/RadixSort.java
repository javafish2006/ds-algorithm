package com.openmind.sorting;

/**
 * Radix Sort: ascending
 * U complexity: O(n^（1.3—2）)
 * Mem complexity: O(1)
 * Unstable
 */
public class RadixSort extends BaseSortProcess {

    @Override
    protected int[] sort(int[] a) {
        int max = getMax(a);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(a, a.length, exp);
        }

        return a;
    }

    private void countSort(int[] a, int n, int exp) {

        int[] count = new int[10];
//        Arrays.fill(count, 0);

        int t;
        for (int i = 0; i < n; i++) {
            t = (a[i] / exp) % 10;
            count[t]++;
        }

        //count[i], total count of a(0,1,...,i )
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
//        for (int i = 0; i < n; i++) {
            t = (a[i] / exp) % 10;
            //indices is 1 less than count
            output[count[t] - 1] = a[i];
            count[t]--;
        }

        for (int i = 0; i < n; i++) {
            a[i] = output[i];
        }
    }

    private int getMax(int[] a) {
        int n = a.length, max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new RadixSort().proceeding(10);
    }
}
