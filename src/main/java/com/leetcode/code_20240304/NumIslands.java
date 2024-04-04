package com.leetcode.code_20240304;

public class NumIslands {
    private int rows;
    private int cols;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = grid;

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != '1') {
            return;
        }

        // 标记当前位置为已访问
        grid[i][j] = '#';

        // 递归访问相邻的陆地
        dfs(i - 1, j); // 上
        dfs(i + 1, j); // 下
        dfs(i, j - 1); // 左
        dfs(i, j + 1); // 右
    }

    public static void main(String[] args) {
        // 创建一个示例网格
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        // 创建 Solution 对象并调用 numIslands 方法
        NumIslands solution = new NumIslands();
        int numIslands = solution.numIslands(grid);

        // 打印岛屿数量
        System.out.println("Number of islands: " + numIslands);
    }
}
