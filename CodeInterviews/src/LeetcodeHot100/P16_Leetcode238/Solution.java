package CodeInterviews.src.LeetcodeHot100.P16_Leetcode238;

import java.util.Arrays;

public class Solution {
    public static void main(String [] args){
        int [] nums = new int [] {1,2,3,4};
        int [] res = productExceptSelfV2(nums);
        System.out.println(Arrays.toString(res));

    }
    public static int[] productExceptSelf(int[] nums) {
        int [] left = new int [nums.length];
        int [] right = new int [nums.length];
        left[0] = 1;
        right[nums.length-1] = 1;
        for(int i = 1; i < nums.length; i++){
            left[i] = left[i-1] * nums[i-1];
            right[nums.length - i -1] = right[nums.length - i] * nums[nums.length - i];
        }
        int [] res = new int[nums.length];
        for(int i = 0; i < res.length; i++)
            res[i] = left[i] * right[i];
        return res;
    }

    public static int[] productExceptSelfV2(int[] nums) {
        int [] res = new int [nums.length];
        res[0] = 1;

        for(int i = 1; i < nums.length; i++){
            res[i] = res[i-1] * nums[i-1];

        }

        int r = 1;
        for(int i = nums.length - 1 ; i >= 0; i--){

            res[i]  *=  r ;
            r *= nums[i];
        }

        return res;
    }
}
