package CodeInterviews.src.LeetcodeHot100.Part10_Recursive.Leetcode131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    static List<List<String>> res = new LinkedList<>();

    public static void main(String [] args){
        partition("aab");
        System.out.println(Arrays.toString(res.toArray()));
    }

    public static List<List<String>> partition(String s) {
        partition(s, 0, new LinkedList<>());
        return res;
    }

    public static void partition(String s, int index, LinkedList<String> curRes) {
        if(index == s.length()) {
            res.add(new ArrayList<>(curRes));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(isValid(s, index, i)){

                curRes.add(s.charAt(i)+"");
                partition(s, i+1, curRes);
                curRes.removeLast();
            }
        }

    }

    public static boolean isValid(String s, int start, int end){

        for(int i = start, j = end; i < j; i++,j--){
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}
