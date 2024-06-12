package com.leetcode.code_20240502;

import com.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    /**
     * 层序遍历
     * @param root root
     * @return List<Integer>
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            for (int i=0; i<queue.size(); i++) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }


    /**
     * 199. 二叉树的右视图
     * 层序遍历 保存每一层的最后的节点
     * @param root
     * @return
     */
    public static List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i ==  size-1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }


    /**
     * 199. 二叉树的右视图
     * 根结点->右子节点->左子节点，这样遍历，保证每一层遍历的第一个节点都是最右边的节点
     * @param root
     * @return
     */
    static List<Integer> res = new ArrayList<>();
    public static List<Integer> rightSideView2(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private static void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
//        root.left = node1;
//        root.right = node2;
//        node1.right = node3;
//        node2.right = node4;


        TreeNode root1 = new TreeNode(1);
        root1.right = node2;
        System.out.println(rightSideView2(root1));
    }
}
