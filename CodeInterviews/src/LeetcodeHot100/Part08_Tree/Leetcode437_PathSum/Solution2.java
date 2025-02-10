package CodeInterviews.src.LeetcodeHot100.Part08_Tree.Leetcode437_PathSum;

import CodeInterviews.src.LeetcodeHot100.BaseDataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static void main(String [] args){

    }
    public static int pathSum(TreeNode root, long targetSum) {
        Map<Long, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0L, 1);
        if(root == null) return 0;

        return prefixPathSum(root, prefixMap, 0, targetSum);

    }


    public static int prefixPathSum(TreeNode root, Map<Long, Integer> prefixMap, long curr, long targetSum) {
        if(root == null) return 0;
        curr += root.val;
        int res =  prefixMap.getOrDefault(curr - targetSum, 0);
        prefixMap.put(curr, prefixMap.getOrDefault(curr, 0) + 1);

        res += prefixPathSum(root.left, prefixMap, curr, targetSum);
        res += prefixPathSum(root.right, prefixMap, curr, targetSum);
        prefixMap.put(curr, prefixMap.getOrDefault(curr, 0) - 1);

        return res;
    }
}
