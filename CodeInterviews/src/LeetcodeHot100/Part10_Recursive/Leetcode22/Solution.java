package CodeInterviews.src.LeetcodeHot100.Part10_Recursive.Leetcode22;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    static List<String> res = new LinkedList<>();
    public static void main(String [] args){
        generateParenthesis(3);
    }

    public static List<String> generateParenthesis(int n) {
        backTrace(n , 0, 0, new StringBuffer(""));
        return res;
    }

    public static void backTrace(int n , int left, int right, StringBuffer curStr) {

        if(left == n && right == n ){
            res.add(curStr.toString());
            return ;
        }
        if(left < right || left > n || right > n)
            return ;


        curStr.append(")");
        backTrace(n, left, right+1, curStr);
        curStr.deleteCharAt(curStr.length()-1);

        curStr.append("(");
        backTrace(n, left+1, right, curStr);
        curStr.deleteCharAt(curStr.length()-1);

    }
}
