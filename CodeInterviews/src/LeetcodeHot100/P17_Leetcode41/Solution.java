package CodeInterviews.src.LeetcodeHot100.P17_Leetcode41;

import java.util.HashSet;

public class Solution {
    public static void main(String [] args){

    }

    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
            set.add(nums[i]);

        for(int i = 0; i <= nums.length; i++){
            if(!set.contains(i))
                return i;
        }
        return  nums.length + 1 ;

    }

    public int firstMissingPositiveV2(int[] nums) {

        for(int i = 0; i < nums.length; i++){
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }

        }

        for(int i = 0; i <= nums.length; i++){
            if(nums[i] != i + 1)
                return i;
        }
        return  nums.length + 1 ;

    }
}
