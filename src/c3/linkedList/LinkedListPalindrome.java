package c3.linkedList;

import common.ListNode;

public class LinkedListPalindrome {
    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{1,2,3,2,1});
        System.out.println(isPalindrome(node));

    }

    public static ListNode reverse(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        while (null != cur){
            ListNode dummyNext = dummy.next;
            ListNode curNext = cur.next;
            dummy.next = cur;
            cur.next = dummyNext;
            cur = curNext;
        }
        return dummy.next;
    }

    public static boolean isPalindrome(ListNode head){
        if(null == head){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && null != fast.next){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(null != fast){
            slow = slow.next;
        }
        ListNode right = reverse(slow);
        ListNode left = head;
        while (null != right){
            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
