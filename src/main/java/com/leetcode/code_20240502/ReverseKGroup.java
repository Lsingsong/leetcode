package com.leetcode.code_20240502;

import com.model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    public static ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

    public static ListNode reverseKGroup1(ListNode head, int k) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode node = listNode;
        while (head != null) {
            ListNode tail = node;
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return listNode.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse1(head, tail);
            head = reverse[0];
            tail = reverse[1];
            node.next = head;
            tail.next = nex;
            node = tail;
            head = tail.next;

        }
        return listNode.next;
    }

    public static ListNode[] myReverse1(ListNode head, ListNode tail) {
        ListNode listNode = new ListNode(0);
        ListNode node = listNode;
        List<ListNode> list = new ArrayList<>();
        while (head != tail) {
            list.add(head);
            head = head.next;
        }
        for (int i=list.size()-1; i>=0; i--) {
            node.next = list.get(i);
            node = node.next;
        }
        head = listNode.next;
        while (listNode != null) {
            tail = listNode;
            listNode = listNode.next;
        }
        return new ListNode[]{head, tail};
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

        ListNode listNode = reverseKGroup1(listNode1, 2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
