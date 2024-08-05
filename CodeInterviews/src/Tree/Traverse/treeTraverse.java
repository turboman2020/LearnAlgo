package CodeInterviews.src.Tree.Traverse;

public class treeTraverse {
    public static void main(String [] args){
        TreeNode root = new TreeNode(1);


    }

    public void preOrderTraverse(TreeNode root){
        if (root == null) return;
         System.out.println(root.value);
         preOrderTraverse(root.leftChild);
         preOrderTraverse(root.rightChild);

    }

    public void midOrderTraverse(TreeNode root){
        if (root == null) return;
        preOrderTraverse(root.leftChild);
        System.out.println(root.value);
        preOrderTraverse(root.rightChild);

    }

    public void postOrderTraverse(TreeNode root){
        if (root == null) return;
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);
        System.out.println(root.value);

    }
}
