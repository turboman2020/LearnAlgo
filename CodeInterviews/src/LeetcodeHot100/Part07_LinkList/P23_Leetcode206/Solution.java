package CodeInterviews.src.LeetcodeHot100.Part07_LinkList.P23_Leetcode206;

import CodeInterviews.src.LeetcodeHot100.BaseDataStructure.ListNode;

public class Solution {
    public static void main(String [] args){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode newHead = reverseList(head);
    }

    public static  ListNode reverseList(ListNode head) {
        if(head == null || head.next == null )
            return head;
        ListNode  node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
