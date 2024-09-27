package CodeInterviews.src.Search.Problem11;


import java.util.Arrays;

public class Solution01 {

    public static void main(String[] args) {
        int [] nums = new int []{3,4,5,1,2};
        int [] nums2 = new int []{4,5,1,2,3};
        int [] nums3 = new int [] {1,0,1,1,1};
        int targetNum = findMinNum(nums3);
        System.out.println(targetNum);
    }

    public static int findMinNum(int [] nums) {
        int left = 0, right = nums.length-1;
        int mid = left; // 把排序数组前面0个元素半岛最后面的情况
        while(nums[left] >= nums[right]) {
            if(right - left == 1){
                mid = right;
                break;
            }
            mid = (left + right) / 2;
            // 数组中多个重复元素的情况
            if(nums[left] == nums[right] && nums[mid] == nums[right])
                return finMinNumInArray(nums, left, right);
             if( nums[left] <= nums[mid]) {
                 left = mid;
             }
             else if (nums[right] >= nums[mid]) {
                 right = mid;
             }
        }

        return nums[mid];

    }

    public static int finMinNumInArray(int [] nums, int l, int r) {
        int res = nums[l];
        for (int i = l; i < r; i++){
            if(nums[i] < res)
                res = nums[i];
        }
        return res;
    }



}