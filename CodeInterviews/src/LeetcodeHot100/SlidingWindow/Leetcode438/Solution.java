package CodeInterviews.src.LeetcodeHot100.SlidingWindow.Leetcode438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String [] args){
       String s = "bpaa";
       String p = "aa";
       List<Integer> res = findAnagrams(s, p);
       System.out.println(Arrays.toString(res.toArray()));

    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length()) return res;
        int pLen = p.length();
        int [] count = new int [26];
        for(int i = 0; i < pLen; i++){
            count[p.charAt(i) - 'a'] ++;
            count[s.charAt(i) - 'a'] --;
        }
        int diff = 0;
        for(int i = 0; i < 26; i++){
            if(count[i] != 0)
                diff++;
        }
        if(diff == 0) res.add(0);

        for(int i = p.length(); i < s.length(); i++){
            if(count[s.charAt(i-pLen)-'a'] == 0){
                diff++;
            }else if(count[s.charAt(i-pLen)-'a'] == -1){
                diff--;
            }
            count[s.charAt(i-pLen)-'a']++;

            if(count[s.charAt(i)-'a'] == 0){
                diff++;
            } else if(count[s.charAt(i)-'a'] == 1){
                diff--;
            }
            count[s.charAt(i)-'a']--;

            if(diff == 0)
                res.add(i-pLen+1);

        }

        return res;

    }
}
