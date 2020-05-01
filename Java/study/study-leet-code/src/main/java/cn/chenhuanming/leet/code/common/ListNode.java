package cn.chenhuanming.leet.code.common;


public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode createList(int ... vals){
        ListNode result = null;
        ListNode p = null;
        for (int i = 0; i < vals.length; i++) {
            if(i==0){
                result = new ListNode(vals[i]);
                p = result;
            }else{
                p.next = new ListNode(vals[i]);
                p = p.next;
            }
        }
        return result;
    }

    public String getString() {
        StringBuilder builder = new StringBuilder();
        ListNode p = this;
        while (p != null){
            builder.append(p.val).append(" ");
            p = p.next;
        }
        return builder.toString();
    }
}