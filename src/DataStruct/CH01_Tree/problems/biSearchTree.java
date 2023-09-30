package src.DataStruct.CH01_Tree.problems;

import src.DataStruct.CH01_Tree.utils.TreeNode;

import static src.DataStruct.CH01_Tree.utils.Tree.midOrderTravers;
import static src.DataStruct.CH01_Tree.utils.Tree.midOrderTraversDFS;

public class biSearchTree {
    public static void main(String [] array){

        int [] tree_arr = new int[]{4, 2, 1, 3, 5, 7};
        TreeNode bst = createBST(tree_arr);
//        midOrderTravers(bst);
        midOrderTraversDFS(bst);
    }

    public static TreeNode createBST(int [] arr){
        if(arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        TreeNode cur = root;
        TreeNode pre_node = cur;
        for (int i = 1; i < arr.length; i ++){
            while( cur != null){
                if (cur.val > arr[i]){
                    pre_node = cur;
                    cur = cur.leftNode;
                }
                else{
                    pre_node = cur;
                    cur = cur.rightNode;
                }
            }

            if (pre_node.val > arr[i]){
                pre_node.leftNode = new TreeNode(arr[i]);
            }
            else{
                pre_node.rightNode = new TreeNode(arr[i]);
            }
            cur = root;
        }

        return root;

    }
}
