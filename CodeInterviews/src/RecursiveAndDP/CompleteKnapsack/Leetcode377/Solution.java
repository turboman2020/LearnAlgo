package CodeInterviews.src.RecursiveAndDP.CompleteKnapsack.Leetcode377;

import java.util.Arrays;

public class Solution {

    public static void  main(String [] args){
        int [] nums = new int[] {1, 2, 3};
        int target = 4;
        int res = combinationSum4V2(nums, target);
        System.out.println(res);
    }
    public static int combinationSum4(int[] nums, int target) {
        int  [] memo = new int [target+1];
        memo[0] = 1;
        //考虑元素顺序，元素可以重复使用，外层循环是目标数，内层循环为数组
        for(int i = 0; i <= target; i++ ){
            for(int j = 0; j < nums.length; j++){
                if(i >= nums[j])
                    memo[i] += memo[i- nums[j]];
            }
            System.out.println( Arrays.toString(memo));
        }

        return memo[target];
    }

    public static int combinationSum4V2(int[] nums, int target) {
        int n = nums.length;
        // dp[i][j] 表示使用前 i 个数字组成和为 j 的排列数
        int[][] dp = new int[n + 1][target + 1];

        // 初始化：目标为 0 时，只有一种方式（不选任何数字）
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // 遍历每个数字和目标值
        for (int j = 0; j <= target; j++) {
            for (int i = 1; i <= n; i++) {

                // 不使用第 i 个数字
                dp[i][j] = dp[i - 1][j];
                // 使用第 i 个数字
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[n][j - nums[i - 1]];
                }
            }
        }

        for(int [] num: dp)
            System.out.println(Arrays.toString(num));

        // 累加所有排列方式
        return dp[n][target];
    }
}
