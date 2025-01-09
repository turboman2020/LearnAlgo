package CodeInterviews.src.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 4, 3};
        int[] result = nextGreaterElement(nums);
        System.out.println("右侧第一个更大元素: " + Arrays.toString(result));
    }
    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // 初始化结果为 -1
        Stack<Integer> stack = new Stack<>(); // 栈存储元素索引

        for (int i = 0; i < n; i++) {
            // 栈顶元素小于当前值时，弹出栈并记录结果
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i); // 当前元素索引入栈
        }

        return result;
    }
}
