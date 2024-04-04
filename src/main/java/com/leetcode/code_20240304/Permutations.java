package com.leetcode.code_20240304;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; // 用于标记数组中的元素是否已经被使用
        backtrack(nums, used, current, result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            // 如果当前排列的长度等于数组长度，则找到一个全排列
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                // 如果当前元素没有被使用，则将其添加到当前排列中
                current.add(nums[i]);
                used[i] = true; // 标记该元素为已使用

                // 继续寻找下一个元素的全排列
                backtrack(nums, used, current, result);

                // 回溯，撤销选择
                current.remove(current.size() - 1);
                used[i] = false; // 标记该元素为未使用，以便进行下一次选择
            }
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permutations.permute(nums);
        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }
}
