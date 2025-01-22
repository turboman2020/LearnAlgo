package CodeInterviews.src.LeetcodeHot100.SlidingWindow.Leetcode3;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String [] args){

    }
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int res = 0;
        int left = 0;
        int right = 0;
        while (left <= right && right < s.length()){
            if(isChongfu(s, left, right)){
                left ++;
            } else {
                int curLen = right - left + 1;
                res =  res < curLen ? curLen : res;
                right ++;
            }
        }

        return res;
    }

    public boolean isChongfu(String s, int left, int right) {
        Set<Character> set = new HashSet<>();
        for(int i = left; i <= right; i++){
            if(set.contains(s.charAt(i)))
                return true;
            set.add(s.charAt(i));
        }
        return  false;
    }

}
