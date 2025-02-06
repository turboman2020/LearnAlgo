package CodeInterviews.src.LeetcodeHot100.Part07_LinkList.P28_Leetcode2;

import CodeInterviews.src.LeetcodeHot100.BaseDataStructure.ListNode;

public class Solution {
    public static void main(String [] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pos = 0;
        ListNode head = l1;
        ListNode pre = l1;
        while(l1 != null && l2 != null){
            int sum =  pos + l1.val + l2.val;
            pos = sum / 10;
            l1.val = sum % 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 == null){
            pre.next = l2;
            l1 = l2;
        }

        while(l1 != null){
            int sum =  pos + l1.val;
            pos = sum / 10;
            l1.val = sum % 10;
            pre = l1;
            l1 = l1.next;
        }
        if(pos != 0){
            pre.next = new ListNode(pos);
        }


        return head;

    }
}
