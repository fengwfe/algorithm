package common;

import java.util.List;

public class Printer {
    public static void main(String[] args) {

    }
    public static void print(Object[] array){
        StringBuffer bf = new StringBuffer();
        for(Object o: array){
            bf.append(",").append(o);
        }
        System.out.println(bf);
    }
    public static void print(ListNode head){
        ListNode node = head;
        StringBuffer bf = new StringBuffer();
        while (null != node){
            bf.append(",").append(node.val);
            node = node.next;
        }
        System.out.println(bf);
    }
    public static void print(List list){
        System.out.println(list);
    }
}
