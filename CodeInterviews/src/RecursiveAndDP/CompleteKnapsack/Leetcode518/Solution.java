package CodeInterviews.src.RecursiveAndDP.CompleteKnapsack.Leetcode518;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void  main(String [] args){
        int [] nums = new int[] {1, 2, 5};
        int target = 5;
        int res = changeV2(nums, target);

        System.out.println(res);
        res = changeV2(nums, target);
        System.out.println(res);

    }
    public static int change(int[] nums, int target) {
        int  [] memo = new int [target+1];
        memo[0] = 1;
        //不考虑元素顺序，元素可以重复使用，外层循环是数组，内层循环是目标数
        for(int i = 0; i < nums.length; i++){
            for(int j = 0;j <= target; j++ ){
                if(j >= nums[i])
                    memo[j] += memo[j- nums[i]];
            }
            System.out.println( Arrays.toString(memo));
        }

        return memo[target];
    }

    public static int changeV2(int[] nums, int target) {
        int  [][] memo = new int [nums.length+1] [target+1];

        for(int i = 0; i <= nums.length; i++){
            memo[i][0] = 1;
        }
        System.out.println( Arrays.toString(memo[0]));
        //不考虑元素顺序，元素可以重复使用，外层循环是数组，内层循环是目标数
        for(int i = 1; i <= nums.length; i++){
            for(int j = 0;j <= target; j++ ){
                memo[i][j] =  memo[i-1][j];
                if(j >= nums[i-1])
                    memo[i][j] += memo[i][j- nums[i-1]];
            }
            System.out.println( Arrays.toString(memo[i]));
        }

        return memo[nums.length][target];
    }

    public static int changeV3(int[] nums, int target) {
        int  [][] memo = new int [nums.length] [target+1];
        for(int j = 0; j <= target; j++){
            if( j % nums[0] == 0)
                memo[0][j] = 1;
        }

        System.out.println( Arrays.toString(memo[0]));
        //不考虑元素顺序，元素可以重复使用，外层循环是数组，内层循环是目标数
        for(int i = 1; i < nums.length; i++){
            for(int j = 0;j <= target; j++ ){
                memo[i][j] =  memo[i-1][j];
                if(j >= nums[i])
                    memo[i][j] += memo[i][j- nums[i]];
            }
            System.out.println( Arrays.toString(memo[i]));
        }

        return memo[nums.length-1][target];
    }
}