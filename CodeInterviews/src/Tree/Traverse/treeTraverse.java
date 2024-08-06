package CodeInterviews.src.Tree.Traverse;

import java.util.Stack;

public class treeTraverse {
    public static void main(String [] args){
        int [] arr = new int [] {1, 2, 3, 4 ,5 ,6 ,7 ,8 ,9};
        TreeNode root = buildTree(arr, 0);
        preOrderTraverse(root);
        System.out.println("================");
        midOrderTraverse(root);
        System.out.println("================");

    }

    public static TreeNode buildTree(int [] array, int index){
        if (index >= array.length || array[index] == -1 ) return null;
        TreeNode root = new TreeNode(array[index]);
        root.leftChild = buildTree(array, 2 * index + 1);
        root.rightChild = buildTree(array, 2 * (index + 1));
        return root;
    }

    public static void preOrderTraverse(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            System.out.println(curNode.value);
            if (curNode.rightChild != null)
                stack.push(curNode.rightChild);
            if (curNode.leftChild != null)
                stack.push(curNode.leftChild);
        }

    }

    public static void midOrderTraverse(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()){

            while (root != null ){
                stack.push(root);
                root = root.leftChild;
            }

            root = stack.pop();
            System.out.println(root.value);
            root = root.rightChild;

        }

    }

    public void postOrderTraverse(TreeNode root){
        if (root == null) return;
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);
        System.out.println(root.value);

    }
}
