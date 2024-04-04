package com.leetcode;

import com.model.DlinkNode;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    public DlinkNode head;
    public DlinkNode tail;

    public int usedsize;
    public Map<Integer, DlinkNode> cache;
    public int capacity;

    public LRUCache(int capacity) {
        this.head = new DlinkNode();
        this.tail = new DlinkNode();
        head.next = tail;
        tail.pre = head;
        cache = new HashMap<>();
        this.capacity = capacity;
    }

    public void put(int key, int val) {
        DlinkNode DlinkNode = cache.get(key);
        if (DlinkNode == null) {
            DlinkNode newDlinkNode = new DlinkNode(key, val);
            cache.put(key, newDlinkNode);
            addToTail(newDlinkNode);
            usedsize++;
            if (usedsize > capacity) {
                DlinkNode removeDlinkNode = removeHead();
                cache.remove(removeDlinkNode.key);
                usedsize--;
            }
        } else {
            DlinkNode.value = val;
            moveTotail(DlinkNode);
        }
    }

    public void removeDlinkNode(DlinkNode DlinkNode) {
        DlinkNode.pre.next = DlinkNode.next;
        DlinkNode.next.pre = DlinkNode.pre;
    }

    public void moveTotail(DlinkNode DlinkNode) {
        removeDlinkNode(DlinkNode);
        addToTail(DlinkNode);
    }

    public void addToTail(DlinkNode DlinkNode) {
        tail.pre.next = DlinkNode;
        DlinkNode.pre = tail.pre;
        DlinkNode.next = tail;
        tail.pre = DlinkNode;
    }

    public DlinkNode removeHead() {
        DlinkNode del = head.next;
        head.next = del.next;
        del.next.pre = head;
        return del;
    }

    public DlinkNode removeHead2() {
        DlinkNode del = head.next;
        head.next = del.next;
        del.next.pre = head;
        return del;
    }

    public int get(int key) {
        DlinkNode DlinkNode = cache.get(key);
        if (DlinkNode == null) {
            return -1;
        }
        moveTotail(DlinkNode);
        return DlinkNode.value;
    }
}

