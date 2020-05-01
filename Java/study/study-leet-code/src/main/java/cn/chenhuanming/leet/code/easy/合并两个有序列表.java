package cn.chenhuanming.leet.code.easy;

import cn.chenhuanming.leet.code.common.ListNode;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 合并两个有序列表 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.createList(1,2,4);
        ListNode l2 = ListNode.createList(1,3,4);

        合并两个有序列表 instance = new 合并两个有序列表();

        ListNode result = instance.mergeTwoLists(l1, l2);
        System.out.println(result.getString());
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p,q;
        p = new ListNode(-1);
        q = p;
        while (l1 != null && l2 != null){
            if(l1.val<l2.val){
                q.next = l1;
                l1 = l1.next;
            }else{
                q.next = l2;
                l2 = l2.next;
            }
            q = q.next;
        }
        q.next = l1==null?l2:l1;
        return p.next;
    }
}
