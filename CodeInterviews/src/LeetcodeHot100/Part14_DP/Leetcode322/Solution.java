package CodeInterviews.src.LeetcodeHot100.Part14_DP.Leetcode322;

import java.util.Arrays;

public class Solution {
    static int [] memo = null;
    public static void main(String [] args){
        int []coins = new int []{2};
        coinChange(coins, 3);
        System.out.println(Arrays.toString(memo));
    }

    public static int coinChange(int[] coins, int amount) {
        memo = new int [amount + 1];
        Arrays.fill(memo, amount+1);
        coinChangeHelper(coins,amount);
        return memo[amount] == amount+1 ? -1 : memo[amount];
    }

    public static int coinChangeHelper(int[] coins, int amount) {
        if(amount < 0)   return -1;
        if(amount == 0)  return 0;

        if(memo[amount] == Integer.MAX_VALUE){
            for(int i = 0; i < coins.length; i++){
                int tmp = coinChangeHelper(coins, amount - coins[i]);
                if(tmp > 0 && tmp < memo[amount])
                    memo[amount]=tmp;
            }
        }

        return memo[amount];
    }
}
