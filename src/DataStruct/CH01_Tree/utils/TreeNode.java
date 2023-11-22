package src.DataStruct.CH01_Tree.utils;

public class TreeNode {
    public int val;
    public TreeNode leftNode;
    public TreeNode rightNode;
    public int height;

    public  TreeNode(int val){
        this.val = val;
        this.leftNode = null;
        this.rightNode = null;

    }
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
