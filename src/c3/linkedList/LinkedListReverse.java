package c3.linkedList;

import common.ListNode;
import common.Printer;
import java.util.List;

public class LinkedListReverse {
    public static ListNode successor;
    public static void main(String[] args) {
//        ListNode head = new ListNode(new int[]{1,2,3,4,5,6,7,8});
////        Printer.print(reverse_4(head,2, 4));
//        Printer.print(reverse_6(head,  3));
        System.out.println("12345".substring(1,3));
    }
    /**
     *递归反转链表
     */
    public static ListNode reverse(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        ListNode next = head.next;
        ListNode node = reverse(next);
        next.next = head;
        head.next = null;
        return node;
    }

    /**
     *迭代反转链表
     */
    public static ListNode reverse_2(ListNode head){
        if(null ==  head || null == head.next){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        while (null != cur){
            ListNode next = cur.next;
            ListNode dummyNext = dummy.next;
            dummy.next = cur;
            cur.next = dummyNext;
            cur = next;
        }
        return dummy.next;
    }

    /**
     *反转链表前n个节点
     */
    public static ListNode reverse_3(ListNode head, int n){
        if(null == head || null == head.next){
            return head;
        }
        if(n == 1){
            successor =  head.next;
            return head;
        }
        ListNode node = reverse_3(head.next, n - 1);
        head.next.next  = head;
        head.next =successor;
        return node;
    }

    /**
     *反转区间里面的节点
     */
    public static ListNode reverse_4(ListNode head, int m, int n){
        if(m == 1){
            return reverse_3(head, n);
        }
        ListNode node = reverse_4(head.next, m  -  1, n  -  1);
        head.next = node;
        return head;
    }

    /**
     *反转节点[a,b)之间的节点
     *
     */
    public static ListNode reverse_5(ListNode a, ListNode b){
        ListNode dummy = new ListNode(-1);
        ListNode cur = a;
        while (cur != b){
            ListNode curNext = cur.next;
            ListNode dummyNext = dummy.next;
            dummy.next = cur;
            cur.next = dummyNext;
            cur = curNext;
        }
        return dummy.next;
    }

    /**
     *
     * k个一组反转链表，不满k个保持不变
     *
     */
    public static ListNode reverse_6(ListNode head, int k){
        int i = 1;
        ListNode b = head;
        while (i <= k){
            if(null == b){
                return head;
            }
            i++;
            b = b.next;
        }
        ListNode newHead = reverse_5(head, b);
        ListNode node = reverse_6(b, k);
        head.next  = node;
        return newHead;
    }


}
