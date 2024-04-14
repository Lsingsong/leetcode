package com.leetcode.code_20240404;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int k=0;k<nums.length-1;k++) {
            List<List<Integer>> list1 = twoSum(nums, k, -nums[k]);
            if (!list1.isEmpty()) {
                list.addAll(list1);
            }
        }
        Set<List<Integer>> set = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(set);
        return list;
    }


    public static List<List<Integer>> twoSum(int[] numbers, int k, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int i=k+1;
        int j=numbers.length-1;
        while (i<j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                list.add(Arrays.asList(-target, numbers[i],numbers[j]));
                j--;
                i++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] {-2,0,1,1,2}));
    }
}
