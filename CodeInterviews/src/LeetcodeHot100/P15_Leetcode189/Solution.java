package CodeInterviews.src.LeetcodeHot100.P15_Leetcode189;

import java.util.Arrays;

public class Solution {
    public static void main(String [] args){
        int [] nums = new int[] {1, 2};
        rotateV3(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
    public static void rotate(int[] nums, int k) {
        //  测试用例 37 / 38, 超时
        int i = 0;
        while (i < k){
            int curEle = nums[nums.length-1];
            int curIndex = nums.length-1;
            while(curIndex > 0){
                nums[curIndex] = nums[curIndex-1];
                curIndex--;
            }

            nums[curIndex] = curEle;
            i ++;
        }
    }

    public static void rotateV2(int[] nums, int k) {
        int kOpt = k % nums.length;
        int [] subArr2 = new int [kOpt];
        int j = 0;
        for(int i = nums.length - kOpt ; i < nums.length; i++){
            subArr2[j++] = nums[i];
        }
        for(int i = nums.length -1 -kOpt; i >= 0; i--){
            nums[i+kOpt] = nums[i];
        }
        for(int i = 0; i < subArr2.length; i ++){
            nums[i] = subArr2[i];
        }
    }

    public static void rotateV3(int[] nums, int k) {
        //分块翻转
        k = k % nums.length;
        reverseArr(nums, 0, nums.length-1);
        reverseArr(nums, 0, k-1);
        reverseArr(nums, k, nums.length-1);

    }
    public static void reverseArr(int[] nums, int left, int right) {

        while (left < right){
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
    }

}
