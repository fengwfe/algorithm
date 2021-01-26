package c2;

import common.ArrayUtil;
import common.ListNode;
import common.ListNodeUtil;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] data = {0,0,1,2,2,3,3};
//        System.out.println(removeDuplicates(data));
//        ArrayUtil.print(data);

        ListNode head = new ListNode(data);
        ListNodeUtil.print(head);
        head = removeDuplicates(head);
        ListNodeUtil.print(head);
    }

    /**
     * 有序数组中删除重复元素，返回新数组的长度
     */
    public static int removeDuplicates(int[] data){
        if(null == data || data.length == 0){
            return 0;
        }
        int slow = 0;
        int fast = 1;
        while (fast < data.length){
            if(data[fast] != data[slow]){
                 data[++slow] = data[fast];
            }
            fast++;
        }
        return slow + 1;
    }
    /**
     * 有序链表中删除重复元素
     */
    public static ListNode removeDuplicates(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (null != fast){
            if(fast.val != slow.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;//容易漏掉
        return head;
    }

}
