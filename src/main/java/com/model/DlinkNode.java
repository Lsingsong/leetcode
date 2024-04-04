package com.model;

public class DlinkNode {
    public int key;

    public int value;

    public DlinkNode pre;

    public DlinkNode next;

    public DlinkNode (int key, int value) {
        this.key = key;
        this.value = value;
    }

    public DlinkNode() {

    }
}
