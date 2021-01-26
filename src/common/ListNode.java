package common;

public class ListNode {
    public  int val;
    public  ListNode next;
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int[] vals){
        this.val = vals[0];
        ListNode pre = this;
        for(int i = 1; i < vals.length; i++){
            ListNode node = new ListNode(vals[i]);
            pre.next = node;
            pre = node;
        }
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
