package com.leetcode.code_20240304;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();
        backtrack(s, 0, currentPartition, result);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        if (start == s.length()) {
            // 如果已经处理完整个字符串，则将当前分区方案添加到结果中
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i + 1);
            if (isPalindrome(substring)) {
                // 如果当前子串是回文串，则将其添加到当前分区方案中
                currentPartition.add(substring);
                // 继续处理剩余部分
                backtrack(s, i + 1, currentPartition, result);
                // 回溯，移除刚刚添加的子串，以便尝试其他可能的分割点
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning solution = new PalindromePartitioning();
        String s = "aab";
        List<List<String>> partitions = solution.partition(s);
        for (List<String> partition : partitions) {
            System.out.println(partition);
        }
    }
}
