package CodeInterviews.src.LeetcodeHot100.Part11_binarySearch.Leetcode04;

public class Solution {
    public static void main(String [] args){
        int [] nums1 = new int [] {1,2};
        int [] nums2 = new int [] {3,4};

        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int left = 0, right = 0;
        int count = 0;
        int i = 0, j = 0;
        while (count <= len / 2){
            left = right;
            if(j >= nums2.length || (i < nums1.length  && j < nums2.length && nums1[i] <= nums2[j]))
                right = nums1[i++];
            else
                right = nums2[j++];
            count++;
        }

        if(len % 2 == 0)
            return (left + right) / 2.0;
        return right;

    }

}
