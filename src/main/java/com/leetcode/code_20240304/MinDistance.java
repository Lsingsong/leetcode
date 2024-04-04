package com.leetcode.code_20240304;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // 初始化 dp 数组，大小为 (m+1) x (n+1)，多出一行一列用于边界条件
        int[][] dp = new int[m + 1][n + 1];

        // 初始化边界条件
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // word1 的前 i 个字符转换成空字符串，需要 i 次删除操作
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // 空字符串转换成 word2 的前 j 个字符，需要 j 次插入操作
        }

        // 填充 dp 数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // 字符相同，不需要操作
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j],    // 删除
                            Math.min(dp[i][j - 1], // 插入
                                    dp[i - 1][j - 1]) // 替换
                    );
                }
            }
        }

        // 返回 word1 转换成 word2 所使用的最少操作数，保存在 dp[m][n] 中
        return dp[m][n];
    }
}
