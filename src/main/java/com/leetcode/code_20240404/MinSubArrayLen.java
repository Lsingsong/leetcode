package com.leetcode.code_20240404;

public class MinSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = -1;
        int sum = 0;
        int len = nums.length + 1;
        boolean tag = false;
        while (i <= nums.length - 1) {
            int l = j - i + 1;
            if (sum >= target) {
                if (len > l) {
                    len = l;
                }
                sum = sum - nums[i];
                i++;
            } else {
                if (j < nums.length-1) {
                    j++;
                    sum = sum + nums[j];
                } else {
                    tag = true;
                }
            }
            if (tag) {
                if (len == nums.length + 1) {
                    return 0;
                }
                return len;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(15, new int[] {5,1,3,5,10,7,4,9,2,8}));
    }
}
