package CodeInterviews.src.LeetcodeHot100.SlidingWindow;

import CodeInterviews.src.LeetcodeHot100.BaseDataStructure.ListNode;

public class Solution {
    public  static void main (String [ ] args){

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
                return null;
        int m = 0;
        ListNode ptr1 = head, ptr2 = head.next;
        while (++m < k && ptr2 != null){
            ptr1.next = ptr2.next;
            ptr2.next = head;
            head = ptr2;
            ptr2 = ptr1.next;
            m++;
        }
        if(m < k)
            return reverseKGroup(head, m);
        ptr1.next = reverseKGroup(ptr2, k);
        return head;
    }
}
