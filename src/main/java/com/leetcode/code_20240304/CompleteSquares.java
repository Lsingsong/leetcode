package com.leetcode.code_20240304;

import java.util.Arrays;

public class CompleteSquares {
    public int numSquares(int n) {
        // 创建一个长度为 n+1 的数组，初始化为最大值
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 0 的平方和数量是 0
        dp[0] = 0;

        // 从 1 到 n 遍历
        for (int i = 1; i <= n; i++) {
            // 尝试每个可能的完全平方数
            for (int j = 1; j * j <= i; j++) {
                // 更新 dp[i] 为较小的值
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        CompleteSquares solution = new CompleteSquares();
        System.out.println(solution.numSquares(12)); // 输出: 3
       // System.out.println(solution.numSquares(13)); // 输出: 2
    }
}