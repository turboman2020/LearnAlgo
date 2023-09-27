package src.DataStruct.CH01_Tree.problems;

import src.DataStruct.CH01_Tree.utils.*;

import static src.DataStruct.CH01_Tree.utils.Tree.*;

public class biTreeTravers {
    public static void main(String [] args){

        String [] tree_arr = new String[]{"1", "2", "3", "4", "5", "$", "7"};
        TreeNode tree = createTree(tree_arr, 0);
//        preOrderTravers(tree);
//        preOrderTraversDFS(tree);
//        midOrderTravers(tree);
//        midOrderTraversDFS(tree);
//        postOrderTravers(tree);
//        postOrderTraversDFS(tree);
        biTreeTraversBFS(tree);
    }
}
