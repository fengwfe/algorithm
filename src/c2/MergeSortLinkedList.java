package c2;

import common.ListNode;
import common.ListNodeUtil;

public class MergeSortLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{0,9,1,23,55,1,0});
        ListNodeUtil.print(head);
        ListNodeUtil.print(sort(head));

    }

    public static ListNode sort(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = slow;
        while (null != fast && null != fast.next){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode left = sort(head);
        ListNode right = sort(slow);
        return merge(left, right);
    }

    public static ListNode merge(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode p1 = h1;
        ListNode p2 = h2;
        while (null != p1 || null != p2){
            if(null == p1){
                cur.next = p2;
                return dummy.next;
            }
            if(null == p2){
                cur.next = p1;
                return dummy.next;
            }
            if(p1.val < p2.val){
                cur.next = p1;
                p1 = p1.next;
            }else {
                cur.next = p2;
                p2= p2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
