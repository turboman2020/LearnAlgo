package src.DataStruct.CH01_Tree.utils;

import java.util.Stack;

public class Tree {
    //创建二叉树
    public static TreeNode createTree( String[] arrays, int index ){
        //通过输入的数组，层序的完全二叉树，构建二叉树, "NULL"表示空节点
         if(index >= arrays.length || arrays[index].equals("$")) return null;
         TreeNode root = new TreeNode(arrays[index]);
         root.leftNode = createTree( arrays, 2 * index + 1);
         root.rightNode = createTree(arrays,  2  * index + 2);

         return root;
    }

    //二叉树的先序遍历递归版
    public static void preOrderTravers(TreeNode root){
        if(root == null) return ;

        System.out.println(root.val);
        preOrderTravers(root.leftNode);
        preOrderTravers(root.rightNode);
    }

    //二叉树的先序遍历非递归版
    public static void preOrderTraversDFS(TreeNode root){
        Stack<TreeNode> tree_stack = new Stack<>();
        tree_stack.push(root);
        while (!tree_stack.empty()){
            TreeNode curNode  = tree_stack.pop();
            System.out.println(curNode.val);
            if (curNode.rightNode != null)
                tree_stack.push(curNode.rightNode);
            if (curNode.leftNode != null)
                tree_stack.push(curNode.leftNode);

        }

    }

    //二叉树的中序遍历递归版
    public static void midOrderTravers(TreeNode root){
        if(root == null) return ;


        midOrderTravers(root.leftNode);
        System.out.println(root.val);
        midOrderTravers(root.rightNode);
    }

    //二叉树的中序遍历非递归版
    public static void midOrderTraversDFS(TreeNode root){
        Stack<TreeNode> tree_stack = new Stack<>();
        tree_stack.push(root);
        while (!tree_stack.empty()){
            TreeNode curNode  = tree_stack.peek();

            while (curNode.leftNode != null){

                tree_stack.push(curNode.leftNode);
                curNode = curNode.leftNode;
            }

            while (curNode.rightNode == null && !tree_stack.isEmpty()){
                curNode  = tree_stack.pop();
                System.out.println(curNode.val);
            }


            if (curNode.rightNode != null){
                tree_stack.push(curNode.rightNode);
            }

        }

    }

    //二叉树的后序遍历递归版
    public static void postOrderTravers(TreeNode root){
        if(root == null) return ;

        postOrderTravers(root.leftNode);
        postOrderTravers(root.rightNode);
        System.out.println(root.val);
    }

    //二叉树的后序遍历非递归版
    public static void postOrderTraversDFS(TreeNode root){
        Stack<TreeNode> tree_stack = new Stack<>();
        TreeNode preNode = root;
        tree_stack.push(root);
        while (!tree_stack.empty()){
            TreeNode curNode  = tree_stack.peek();

            while ( curNode.leftNode != null){

                tree_stack.push(curNode.leftNode);
                curNode = curNode.leftNode;
            }

            while (curNode.rightNode == null ||  curNode.rightNode == preNode) {
                curNode = tree_stack.pop();
                System.out.println(curNode.val);
                preNode = curNode;
                if (tree_stack.empty())
                    break;
                curNode = tree_stack.peek();
            }
            if(!tree_stack.empty() &&(curNode.rightNode != null || curNode.rightNode != preNode)){

                tree_stack.push(curNode.rightNode);
            }
        }

    }
}
