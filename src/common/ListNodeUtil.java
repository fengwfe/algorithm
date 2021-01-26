package common;

public class ListNodeUtil {
    public static void print(ListNode head){
        StringBuffer bf = new StringBuffer();
        ListNode node = head;
        while(null != node){
            bf.append(",").append(node.val);
            node = node.next;
        }
        System.out.println(bf);
    }
}
