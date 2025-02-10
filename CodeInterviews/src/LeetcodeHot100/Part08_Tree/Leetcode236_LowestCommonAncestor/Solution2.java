package CodeInterviews.src.LeetcodeHot100.Part08_Tree.Leetcode236_LowestCommonAncestor;

import CodeInterviews.src.LeetcodeHot100.BaseDataStructure.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {
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
}
