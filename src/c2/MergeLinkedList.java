package c2;

import common.ListNode;
import common.ListNodeUtil;

public class MergeLinkedList {

    public static void main(String[] args) {

        ListNode h1 = new ListNode(new int[]{1, 3, 5});
        ListNode h2 = new ListNode(new int[]{1, 2, 6, 6,8});
        ListNodeUtil.print(merge(h1, h2));

    }

    /**
     * merge 2 sorted linked list and make sure the merged result is also a sorted linked list
     * @param h1
     * @param h2
     * @return
     */
    public static ListNode merge(ListNode h1, ListNode h2){
//        if(null == h1){
//            return h2;
//        }
//        if(null == h2){
//            return h1;
//        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode p1 = h1;
        ListNode p2 = h2;
        while(null != p1 || null != p2){
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
            }else{
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        return dummy.next;

    }
}
