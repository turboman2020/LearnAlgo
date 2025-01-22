package CodeInterviews.src.LeetcodeHot100.P12_leetcode76;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static void main(String [] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = minWindow(s, t);
        System.out.println(res);

    }
    public static String minWindow(String s, String t) {
            char [] sArr = s.toCharArray();
            int ansLeft = -1, ansRight = s.length();
            int less = 0;
            int [] cnt = new int [128];

            for(char c : t.toCharArray()){
                cnt[c] ++;
                less ++;
            }

            int left = 0;
            for(int right = 0; right < s.length(); right++){
                cnt[sArr[right]]--;
                if(cnt[sArr[right]] == 0)
                    less--;
                while (less == 0){
                    if(right - left < ansRight - ansLeft){
                        ansLeft = left;
                        ansRight = right;
                    }
                    if(cnt[sArr[left]] == 0)
                        less++;
                    cnt[sArr[left]]++;
                    left++;

                }

            }
            return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight+1);

    }

    public static boolean isCovered(int [] cntS, int [] cntT){
        for(int i = 'A'; i <= 'Z'; i++){
            if(cntS[i] < cntT[i])
                return false;
        }

        for(int i = 'a'; i <= 'z'; i++){
            if(cntS[i] < cntT[i])
                return false;
        }

        return true;

    }
}
