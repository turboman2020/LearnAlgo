package CodeInterviews.src.RecursiveAndDP.KnapsackProblem;

import java.util.Arrays;

public class Solution02 {
    static int [] [] memo;
    public static void main(String [] array){

        int [] weight = new int [] {6,5,6,6,3,7};
        int [] value = new int [] {5,6,4,6,5,2};
        int c = 15;

//        int [] weight = new int [] {1,2,3};
//        int [] value = new int [] {6,10,12};
//        int c = 5;
        int maxValue = knapsackProblem(weight, value, c);
        System.out.println(maxValue);
    }

    public static int knapsackProblem(int [] weight, int [] value, int c){
        if(weight == null || weight.length == 0) return 0;
        // DP方法， memo[i][j]表示遍历到第i个物品容量为j时的最大价值
        memo = new int[weight.length][c+1];

        for(int j = 0; j <= c; j++){
            if(j < weight[0]) {
                memo[0][j] = 0;
            } else {
                memo[0][j] = value[0];
            }
        }
        for(int i = 1 ;i < weight.length; i++){
            // 可以从 j = weight[i]开始遍历
            for(int j = 0; j <= c; j++){
                memo[i][j] = memo[i-1][j];
                if(weight[i] <= j) {
                    memo[i][j] = Math.max(memo[i][j], value[i] + memo[i-1][j-weight[i]]);
                }

            }
            System.out.println(Arrays.toString(memo[i]));

        }
        return memo[weight.length-1][c];

    }
}
