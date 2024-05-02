package com.leetcode.code_20240404;

import com.model.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReverseBetween {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode head0 = new ListNode(0);
        ListNode tail0 = head0;
        for(int i=0; i<left -1; i++) {
            tail0.next = list.get(i);
            tail0 = tail0.next;
        }
        ListNode head1 = new ListNode(0);
        ListNode tail1 = head1;
        for(int i=right - 1; i>=left - 1; i--) {
            tail1.next = list.get(i);
            tail1 = tail1.next;
        }
        ListNode head2 = new ListNode(0);
        ListNode tail2 = head2;
        for(int i=right; i<list.size(); i++) {
            tail2.next = list.get(i);
            tail2 = tail2.next;
        }
        tail0.next = head1.next;
        tail1.next = head2.next;
        return head0.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = reverseBetween(listNode1, 2, 4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
