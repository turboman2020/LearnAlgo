package CodeInterviews.src.Tree.Problem08;

import CodeInterviews.src.Tree.Traverse.TreeNode;
import CodeInterviews.src.Tree.Traverse.treeTraverse;
import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.List;

import static CodeInterviews.src.Tree.Traverse.treeTraverse.preOrderTraverse;

public class Solution {
    public static void main(String [] args){

        int [] preorder = new int []{3,9,20,15,7};
        int [] inorder = new int []{9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        List<Integer> preOrder  = preOrderTraverse(root);
        System.out.println(Arrays.toString(preOrder.toArray()));

    }


    public static TreeNode NextNode (TreeNode curNode) {
        if(curNode == null) return null;
        TreeNode nextNode = null;
        if (curNode.rightChild != null) {
            TreeNode pRight = curNode.rightChild;
            while (pRight.leftChild != null)
                pRight = pRight.leftChild;
            nextNode = pRight;
        } else if (curNode.parentNode != null) {
            TreeNode pParent = curNode.parentNode;
            TreeNode pCurNode = curNode;
            while(pParent != null && pParent.rightChild == pCurNode){
                pCurNode = pParent;
                pParent = pCurNode.parentNode;
            }
            nextNode = pParent;
        }
        return nextNode;

    }


}
