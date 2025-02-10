package CodeInterviews.src.LeetcodeHot100.Part08_Tree.Leetcode437_PathSum;

import CodeInterviews.src.LeetcodeHot100.BaseDataStructure.TreeNode;

public class Solution {
    public static void main(String [] args){

    }
    public static int pathSum(TreeNode root, long targetSum) {
        if(root == null) return 0;

        int res = curNodePathSum(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);

        return res;

    }


    public static int curNodePathSum(TreeNode root, long targetSum) {
        if(root == null) return 0;
        int res = 0;
        if(root.val == targetSum)
            res ++;
        res += curNodePathSum(root.left, targetSum - root.val);
        res += curNodePathSum(root.right, targetSum - root.val);

        return res;
    }
}
