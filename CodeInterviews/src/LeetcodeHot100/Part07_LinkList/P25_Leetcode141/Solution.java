package CodeInterviews.src.LeetcodeHot100.Part07_LinkList.P25_Leetcode141;
import CodeInterviews.src.LeetcodeHot100.BaseDataStructure.ListNode;

import java.util.HashSet;

public class Solution {
    public static void main(String [] args){

    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        while (head != null) {
            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;

    }

    public boolean hasCycleV2(ListNode head) {
       ListNode slow = head;
       ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;

    }
}
