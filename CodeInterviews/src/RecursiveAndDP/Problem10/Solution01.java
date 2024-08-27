package CodeInterviews.src.RecursiveAndDP.Problem10;

import CodeInterviews.src.LinkList.Problem06.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Solution01 {

    public static void main(String[] args) {
        System.out.println(Fibonacci(40));
        System.out.println(FibonacciV2(40));
    }

    public static long Fibonacci(int n) {
        if(n == 0 || n == 1) return n;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static long FibonacciV2(int n) {
        int f0 = 0, f1 = 1;
        int fn = 0;
        for (int i = 2; i <= n ; i ++){
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;

    }

}