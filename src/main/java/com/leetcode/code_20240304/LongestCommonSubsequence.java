package com.leetcode.code_20240304;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // 初始化 dp 数组，大小为 (m+1) x (n+1)，多出一行一列用于边界条件
        int[][] dp = new int[m + 1][n + 1];

        // 填充 dp 数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 返回最长公共子序列的长度，保存在 dp[m][n] 中
        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence solution = new LongestCommonSubsequence();

        // 测试用例 1
        String text1 = "abcde";
        String text2 = "ace";
        int lcsLength1 = solution.longestCommonSubsequence(text1, text2);
        System.out.println("The length of the longest common subsequence for \"" + text1 + "\" and \"" + text2 + "\" is: " + lcsLength1); // 应输出 3

        // 测试用例 2
        String text3 = "abc";
        String text4 = "def";
        int lcsLength2 = solution.longestCommonSubsequence(text3, text4);
        System.out.println("The length of the longest common subsequence for \"" + text3 + "\" and \"" + text4 + "\" is: " + lcsLength2); // 应输出 0

        // 可以根据需要添加更多测试用例
    }
}
