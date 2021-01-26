package c2;

import common.ListNode;
import common.ListNodeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListCut {
    public static void main(String[] args) {
//        ListNode head = new ListNode(new int[]{});
        List<ListNode> result = cut_2(null, 5);
        for(ListNode node:  result){
            if(null  == node){
                System.out.println("NULL");
            }else {
                ListNodeUtil.print(node);
            }

        }

    }
    /**
     *从链表头部开始截取长度<=k的链表
     */
    public static ListNode[] cut(ListNode head, int k){
        ListNode[] result = new ListNode[2];
        if(null == head){
            return result;
        }
        int i = 1;
        ListNode cur = head;
        while (i < k && null != cur){
            cur = cur.next;
            i++;
        }
        if(null != cur){
            result[1] = cur.next;
            cur.next  =  null;
        }
        result[0] = head;
       return result;
    }

    public static List<ListNode> cut_2(ListNode head, int k){
        int size = 0;
        ListNode cur = head;
        while (null != cur){
            size++;
            cur = cur.next;
        }
        int[] subSizes = new int[k];
        int s1 =  size / k;
        int s2 = size % k;
        Arrays.fill(subSizes, s1);
        int i = 0;
        while (s2 > 0){
            subSizes[i]++;
            i++;
            s2--;
        }
        List<ListNode> result = new ArrayList<>();
        for(int j = 0; j < subSizes.length;  j++){
            if(subSizes[j] ==  0){
                result.add(null);
            }else {
                ListNode[] nodes = cut(head, subSizes[j]);
                result.add(nodes[0]);
                head = nodes[1];
            }
        }
        return  result;
    }
}
