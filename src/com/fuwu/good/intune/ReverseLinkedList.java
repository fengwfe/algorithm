package com.fuwu.good.intune;

import com.fuwu.good.common.ListNode;
import com.fuwu.good.common.Printer;

public class ReverseLinkedList {
    public static void main(String[] args) {
//        Printer.print(reverse(new ListNode(new int[]{1,2,3})));
        Printer.print(reverse_02(new ListNode(new int[]{1,2,3})));

    }
    public static ListNode reverse(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        while (null != cur){
            ListNode dummyNext= dummy.next;
            ListNode curNext = cur.next;
            dummy.next = cur;
            cur.next = dummyNext;
            cur = curNext;
        }
        return dummy.next;
    }

    public static ListNode reverse_02(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        ListNode node = reverse_02(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
