package CodeInterviews.src.RecursiveAndDP.KnapsackProblem;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class Solution03 {
    static int[] memo;
    public static void main(String[] array) {
        List<String> wordDict = asList("leet", "code");
        System.out.println(wordBreakDP( "leetcode", wordDict));
    }

    public static boolean wordBreakDP(String s, List<String> wordDict) {
        // memo[i][j] 表示 s从[0 ... i]的字串是否能被 wordDcit [0 ... j]的单词拆分
        boolean [] memo = new boolean [s.length()+1];
        memo[0] = true;
        for(int i = 1; i <= s.length(); i ++){
            for(int j = 0; j < wordDict.size(); j++){
                String curWord = wordDict.get(j);
                int curLen = curWord.length();
                if( i >= curLen && memo[i - curLen] && !memo[i])
                    memo[i] = memo[i - curLen] && (curWord.equals(s.substring(i - curLen, i)));
            }
            System.out.println(Arrays.toString(memo));
        }

        return memo[s.length()];
    }


    public static  boolean wordBreak(String s, List<String> wordDict) {
        memo = new int [s.length()+1];
        Arrays.fill(memo, -1);
        wordBreakHelper(s, wordDict, 0);
        return memo[0] == 1 ? true : false;
    }

    public static boolean wordBreakHelper(String s, List<String> wordDict, int index) {

        if(index >= s.length())
            return true;

        if(memo[index] == -1) {
            for(int i = 0; i < wordDict.size(); i++){
                String curWord = wordDict.get(i);
                int len = curWord.length();

                if( memo[index] != 1 && index + len <= s.length() && s.substring(index, index + len).equals(curWord)){
                    System.out.println(curWord + ", " + s.substring(index, index + len));
                    memo[index] = wordBreakHelper(s, wordDict, index + len) ? 1: 0;
                }
            }
        }


        return memo[index] == 1 ? true : false;

    }

}