package com.fuwu.good.common;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int[] data){
        this.val = data[0];
        ListNode pre = this;
        for(int i = 1; i < data.length; i++){
            ListNode node = new ListNode(data[i]);
            pre.next = node;
            pre = node;
        }
    }
    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
