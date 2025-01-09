package CodeInterviews.src.MonotonicStack.Leetcode42;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String [] args){
        int [] height = new int [] {0,1,0,2,1,0,1,3,2,1,2,1};
//        int [] height = new int [] {4,2,0,3,2,5};
//        int [] height = new int [] {2,0,2};
        int res = trap(height);
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


}
