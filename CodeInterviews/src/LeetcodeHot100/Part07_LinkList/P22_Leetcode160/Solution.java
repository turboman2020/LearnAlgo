package CodeInterviews.src.LeetcodeHot100.Part07_LinkList.P22_Leetcode160;

import CodeInterviews.src.LeetcodeHot100.BaseDataStructure.ListNode;

public class Solution {
    public static void main(String [] args){

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode preA = headA;
        while (preA!=null) {
            lenA++;
            preA = preA.next;
        }

        int lenB = 0;
        ListNode preB = headB;
        while (preB!=null) {
            lenB++;
            preB = preB.next;
        }

        int lenDiff = lenA - lenB;

        if(lenDiff > 0) {
            for(int i = 0; i < lenDiff; i++)
                headA = headA.next;
        } else {
            for(int i = 0; i < -lenDiff; i++)
                headB = headB.next;
        }

        while (headA != null && headB != null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;

    }
}
