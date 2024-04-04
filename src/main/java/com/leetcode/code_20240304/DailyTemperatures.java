package com.leetcode.code_20240304;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            // 如果栈不为空且当前温度大于栈顶温度对应的下标所代表的温度
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 弹出栈顶元素，计算等待天数，并赋值给结果数组
                int index = stack.pop();
                result[index] = i - index;
            }
            // 当前温度对应的下标入栈
            stack.push(i);
        }

        // 栈中剩余的元素对应的温度在后面都没有更高的温度，因此都赋值为0
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }

        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(temperatures);
        for (int day : result) {
            System.out.print(day + " ");
        }
    }
}
