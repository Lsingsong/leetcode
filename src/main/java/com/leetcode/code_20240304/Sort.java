package com.leetcode.code_20240304;

public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] nums);

    protected boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    protected void swap(T[] a, int i, int j) {
        T b = a[i];
        a[i] = a[j];
        a[j] = b;
    }
}
