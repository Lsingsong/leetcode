package com.leetcode.code_20240404;

import com.model.ListNode;

public class Partition {
    /**
     * 86. 分隔链表
     * 1->4->3->2->5->2
     * 1->2->2->4->3->5
     * @param head 头节点
     * @param x 节点值
     * @return 重排序后的链表头节点
     */
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode leftHead = left;
        ListNode rightHead = right;
        while (null != head.next) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightHead.next;
        return leftHead.next;
    }
}
