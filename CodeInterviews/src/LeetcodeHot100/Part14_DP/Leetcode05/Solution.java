package CodeInterviews.src.LeetcodeHot100.Part14_DP.Leetcode05;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public  static  void  main(String [] args){

        System.out.println(longestPalindrome("cbbd"));
    }
    public static String longestPalindrome(String s) {
        //memo[i][j]表示s从[i, j]的字串是回文串
        int n = s.length();
        boolean [] [] memo = new boolean [n][n];

        String res = "";
        for(int i = n-1; i >= 0 ; i--){
            for(int j = i; j < n; j++){

                memo[i][j] = s.charAt(j) == s.charAt(i) &&(j - i <= 1|| memo[i+1][j-1]);
                if(memo[i][j] && (j - i + 1 > res.length()))
                    res = s.substring(i, j+1);
            }

        }

        return res;

    }
}
