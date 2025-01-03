package CodeInterviews.src.RecursiveAndDP.KnapsackProblem01.Leetcode416;

import java.util.Arrays;

public class Solution {

    public static void main(String [] args){
//        int [] nums = {1, 5, 11, 5};
        int [] nums = {1, 5, 10, 6};
        boolean res = canPartition(nums);
        System.out.println(res);

        res = canPartition1(nums);
        System.out.println(res);
    }

    public static boolean canPartition(int[] nums) {

        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;

        int C = sum / 2;

        // memo[i][j] 表示数组中[0 ... i] 元素和是否等于 j
        boolean [][] memo = new boolean [nums.length][C + 1];
        for(int j = 0 ; j <= C; j++)
            memo[0][j] = nums[0] == j ? true : false;

        for(int i = 1; i  < nums.length; i++) {
            for(int j = C; j >= 0; j--){
                memo[i][j] = nums[i] == j ? true: memo[i-1][j];
                if(j >= nums[i])
                    memo[i][j] = memo[i][j] || memo[i-1][j - nums[i]];
            }

        }
        for (boolean [] tmp : memo) System.out.println(Arrays.toString(tmp));
        return memo[nums.length-1][C];

    }


    public static boolean canPartition1(int[] nums) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum % 2 != 0) return false;

        int C = sum / 2;
        boolean [] memo = new boolean [C + 1];
        for(int i = 0; i <= C ; i++){
            memo[i] = nums[0] == i;
        }
//        System.out.println(Arrays.toString(memo));
        for(int i = 1; i  < nums.length; i++) {
            for(int j = C; j >= nums[i]; j--)
                memo[j] = (nums[i] == j ) || memo[j] || memo[j - nums[i]];
//            System.out.println(Arrays.toString(memo));
        }
        return memo[C];

    }

}
