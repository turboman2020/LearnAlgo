package CodeInterviews.src.LeetcodeHot100.Part13_Heap;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String [] args){
        int [] nums = new int []{3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k ,(o1, o2) -> o2 - o1);
        for (int num : nums){
            heap.add(num);
        }
        for(int i = 1; i < k; i++)
            heap.poll();
        return heap.peek();
    }
}
