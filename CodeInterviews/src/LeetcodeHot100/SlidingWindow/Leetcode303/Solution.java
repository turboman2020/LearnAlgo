package CodeInterviews.src.LeetcodeHot100.SlidingWindow.Leetcode303;

class NumArray {
    int [] preSum;
    public NumArray(int[] nums) {
        //preNum[i] 表示 nums 数组中下标从[0 ... i-1]的元素和；
        this.preSum = new int [nums.length + 1];

        for(int i = 1; i < nums.length+1; i++)
            this.preSum[i] = this.preSum[i-1] + nums[i-1];
    }

    public int sumRange(int left, int right) {
            return this.preSum[right + 1 ] - preSum[left];
    }

    public static void main(String [] args){
        int [] nums = new int [] {-2, 0, 3, -5, 2, -1};
        NumArray arr = new NumArray(nums);
        System.out.println(arr.sumRange(0, 2));
        System.out.println(arr.sumRange(2, 5));

    }

}
