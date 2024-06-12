package com.leetcode.code_20240612;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int pos = 0;
        while (pos < nums.length) {
            StringBuilder it = new StringBuilder(""+nums[pos]);
            int temp = pos;
            while (pos + 1 < nums.length && nums[pos + 1] == nums[pos] + 1){
                pos++;
            }
            if (pos != temp) {
                it.append("->").append(nums[pos]);
            }
            list.add(it.toString());
            pos++;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}
