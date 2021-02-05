package com.fuwu.good.common;

public class Printer {

    public static void print(ListNode head){
        StringBuffer bf = new StringBuffer();
        ListNode cur = head;
        while (null != cur){
            if(bf.length()  == 0){
                bf.append(cur.val);
            }else {
                bf.append("->").append(cur.val);
            }
            cur = cur.next;
        }
         System.out.println(bf.toString());
    }
}
