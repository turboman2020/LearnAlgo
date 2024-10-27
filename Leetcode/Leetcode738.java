package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode738 {


    public static void main(String [] args) {
        int res = new Leetcode738().monotoneIncreasingDigits(332);
        System.out.println(res);
    }

    public int monotoneIncreasingDigits(int n) {
        StringBuilder strNum = new StringBuilder(""+n);
        int flag = strNum.length();
        for(int i = strNum.length()-1; i>0; i--){
            if(strNum.charAt(i-1) > strNum.charAt(i)){
                flag = i;
                char ch = (char)(strNum.charAt(i-1)-'1'+'0');
                strNum.setCharAt(i-1,(char) ch);

            }
        }
        for(int i = flag; i < strNum.length(); i++){
            strNum.setCharAt(i,'9');
        }
        return Integer.valueOf(strNum.toString());
    }
}