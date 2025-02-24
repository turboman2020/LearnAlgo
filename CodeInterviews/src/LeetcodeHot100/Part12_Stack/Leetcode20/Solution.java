package CodeInterviews.src.LeetcodeHot100.Part12_Stack.Leetcode20;

import java.util.Stack;

public class Solution {
    public static void main(String [] args){
        System.out.println(isValid("(){}}{"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i = 1; i < s.length();i++){
            char curCh = s.charAt(i);
            if( curCh == '(' || curCh == '[' || curCh == '{')
                stack.push(s.charAt(i));
            else{
                char top = stack.pop();
                if((curCh == ')' && top == '(') ||
                        (curCh == ']' && top == '[') ||
                        (curCh == '}' && top == '{') )
                    continue;
                else
                    return false;

            }
        }

        return s.isEmpty();
    }
}
