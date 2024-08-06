package CodeInterviews.src.Tree.Traverse;

public class treeTraverseRecursion {
    public static void main(String [] args){
        int [] arr = new int [] {1, 2, 3, 4 ,5 ,6 ,7 ,8 ,9};
        TreeNode root = buildTree(arr, 0);
        preOrderTraverse(root);
        System.out.println("================");
        midOrderTraverse(root);
        System.out.println("================");
        postOrderTraverse(root);

    }

    public static TreeNode buildTree(int [] array, int index){
        if (index >= array.length || array[index] == -1 ) return null;
        TreeNode root = new TreeNode(array[index]);
        root.leftChild = buildTree(array, 2 * index + 1);
        root.rightChild = buildTree(array, 2 * (index + 1));
        return root;
    }

    public static void preOrderTraverse(TreeNode root){
        if (root == null) return;
         System.out.println(root.value);
         preOrderTraverse(root.leftChild);
         preOrderTraverse(root.rightChild);

    }

    public static void midOrderTraverse(TreeNode root){
        if (root == null) return;
        preOrderTraverse(root.leftChild);
        System.out.println(root.value);
        preOrderTraverse(root.rightChild);

    }

    public static void postOrderTraverse(TreeNode root){
        if (root == null) return;
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);
        System.out.println(root.value);

    }
}
