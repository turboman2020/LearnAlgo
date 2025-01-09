package CodeInterviews.src.RecursiveAndDP.Leetcode72;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    static Map<String, Integer> cache = new HashMap<>();
    public static void main(String [] args){
        minDistance("horse", "ros");
//        minDistance("intention", "execution");
    }
    public static int minDistance(String word1, String word2) {
        int res = minDistanceHelperDP(word1, word2);

        System.out.println(res);
        return res;
    }

    public static int minDistanceHelper
            (String word1, String word2, int index1, int index2) {
        if(index1 == word1.length() || index2 == word2.length()){
            return word1.length() + word2.length() - index1 - index2;
        }

        if(word1.charAt(index1) == word2.charAt(index2)) {
            return minDistanceHelper(word1, word2, index1 + 1, index2 + 1);
        }else {
            int del = 1 + minDistanceHelper(word1, word2,  index1+1, index2);
            int insert = 1 + minDistanceHelper(word1, word2,  index1, index2+1);
            int replace = 1 + minDistanceHelper(word1, word2, index1+1, index2 + 1);
            return Math.min(replace, Math.min(del, insert));
        }

    }

    public static int minDistanceHelperMem(String word1, String word2, int index1, int index2) {
        if(index1 == word1.length() || index2 == word2.length()){
            cache.put(index1+"_"+index2, word1.length() + word2.length() - index1 - index2);
            return cache.get(index1+"_"+index2);
        }
        if(cache.containsKey(index1+"_"+index2)){
            return cache.get(index1+"_"+index2);
        }
        if(word1.charAt(index1) == word2.charAt(index2)) {
            cache.put(index1+"_"+index2, minDistanceHelperMem(word1, word2, index1 + 1, index2 + 1));
        }else {
            int del = 1 + minDistanceHelperMem(word1, word2,  index1+1, index2);
            // word 在index1 之前插入word2.chatAt(index2)的字符，
            // 但实际未插入，因此word1要对比的下一个的索引还是index1， 与 word2的下一个索引index2+1 对比
            int insert = 1 + minDistanceHelperMem(word1, word2,  index1, index2+1);
            int replace = 1 + minDistanceHelperMem(word1, word2, index1+1, index2 + 1);
            cache.put(index1+"_"+index2, Math.min(replace, Math.min(del, insert)));
        }
        return cache.get(index1+"_"+index2);

    }

    public static int minDistanceHelperDP(String word1, String word2) {
        int [] [] memo = new int [word1.length()+1] [word2.length()+1];

        for(int i = 0; i <= word1.length(); i++){
            memo[i][0] = i ;
        }

        for(int j = 0; j <= word2.length(); j++){
            memo[0][j] = j ;
        }

        System.out.println(Arrays.toString(memo[0]));
        for(int i = 1; i <= word1.length(); i++){
            for(int j = 1; j <= word2.length(); j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    memo[i][j] = memo[i-1][j-1];
                } else{
                    memo[i][j] = 1 + Math.min(memo[i-1][j-1], Math.min(memo[i][j-1], memo[i-1][j]));
                }
            }
            System.out.println(Arrays.toString(memo[i]));
        }
        return memo[word1.length()][word2.length()];

    }

}
