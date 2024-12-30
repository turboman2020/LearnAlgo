package CodeInterviews.src.RecursiveAndDP.Leetcode300_LIS;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    static int  res = 1;
    static int [] [] memo ;
    public static void main(String [] args){
        //10,9,2,5,3,7,101,18  4,10,4,3,8,9
        int [] nums = new int [] {4,10,4,3,8,9};
        lengthOfLIS(nums);
        System.out.println(res);
    }
    public static int lengthOfLIS(int[] nums) {
        // 回溯法： 无返回值
//        for(int i = 0; i < nums.length; i++)
//            lengthOfLIShelper(nums, i, 1);
//        return res;

        //递归法： 有返回值
//        res = lengthOfLISHelperV2(nums, -1, 0);
//        return res;

        // 记忆化搜索
//        memo = new int [nums.length][nums.length+1];
//        for(int i = 0; i < memo.length; i++)
//            Arrays.fill(memo[i], -1);
//
//        res = lengthOfLISHelperV3(nums, -1, 0);

        res = lengthOfLISHelperV4(nums);

        return res;


    }

    public static void lengthOfLIShelper(int[] nums, int index, int curRes) {
        if(index >= nums.length) return ;
        for(int i = index+1; i < nums.length; i++){
            if(nums[i] > nums[index]){
                lengthOfLIShelper(nums, i, curRes + 1 );
            }
        }
        res = res >= curRes ? res: curRes;

    }

    public static int lengthOfLISHelperV2(int[] nums, int preIndex, int curIndex) {
        if(curIndex >= nums.length)
            return 0;
        // 分支一： 不选择当前元素
        int leftLen = lengthOfLISHelperV2(nums, preIndex, curIndex + 1);

        // 分支二： 选择当前元素
        int rightLen = 0;
        if(preIndex < 0 || nums[preIndex] < nums[curIndex])
            rightLen = 1 + lengthOfLISHelperV2(nums, curIndex, curIndex+1);

        return leftLen > rightLen ? leftLen : rightLen;

    }


    public static int lengthOfLISHelperV3(int[] nums, int preIndex, int curIndex) {
        if(curIndex >= nums.length)
            return 0;

        // preIndex + 1 是因为 preIndex 初始值是 -1；
        if(memo[preIndex+1][curIndex] != -1)
            return memo[preIndex+1][curIndex];
        // 分支一： 不选择当前元素
        int leftLen = lengthOfLISHelperV3(nums, preIndex, curIndex + 1);

        // 分支二： 选择当前元素
        int rightLen = 0;
        if(preIndex < 0 || nums[preIndex] < nums[curIndex])
            rightLen = 1 + lengthOfLISHelperV3(nums, curIndex, curIndex+1);

        memo[preIndex+1][curIndex] = leftLen > rightLen ? leftLen : rightLen;

        return memo[preIndex+1][curIndex];

    }

    //dp memo[i] 表示 使用nums 中从[0 ... i ]的元素的最长子序列的最大长度
    // memo[i] = memo[i - j] + 1 subject to nums[i] > nums[j]
    public static int lengthOfLISHelperV4(int[] nums) {
        int [] memo = new int[nums.length+1];
        Arrays.fill(memo, 1); //每个元素本身可以构成长度为 1 的子序列
        int res = 1;

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j <= i; j ++){

                if(nums[j] < nums[i])
                    memo[i] = Math.max(memo[i], memo[j] +1);
            }

            res = Math.max(res, memo[i]);

        }
        return res;
    }





}
