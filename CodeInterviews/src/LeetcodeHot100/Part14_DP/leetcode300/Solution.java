package CodeInterviews.src.LeetcodeHot100.Part14_DP.leetcode300;

public class Solution {
    public  static void main(String [] args){
        int [] nums = new int [] {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));

    }

    public static int lengthOfLIS(int[] nums) {
        int [] memo = new int [nums.length];
        int res = 1;
        memo[0] = 1;
        for(int i = 1; i < nums.length; i++){
            memo[i] = 1;
            for(int j = i; j >= 0;j--){
                if(nums[i] > nums[j])
                    memo[i] = Math.max(memo[i], memo[j] + 1);
            }
            res = Math.max(res, memo[i]);
        }
        return res;
    }
}
