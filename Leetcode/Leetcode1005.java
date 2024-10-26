package Leetcode;

import java.util.Arrays;

/*
* 贪心算法：先将数组排序，如果有负数就依次反转，反转完后，如果 k > 0,
*     则选择此时数组中最小的正数反复反转；在数组反转完成后再求和；
*     如果在反转的过程中求和,在确定最小的数字时，易出错
* */

public class Leetcode1005 {


    public static void main(String [] args) {
        int [] nums = new int [] {-4,-2,-3};
        int res = largestSumAfterKNegations(nums,4);
        System.out.println(res);
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        Arrays.sort(nums);

        int minIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }

            minIndex = nums[minIndex] > nums[i]? i : minIndex;

        }
        if(k % 2  == 1) {
            nums[minIndex] = -nums[minIndex];
        }
        for(int i : nums){
            sum += i;
        }
        return sum;
    }
}
