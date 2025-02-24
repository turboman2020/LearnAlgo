package CodeInterviews.src.LeetcodeHot100.Part14_DP.Leetcode139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public  static  void  main(String [] args){
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean [] memo = new boolean [s.length() + 1];
        Arrays.fill(memo, false);
        memo[0] = true;
        int len = s.length();
        for(int i = 1; i <= len; i++){
            for(int j = 0; j< wordDict.size(); j++){
                if(!memo[i] && i >= wordDict.get(j).length() && memo[ i - wordDict.get(j).length()])
                    memo[i] = s.substring(i - wordDict.get(j).length(), i).equals(wordDict.get(j));
            }
        }

        return memo[len];
    }
}
