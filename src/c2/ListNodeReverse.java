package c2;

import common.ListNode;
import common.ListNodeUtil;

public class ListNodeReverse {
    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{1,2,3});
        ListNode newNode = reverse_3(node);
        ListNodeUtil.print(newNode);

    }

    /**
     * 递归方式反转
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        ListNode next = head.next;
        ListNode node = reverse(next);
        next.next = head;
        head.next = null;
        return  node;
    }

    /**
     * 非递归，头插法反转
     * @param head
     * @return
     */
    public static ListNode reverse2(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        ListNode tail = head;
        ListNode oldHead = head;
        while( tail.next!= null){
            ListNode next = tail.next;
            tail.next = next.next;
            next.next = oldHead;
            oldHead = next;
        }
        return oldHead;
    }

    public static ListNode reverse_3(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        while (null != cur){
            ListNode next = dummy.next;
            dummy.next = cur;
            cur = cur.next;
            dummy.next.next = next;
        }
        return dummy.next;
    }

}
