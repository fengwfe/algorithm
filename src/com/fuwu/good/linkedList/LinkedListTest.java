package com.fuwu.good.linkedList;


import com.fuwu.good.common.ListNode;

/**
 * 1.merge 2 sorted linked lists
 * 2.odd even
 * 3.reverse（迭代,递归）
 * 4.reverse前K个节点
 * 5.reverse m 到 n之间的几点[m, n]
 * 6.reverse,k个一组反转  TODO
 * 7.倒数第K个节点
 * 8.中间节点
 * 9.判断链表是否有环
 * 10.环形链表的环起点
 * 11.链表排序
 * 12.判断回文链表
 *
 */
public class LinkedListTest {
    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
//        head.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l2;
//        System.out.println(cycleStartNode(head));
       ListNode head = new ListNode(new int[]{1,2});
        System.out.println(isPalindrome(head));

    }
    /**
     * 1.merge 2 sorted linked lists
     */
    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (null != l1 || null != l2){
            if(null == l1){
                cur.next = l2;
                return dummy.next;
            }else if(null == l2){
                cur.next = l1;
                return dummy.next;
            }else{
                if(l1.val < l2.val){
                    cur.next = l1;
                    l1 = l1.next;
                    cur = cur.next;
                }else{
                    cur.next = l2;
                    l2 = l2.next;
                    cur = cur.next;
                }
            }
        }
        return dummy.next;
    }
    /**
     * 2.odd even
     */
    public static ListNode oddEven(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        ListNode dummyOdd = new ListNode(-1);
        ListNode dummyEven = new ListNode(-1);
        ListNode curOdd = dummyOdd;
        ListNode curEven = dummyEven;
        ListNode cur = head;
        int i = 1;
        while (null != cur){
            if(i % 2 == 0){
                curEven.next = cur;
                curEven = curEven.next;
            }else{
                curOdd.next = cur;
                curOdd = curOdd.next;
            }
            cur = cur.next;
            i++;
        }
        curOdd.next = dummyEven.next;
        curEven.next = null;
        return dummyOdd.next;
    }
    /**
     * 3.reverse
     * 迭代方式
     */
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
    /**
     * 3.reverse
     * 递归
     *
     */
    public static ListNode reverse_02(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        ListNode next = head.next;
        ListNode node = reverse_02(next);
        next.next = head;
        head.next = null;
        return node;
    }
    /**
     * 4.reverse前K个节点
     */
    public static ListNode reverseKNodes(ListNode head, int k){
        ListNode cur = head;
        ListNode kNext = null;
        int i = 1;
        while (null != cur && i < k){
            cur = cur.next;
            i++;
        }
        if(i < k){
            return head;//不满K个节点就直接不做反转了
        }
        kNext = cur.next;
        cur = head;
        ListNode dummy = new ListNode(-1);
        while (cur != kNext){
            ListNode dummyNext = dummy.next;
            ListNode curNext = cur.next;
            dummy.next = cur;
            cur.next = dummyNext;
            cur = curNext;
        }
        //反转后head就变成反转部分的尾节点了
        head.next = kNext;
        return dummy.next;
    }
    /**
     * 5.reverse m 到 n之间的几点[m, n]
     */
    public static ListNode reverseMN(ListNode head, int m, int n){
        ListNode preM = null;
        ListNode mNode = head;
        ListNode nNode = null;
        ListNode nNodeNext = null;
        int i = 1;
        int j = 1;
        while (null != mNode && i < m){
            preM = mNode;
            mNode = mNode.next;
            i++;
        }
        if(i < m){
            return head;
        }
        nNode = mNode;
        j = m;
        while (null != nNode && j < n){
            nNode = nNode.next;
            j++;
        }
        if(j < n){
           return head;
        }
        nNodeNext = nNode.next;
        ListNode reversedNode = reverse(mNode, nNodeNext);
        if(null == preM){
            mNode.next = nNodeNext;
            return reversedNode;
        }else{
            preM.next = reversedNode;
            mNode.next = nNodeNext;
            return head;
        }
    }

    /**
     *反转[m, n)
     */
    public static ListNode reverse(ListNode m, ListNode n){
        ListNode dummy = new ListNode(-1);
        ListNode cur = m;
        while (cur != n){
            ListNode dummyNext = dummy.next;
            ListNode curNext = cur.next;
            dummy.next = cur;
            cur.next = dummyNext;
            cur = curNext;
        }
        return dummy.next;
    }
    /**
     * 6.reverse,k个一组反转
     * TODO
     */
    public static ListNode reverseKGroup(ListNode head){
        return null;

    }
    /**
     * 7.倒数第K个节点
     */
    public static ListNode kthNode(ListNode head, int k){
        int i = 0;
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && i < k){
            i++;
            fast = fast.next;
        }
        if(i < k){//总节点数不满k个
            return null;
        }
        while (null != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    /**
     * 8.中间节点
     */
    public static ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && null != fast.next){
            slow = slow.next;
            fast = fast.next.next;
        }
        /**
         * 1.节点个数为奇数数slow正好在中间位置，节点个数为偶数时slow在偏右的位置
         * 2.可以通过fast是否为null判断出节点个数是偶数还是奇数
         */
        return slow;

    }
    /**
     * 9.判断链表是否有环
     */
    public static boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && null != fast.next){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    /**
     * 10.环形链表的环起点
     */
    public static ListNode cycleStartNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && null != fast.next){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;

            }
        }
        //没有环的话，返回Null
        return null;
    }
    /**
     * 11.链表排序
     */
    public static ListNode mergeSort(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        if(null == head.next.next){//只有2个节点
           if(head.next.val < head.val){
               ListNode next = head.next;
               next.next = head;
               head.next = null;
               return next;
           }else {
               return head;
           }

        }
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && null != fast.next){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode slowNext = slow.next;
        slow.next = null;
        ListNode left = mergeSort(head);
        ListNode right =  mergeSort(slowNext);
        ListNode newHead = merge(left, right);
        return newHead;
    }

    /**
     * 12.判断回文链表
     */
    public static boolean isPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && null != fast.next){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(null != fast){
            slow = slow. next;
        }
        ListNode dummy = new ListNode(-1);
        while (null != slow){
            ListNode dummyNext = dummy.next;
            ListNode slowNext = slow.next;
            dummy.next = slow;
            slow.next = dummyNext;
            slow = slowNext;
        }
        ListNode right = dummy.next;
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
