package CodeInterviews.src.LeetcodeHot100.Part11_binarySearch.Leetcode04;

public class Solution2 {
    public static void main(String [] args){
        int [] nums1 = new int [] {1,2,3,4,5};
        int [] nums2 = new int [] {6,7,8,9,10,11,12,13,14,15,16,17};

        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totallen = nums1.length + nums2.length;

        if(totallen % 2  == 0)
            return 0.5 * (getKthEle(nums1, 0, nums2, 0, totallen / 2) +
                    getKthEle(nums1, 0, nums2, 0, totallen / 2 + 1));
        else
            return getKthEle(nums1, 0, nums2, 0, totallen / 2 + 1);
    }

    public static double  getKthEle(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if(start1 == nums1.length)
            return nums2[start2+k-1];
        if(start2 == nums2.length)
            return nums1[start1+k-1];
         if(k == 1)
             return Math.min(nums1[start1], nums2[start2]);

        int curIndex1 = Math.min(nums1.length, start1 + k / 2)  - 1;
        int curIndex2 = Math.min(nums2.length, start2 + k / 2 ) - 1;
        if(nums1[curIndex1] < nums2[curIndex2])
            return getKthEle(nums1, curIndex1+1, nums2, start2, k - (curIndex1 - start1 + 1) );
        else
            return getKthEle(nums1, start1, nums2, curIndex2+1, k - (curIndex2 - start2 + 1) );


    }

}
