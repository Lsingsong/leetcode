package com.leetcode.code_20240404;

public class MaxArea {
    public int maxArea(int[] height) {
        int max = 0;
        int i=0;
        int j=height.length-1;
        while (i<j) {
            int high = Math.min(height[i], height[j]);
            int area = high * (j-i);
            max = Math.max(max, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
