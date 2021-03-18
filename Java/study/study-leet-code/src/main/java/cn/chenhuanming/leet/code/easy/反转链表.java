package cn.chenhuanming.leet.code.easy;

import cn.chenhuanming.leet.code.common.ListNode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode next;
        while (head != null && head.next != null) {
            next = head.next;
            head.next = next.next;
            next.next = dummyNode.next;
            dummyNode.next = next;
        }
        return dummyNode.next;
    }

}
