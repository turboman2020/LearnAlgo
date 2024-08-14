package CodeInterviews.src.Tree.Problem07;

import CodeInterviews.src.Tree.Traverse.TreeNode;

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


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, inorder,  0, preorder.length-1, 0, inorder.length-1);
    }


    public static  TreeNode buildTree(int[] preorder, int[] inorder, int preOrderStart, int preOrderEnd, int inOrderStart, int inOrderEnd) {
        if(preOrderStart > preOrderEnd) return null;

        TreeNode root = new TreeNode(preorder[preOrderStart]);

        //在中序遍历中查找root
        int inorderRootIndex = -1;
        for(int i = inOrderStart; i <= inOrderEnd; i ++){
            if(inorder[i] == root.value) {
                inorderRootIndex = i;
                break;
            }
        }

        int left_subtree = inorderRootIndex - inOrderStart;

        root.leftChild = buildTree(preorder, inorder, preOrderStart + 1, preOrderStart + left_subtree, inOrderStart, inorderRootIndex -1);

        root.rightChild = buildTree(preorder, inorder,  preOrderStart + left_subtree + 1, preOrderEnd, inorderRootIndex + 1, inOrderEnd);

        return root;
    }


}
