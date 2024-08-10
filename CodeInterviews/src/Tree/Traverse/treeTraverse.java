package CodeInterviews.src.Tree.Traverse;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class treeTraverse {
    public static void main(String [] args){
        int [] arr = new int [] {1, 2, 3, 4 ,5 ,6 ,7 ,8 ,9};
        TreeNode root = buildTree(arr, 0);
        List<Integer> res ;
        res = preOrderTraverse(root);
        System.out.println(Arrays.toString(res.toArray()));
        res = preOrderTraverse2(root);
        System.out.println(Arrays.toString(res.toArray()));
//        res = midOrderTraverse(root);
//        System.out.println(Arrays.toString(res.toArray()));
        postOrderTraverse(root);
        res = postOrderTraverse3(root);
        System.out.println(Arrays.toString(res.toArray()));

    }

    public static TreeNode buildTree(int [] array, int index){
        if (index >= array.length || array[index] == -1 ) return null;
        TreeNode root = new TreeNode(array[index]);
        root.leftChild = buildTree(array, 2 * index + 1);
        root.rightChild = buildTree(array, 2 * (index + 1));
        return root;
    }

    public static List<Integer> preOrderTraverse(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        while (!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            res.add(curNode.value);
            if (curNode.rightChild != null)
                stack.push(curNode.rightChild);
            if (curNode.leftChild != null)
                stack.push(curNode.leftChild);
        }
        return res;

    }

    public static List<Integer> preOrderTraverse2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();
        while (root!=null || !stack.isEmpty()){
            while(root != null) {
                res.add(root.value);
                stack.push(root);
                root = root.leftChild;
            }
            root = stack.pop();
            root = root.rightChild;
        }

        return res;

    }

    public static List<Integer> midOrderTraverse(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();
        while (root != null || !stack.isEmpty()){

            while (root != null ){
                stack.push(root);
                root = root.leftChild;
            }

            root = stack.pop();
            res.add(root.value);
            root = root.rightChild;

        }
        return res;

    }

    public static void postOrderTraverse(TreeNode root){
        if (root == null) return;
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);
        System.out.println(root.value);

    }

    public static List<Integer> postOrderTraverse2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode preNode = root;
        List<Integer> res = new LinkedList<>();
        while(root != null || !stack.isEmpty()){

            while (root != null ){
                stack.push(root);
                root = root.leftChild;
            }
            root = stack.peek();
            if(root.rightChild == null || preNode == root.rightChild) {
                root = stack.pop();
                res.add(root.value);
                preNode = root;
                root = null;

            }else{
                root = root.rightChild;
            }


        }
        return  res;

    }

    public static List<Integer> postOrderTraverse3(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode preNode = root;
        List<Integer> res = new LinkedList<>();
        while(root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.leftChild;
            }

            root = stack.peek();
            if (root.rightChild == null || preNode == root.rightChild) {
                root = stack.pop();
                res.add(root.value);
                preNode = root;
                root = null;
            } else {
                root = root.rightChild;
            }
        }
        return  res;

    }

    public static List<Integer> postOrderTraverse4(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        List<Integer> res = new LinkedList<>();
        while(root != null || !stack.isEmpty()){

            while (root != null ){
                stack.push(root);
                res.add(0, root.value);
                root = root.rightChild;
            }
            root = stack.pop();
            root = root.leftChild;

        }
        return  res;

    }
}
