package CodeInterviews.src.LeetcodeHot100.SlidingWindow.Leetcode3;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String [] args){
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int res = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();

        while (left <= right && right < s.length()){
            if(set.contains(s.charAt(right))){
                set.remove(s.charAt(left ++));
            } else {
                int curLen = right - left + 1;
                res =  res < curLen ? curLen : res;
                set.add(s.charAt(right ++));
            }
        }

        return res;
    }
}
