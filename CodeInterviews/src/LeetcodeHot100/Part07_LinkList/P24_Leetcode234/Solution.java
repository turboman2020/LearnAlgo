package CodeInterviews.src.LeetcodeHot100.Part07_LinkList.P24_Leetcode234;

import CodeInterviews.src.LeetcodeHot100.BaseDataStructure.ListNode;

import java.util.ArrayList;

public class Solution {
    public static void main(String [] args){

    }
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (head != null){
            arr.add(head.val);
            head = head.next;
        }
        int left = 0, right = arr.size()-1;
        while (left <= right){
            if(arr.get(left) == arr.get(right)){
                left ++;
                right --;
            } else {
                return false;
            }

        }
        return true;

    }
}
