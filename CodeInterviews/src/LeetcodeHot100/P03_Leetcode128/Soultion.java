package CodeInterviews.src.LeetcodeHot100.P03_Leetcode128;

import java.util.*;

public class Soultion {

    public static void main(String [] args){
        int [] nums = new int [] {100,4,200,1,3,2};
//        int [] nums = new int [] {0,3,7,2,5,8,4,6,0,1};
        int res = longestConsecutive(nums);
        System.out.println(res);
    }

    public static int longestConsecutive(int[] nums) {
        int maxLen = 1;

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
           set.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++){

            if(!set.contains(nums[i]-1)) {
                int len = 0;
                while(set.contains(nums[i] + len)){
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }

        }
        return maxLen;
    }
}
