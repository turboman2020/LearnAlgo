package CodeInterviews.src.RecursiveAndDP.Leetcode1143_LCS;

import java.util.Arrays;

public class Solution {
    static int [] [] memo;
    public static void main(String [] args){
        String text1 = "bl";
        String text2 = "yby";
        memo = new int [text1.length()+1][text2.length()+1];
        for(int [] arr : memo){
            Arrays.fill(arr, -1);
        }
        int res = longestCommonSubsequence(text1, text2);
        System.out.println(res);

    }

    public static int longestCommonSubsequence(String text1, String text2) {
//        return LCSHelperMem(text1,text2, 0,0);
        return LCSHelperDP(text1,text2);
    }

    public static int LCSHelper(String text1, String text2, int index1, int  index2) {

        if(index1 >= text1.length() || index2 >= text2.length()){
            return 0;
        }

        if( text1.charAt(index1) == text2.charAt(index2)) {
            return 1 + LCSHelper(text1, text2, index1 + 1, index2 + 1);
        } else{
            int left = LCSHelper(text1, text2, index1 , index2 + 1);
            int right = LCSHelper(text1, text2, index1 + 1, index2);
            return  Math.max( left , right);
        }
    }

    public static int LCSHelperMem(String text1, String text2, int index1, int  index2) {

        if(index1 >= text1.length() || index2 >= text2.length()){
            return 0;
        }

        if(memo[index1][index2] != -1) return memo[index1][index2];

        if( text1.charAt(index1) == text2.charAt(index2)) {
            memo[index1][index2] = 1 + LCSHelperMem(text1, text2, index1 + 1, index2 + 1);

        } else{
            int left = LCSHelperMem(text1, text2, index1 , index2 + 1);
            int right = LCSHelperMem(text1, text2, index1 + 1, index2);
            memo[index1][index2] = Math.max( left , right);

        }

        return  memo[index1][index2];
    }

    public static int LCSHelperDP(String text1, String text2) {
        // memo[i][j] 表示 text1从[0 ... i],text2从[0 ... j]的最长公共字串的长度
        // memo[i][j] = memo[i-1][j-1] + 1 subject to text1.charAt(i-1) == text2.charAt(j-1)
        //            = Max( memo[i-1][j], memo[i][j-1])

        memo = new int [text1.length()+1][text2.length()+1];

        for(int i = 1; i <= text1.length(); i++){
            for(int j = 1; j <= text2.length(); j++){

                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    memo[i][j] = memo[i-1][j-1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
                }
            }
        }

//        for(int i = 0; i < memo.length; i++){
//            System.out.println(Arrays.toString(memo[i]));
//        }

        return memo[text1.length()][text2.length()];

    }
}
