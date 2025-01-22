package CodeInterviews.src.LeetcodeHot100.P11_Leetcode239;

import java.util.*;

public class Solution {
    public static void main(String [ ] args){
        int [] nums = new int []{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int [] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int [] res = new int[nums.length - k +1];
        PriorityQueue<int []> queue = new PriorityQueue(new Comparator<int [] >() {

            @Override
            public int compare(int [] p1, int [] p2) {
                return p1[0] != p2[0] ?  p2[0] - p1[0]: p2[1] - p1[1];
            }
        });

        for(int i = 0; i < k; i++){
            queue.add(new int [] {nums[i], i});
        }
        int j = 0;
        res[j++] = queue.peek()[0];

        for(int i = k; i < nums.length; i++){
            queue.add(new int [] {nums[i], i});
            while (queue.peek()[1] <= i - k){
                queue.poll();
            }
            res[j++] = queue.peek()[0];
        }

        return res;

    }

    public static int[] maxSlidingWindowV2(int[] nums, int k) {
        //单调队列， 使用双端队列实现
        int [] res = new int[nums.length - k +1];
        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0; i < k; i++){
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()])
                dq.pollLast();
            dq.addLast(i);
        }

        res[0] = nums[dq.peekFirst()];

        for(int i = k; i < nums.length; i++){

            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()])
                dq.pollLast();
            dq.addLast(i);
            while (dq.peekFirst() <= i - k)
                dq.pollFirst();
            res[i-k + 1] = dq.peekFirst();
        }

        return res;

    }
}
