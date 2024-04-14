package com.leetcode.code_20240404;

public class TwoSum {
    /**
     * 二分查找法
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i=0; i<numbers.length-1;i++) {
            int low=i+1;
            int high=numbers.length-1;
            while (low<=high){
                int mid=(high-low)/2+low;
                if (target-numbers[i] > numbers[mid]) {
                    low = mid + 1;
                } else if (target-numbers[i] < numbers[mid]) {
                    high = mid - 1;
                } else {
                    return new int[]{i+1,mid+1};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 双指针法
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        int i=0;
        int j=numbers.length-1;
        while (i<=j) {
           int sum = numbers[i] + numbers[j];
           if (sum > target) {
               j--;
           } else if (sum < target) {
               i++;
           } else {
               return new int[]{i+1,j+1};
           }
        }
        return new int[]{-1, -1};
    }
}
