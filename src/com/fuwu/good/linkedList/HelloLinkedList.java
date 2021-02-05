package com.fuwu.good.linkedList;

import com.fuwu.good.common.ListNode;

/**
 * 1.链表反转，迭代
 * 2.链表反转，递归
 * 3.环形链表
 */
public class HelloLinkedList {
  public static void main(String[] args) {
//    ListNode head = new ListNode(new int[]{1,2,3,4});
//    Printer.print(head);
//    Printer.print(reverse_2(head));
    ListNode l = new ListNode(0);
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    ListNode l5 = new ListNode(5);
    ListNode l6 = new ListNode(6);
    ListNode l7 = new ListNode(7);
    l.next = l1;
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    l5.next = l6;
    l6.next = l7;
    l7.next = l4;
    System.out.println(cycle(l));
  }

  /**
   * 1.链表反转，迭代
   * @param head
   * @return
   */
  public static ListNode reverse(ListNode head){
    if(null == head || null == head.next){
      return head;
    }
    ListNode dummyNode = new ListNode(-1);
    ListNode cur = head;
    while (null != cur){
      ListNode dummyNext = dummyNode.next;
      ListNode curNext = cur.next;
      dummyNode.next = cur;
      cur.next = dummyNext;
      cur = curNext;
    }
    return dummyNode.next;
  }

  /**
   * 2.链表反转，递归
   * @param head
   * @return
   */
  public static ListNode reverse_2(ListNode head){
    if(null == head || null == head.next){
      return head;
    }
    ListNode next = head.next;
    ListNode newHead = reverse_2(next);
    next.next = head;
    head.next = null;
    return newHead;
  }

  /**
   * 3.环形链表
   * @param head
   * @return
   */
  public static ListNode cycle(ListNode head){
    ListNode slow = head;
    ListNode fast = head;
    while (null != fast && null != fast.next){
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast){//相遇有环
        slow = head;
        while (slow != fast){
          slow = slow.next;
          fast = fast.next;
        }
        return slow;
      }
    }
    return null;
  }

}
