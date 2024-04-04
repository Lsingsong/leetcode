package com.leetcode.code_20240304;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // 初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // 初始化第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        // 填充剩余部分
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        MinPathSum solution = new MinPathSum();

        // 测试用例 1
        int[][] grid1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int minPathSum1 = solution.minPathSum(grid1);
        System.out.println("Test case 1: Minimum path sum is " + minPathSum1); // 应输出 7

        // 测试用例 2
        int[][] grid2 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int minPathSum2 = solution.minPathSum(grid2);
        System.out.println("Test case 2: Minimum path sum is " + minPathSum2); // 应输出 12

        // 可以根据需要添加更多测试用例
    }
}
