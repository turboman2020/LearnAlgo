package CodeInterviews.src.LeetcodeHot100.Part14_DP.Leetcode279;

public class Solution {
    static int res = 0;
    public  static void main(String [] args){
        numSquares(12);
        System.out.println(res);
    }

    public static int numSquares(int n) {

        numSquares(n, 0);
        return res;

    }

    public static void numSquares(int n, int curCnt){
        if(n == 0){
            res = res <= curCnt ? res : curCnt;
        }
        for(int i = 1; i * i <= n; i++){
            curCnt += 1;
            numSquares( n - i * i, curCnt);
            curCnt -= 1;
        }

    }
}
