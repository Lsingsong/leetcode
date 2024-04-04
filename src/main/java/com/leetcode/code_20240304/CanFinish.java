package com.leetcode.code_20240304;

import java.util.ArrayList;
import java.util.List;

public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建邻接表
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        // 标记数组，用于DFS
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) {
                return false; // 如果发现环，返回false
            }
        }
        return true; // 所有课程都可以完成
    }

    private boolean dfs(List<List<Integer>> graph, int[] visited, int course) {
        if (visited[course] == 1) {
            return false; // 检测到环
        }
        if (visited[course] == 2) {
            return true; // 已经访问过，无需继续搜索
        }

        visited[course] = 1; // 标记为正在访问
        for (int nextCourse : graph.get(course)) {
            if (!dfs(graph, visited, nextCourse)) {
                return false; // 递归检查相邻节点
            }
        }

        visited[course] = 2; // 标记为已访问
        return true;
    }

    public static void main(String[] args) {
        CanFinish solution = new CanFinish();

//        // 测试用例 1: 可以完成所有课程
//        int numCourses1 = 2;
//        int[][] prerequisites1 = {{1, 0}};
//        boolean result1 = solution.canFinish(numCourses1, prerequisites1);
//        System.out.println("Test 1: " + result1); // 应输出 true

        // 测试用例 2: 存在环，无法完成所有课程
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        boolean result2 = solution.canFinish(numCourses2, prerequisites2);
        System.out.println("Test 2: " + result2); // 应输出 false

//        // 测试用例 3: 没有先修课程，所有课程都可以直接学习
//        int numCourses3 = 0;
//        int[][] prerequisites3 = {};
//        boolean result3 = solution.canFinish(numCourses3, prerequisites3);
//        System.out.println("Test 3: " + result3); // 应输出 true

        // 可以根据需要添加更多测试用例
    }
}
