package com.leetcode.code_20240304;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> rottenOranges = new LinkedList<>();
        int freshOranges = 0;
        int minutes = 0;

        // 初始化腐烂的橘子和新鲜橘子的数量
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    rottenOranges.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // 定义四个方向的偏移量
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 开始BFS
        while (!rottenOranges.isEmpty() && freshOranges > 0) {
            int size = rottenOranges.size();
            for (int i = 0; i < size; i++) {
                int[] orange = rottenOranges.poll();
                int x = orange[0];
                int y = orange[1];

                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1) {
                        // 将相邻的新鲜橘子腐烂
                        grid[nx][ny] = 2;
                        freshOranges--;
                        rottenOranges.offer(new int[]{nx, ny});
                    }
                }
            }
            minutes++; // 每分钟结束后，分钟数加1
        }

        return freshOranges == 0 ? minutes : -1; // 如果没有新鲜橘子了，返回分钟数；否则返回-1
    }

    public static void main(String[] args) {
        RottenOranges solution = new RottenOranges();
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        int minutes = solution.orangesRotting(grid);
        System.out.println("Minutes to rot all oranges: " + minutes);
    }
}
