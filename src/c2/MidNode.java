package c2;

import common.ListNode;

public class MidNode {
    public static void main(String[] args) {

    }
    /**
     *查找链表的中间节点
     *
     */
    public static ListNode mid(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && null != fast.next){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
