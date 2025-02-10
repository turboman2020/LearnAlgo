package CodeInterviews.src.LeetcodeHot100.Part08_Tree.Leetcode236_LowestCommonAncestor;

import CodeInterviews.src.LeetcodeHot100.BaseDataStructure.TreeNode;

import java.util.*;

public class Solution {
    Map<TreeNode, TreeNode> map = null;
    public static void main(String [] args){

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        map = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        while (p != null){
            visited.add(p);
            p = map.get(p);
        }

        while (q != null){
            if(visited.contains(q))
                return q;
            visited.add(q);
            q = map.get(q);
        }
        return null;
    }


    public  void genParentNodeSum(TreeNode root) {
        if(root == null) return ;
        if(root.left != null)
            map.put(root.left, root);
        if(root.right != null)
            map.put(root.right,root);

        genParentNodeSum(root.left);
        genParentNodeSum(root.left);
    }
}
