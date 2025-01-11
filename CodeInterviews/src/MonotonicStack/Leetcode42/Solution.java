package CodeInterviews.src.MonotonicStack.Leetcode42;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String [] args){
        int [] height = new int [] {0,1,0,2,1,0,1,3,2,1,2,1};
//        int [] height = new int [] {4,2,0,3,2,5};
//        int [] height = new int [] {2,0,2};
        int res = trapV4(height);
        System.out.println(res);

    }
    public static int trap(int[] height) {
        int maxNum = Arrays.stream(height).max().getAsInt();
        int res = 0;
        for(int i = 1; i <= maxNum; i++)
            res += levelTrap(height, i);
        return res;
    }

    public static int levelTrap(int[] height, int lel) {
        int lelSum = 0;
        //层序方法时间复杂度，取决于数组中的最大元素，通过319/324
        for(int i = 1; i + 1 < height.length; i++){
            if(height[i] == lel - 1){
                int left = i;
                while (left >= 0 && height[left] <= height[i])  left--;

                int right = i+1;
                while (right < height.length && height[right] <= height[i]) {
                    if(height[right] == lel-1){
                        right = i+1;
                        left = -1;
                        break;
                    }
                    right++;
                }

                if(left >=0 && right < height.length){
                    lelSum += right - left - 1;
                    height[i] = lel;
                }

            }

        }
        return lelSum;

    }

    public static int trapV2(int[] height) {
        //时间复杂度O(n^2), 通过 312/324
        int res = 0;
        for(int i = 0; i < height.length; i++){
            // 找左边和右边的最大高度
            int left = i, right = i;
           for(int j = 0; j < height.length;j ++){

               if(height[j] > height[left] && j < i)
                   left = j;

               if(height[j] > height[right] && j > i)
                   right = j;

           }

           res +=  Math.min(height[left], height[right]) - height[i];

        }
        return res;
    }


    public static int trapV3(int[] height) {
        //动态规划：
        // leftMax[i] 表示 数组中下标为i的左侧的最大元素
        // rightMax[i] 表示 数组中下标为i的右侧的最大元素
        // 下标i位置的接水量为 Math.min(leftMax[i], rightMax[i]) - height[i];
        int res = 0;
        int n = height.length;
        int [] leftMax = new int [n];
        int [] rightMax = new int [n];
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];

        for(int i = 1; i < n; i++){
            leftMax[i] =  height[i] > leftMax[i-1] ? height[i]: leftMax[i-1];
            rightMax[n-i-1] = height[n-i-1] > rightMax[n-i] ? height[n-i-1]: rightMax[n-i];
        }
        for(int i = 0; i < n; i++){
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    public static int trapV4(int[] height) {
        //单调栈： 令栈中的元素从栈底到栈顶递减， 栈中存储数组下标，通过单调栈构建接雨水区域
        // 设栈顶的元素为top，栈中top左侧的第一个元素left大于top, 对于新来的元素为下标为i，
        // 如果height[i]大于top，那么就构成了一个接雨水区域；
        // 此时，的雨水量为 计算：
        // 宽度： i - left - 1, 高度min(left, heigh[i]) - height[top]
        //  接水量 = 宽度 * 高度
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();

        for(int i = 0; i < height.length; i++){
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int curIndex = stack.pop();
                if(stack.isEmpty())
                    break;
                int left = stack.peek();
                int curWidth = i - left -1;
                int curheight =  Math.min(height[left], height[i]) - height[curIndex];
                res += curWidth * curheight;
            }
            stack.push(i);
        }

        return res;
    }


}
