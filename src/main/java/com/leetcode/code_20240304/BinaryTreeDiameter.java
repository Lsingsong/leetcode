package com.leetcode.code_20240304;

import com.model.TreeNode;

public class BinaryTreeDiameter {
    private int maxDiameter;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        height(root);
        return maxDiameter;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // 更新最大直径
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // 返回当前节点的高度
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // 构建一棵二叉树
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreeDiameter solution = new BinaryTreeDiameter();
        int diameter = solution.diameterOfBinaryTree(root);
        System.out.println("The diameter of the binary tree is: " + diameter);
    }
}
