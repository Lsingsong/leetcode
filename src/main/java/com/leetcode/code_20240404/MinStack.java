package com.leetcode.code_20240404;

import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Integer min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MIN_VALUE;
    }

    public void push(int val) {
        stack.push(val);
        min = Math.min(min, val);
    }

    public void pop() {
        Integer pop = stack.pop();
        if (Objects.equals(pop, min)) {
            min = Integer.MIN_VALUE;
            for (Integer s : stack) {
                min = Math.min(min, s);
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
