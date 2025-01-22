package CodeInterviews.src.LeetcodeHot100.P04_Leetcode283;

import java.util.Arrays;

public class Solution {
    public static void main(String [] args){
        int [] nums = new int [] {1,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int p1 = 0,p2=0;
        while(p1 < nums.length) {

            if(nums[p1] == 0){
                p2 = p1;
                while (p2 < nums.length && nums[p2] == 0) p2++;
                if(p2 < nums.length){
                    nums[p1] = nums[p2];
                    nums[p2] = 0;
                }

            }
            p1++;
        }



    }
}
