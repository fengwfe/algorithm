package c2;

import common.ListNode;

public class ListCycle {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n2;
        System.out.println(hasCycle2(n1));


    }

    public static boolean hasCycle(ListNode head){
        if(null == head || null == head.next){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(null != fast && null != fast.next){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public static Integer hasCycle2(ListNode head){
        if(null == head || null == head.next){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(null != fast && null != fast.next){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow.val;
            }
        }
        return null;
    }
}
