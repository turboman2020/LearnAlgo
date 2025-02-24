package CodeInterviews.src.LeetcodeHot100.Part14_DP.Leetcode416;

import java.util.Arrays;

public class Solution {

    public static void main(String [] args){
        int [] nums = new int []{ 1,2,3,4,5,6,7};

        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0) return false;

        int C = sum / 2;
        boolean [] memo = new boolean [C + 1];
        for(int i = 0; i <= C ; i++){
            memo[i] = nums[0] == i;
        }

        for(int i = 1; i  < nums.length; i++) {

            for(int j = C; j >= nums[i]; j--)
                memo[j] = memo[j] || memo[j - nums[i]];
        }

        return memo[C];

    }
}
