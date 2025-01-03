package CodeInterviews.src.RecursiveAndDP.CompleteKnapsack.Leetcode322;

import java.util.Arrays;

public class Solution {
    static int [] memo;
    public static void main(String [] args) {
//        int[] coins = new int[]{1,2,5};
//        int amount = 11;

        int[] coins = new int[]{2,5, 10 , 1};
        int amount = 27;

        int res = coinChange(coins, amount);
        System.out.println(res);


    }
    public static int coinChange(int[] coins, int amount) {
        // 方法一： 递归
//        int res = coinChangeHelper(coins, amount, coins.length-1);

        //方法二： 回溯
//        int res = coinChangeHelperV2(coins, amount);

        //方法三： 记忆化搜索
//        memo = new int [amount+1];
//        int res = coinChangeHelperMem(coins, amount, 0);

        //方法四： 二维DP
//        int res = coinChangeHelperDP(coins, amount);

        //方法四： 一维DP
        int res = coinChangeHelperDPV2(coins, amount);
        return res ==  Integer.MAX_VALUE ? -1:res;

    }

    public static int coinChangeHelper(int[] coins, int amount, int index) {
        if(amount == 0) return 0;
        if(index < 0 || amount < 0){
            return  Integer.MAX_VALUE;
        }

        int left = coinChangeHelper(coins, amount, index - 1);
        int right = coinChangeHelper(coins, amount - coins[index], index);
        right = right == Integer.MAX_VALUE ? Integer.MAX_VALUE  : right + 1;

        return left < right ? left : right;


    }

    public static int coinChangeHelperV2(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        if(amount < 0){
            return  Integer.MAX_VALUE;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i ++){
            int right = coinChangeHelperV2(coins, amount - coins[i]);
            right = right == Integer.MAX_VALUE ? Integer.MAX_VALUE: right + 1;
            res =  res > right ? right : res;
        }
        return res;
    }

    public static int coinChangeHelperMem(int[] coins, int amount, int index) {
        if(amount == 0) {
            return 0;
        }
        if(index > coins.length || amount < 0){
            return  -1;
        }
        if(memo[amount] != 0)
            return memo[amount];

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i ++){
            int cur = coinChangeHelperMem(coins, amount - coins[i], i);
            min = cur >= 0 && cur < min ? cur + 1 : min;

        }
        memo[amount] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount];

    }

    public static int coinChangeHelperDP(int[] coins, int amount) {
        //memo[i][j] 表示使用coins[0 ... i]凑成金额j所需要的最小金币数量
        int [][] memo = new  int[coins.length+1][amount+1];

        Arrays.fill(memo[0], amount + 1);

        // 金额为 0 时，不需要硬币
        for (int i = 0; i <= coins.length; i++) {
            memo[i][0] = 0;
        }

//        System.out.println(Arrays.toString(memo[0]));

        for(int i = 1; i <= coins.length; i++){
            for(int j = 0; j <= amount; j++){
                memo[i][j] = memo[i-1][j];

                if(j >= coins[i-1])
                    memo[i][j] = Math.min(memo[i][j], 1 + memo[i][j - coins[i-1]]);
            }
//            System.out.println(Arrays.toString(memo[i]));
        }
        return memo[coins.length][amount] > amount ? -1:memo[coins.length][amount];

    }


    public static int coinChangeHelperDPV2(int[] coins, int amount) {
        // memo[i] 表示使用凑成金额 j 所需的最小硬币数
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount+1);
        memo[0] = 0;
        // 动态规划填表
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {

                if (j >= coins[i - 1]) {
                    memo[j] = Math.min(memo[j], 1 + memo[j - coins[i - 1]]);
                }
            }

            // 打印当前状态
//            System.out.println("使用前 " + i + " 个硬币的动态规划表:");
            System.out.println(Arrays.toString(memo));
        }

        // 如果结果超过 amount，说明不可达
        return memo[amount] > amount ? -1 : memo[amount];
    }

}
