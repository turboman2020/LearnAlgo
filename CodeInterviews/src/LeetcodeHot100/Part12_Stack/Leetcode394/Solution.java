package CodeInterviews.src.LeetcodeHot100.Part12_Stack.Leetcode394;

import java.util.Stack;

public class Solution {
    public static void main(String [] args){
        System.out.println(decodeString("abc3[cd]xyz"));
    }

    public static String decodeString(String s) {

        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        String str = "";
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9')
                num = num * 10 + (c -'0');
            else if(c =='['){
                numStack.push(num);
                strStack.push(c+"");
                num= 0;
            }
            else if(c >='a' && c <='z'){
                strStack.push(c+"");
            }

            else if(c==']'){
                int cnt = numStack.pop();
                String ss = strStack.pop();
                while(!ss.equals("[")){
                    str = ss + str;
                    ss = strStack.pop();

                }
                String tmp = "";
                for(int j = 0; j < cnt; j++)
                    tmp+=str;
                strStack.push(tmp);

                str="";
            }

        }
        String res = "";
        while (!strStack.isEmpty()){
            res = strStack.pop() + res;
        }
        return res;
    }
}
