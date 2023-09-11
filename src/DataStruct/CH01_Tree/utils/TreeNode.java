package src.DataStruct.CH01_Tree.utils;

public class TreeNode {
    public String val;
    public TreeNode leftNode;
    public TreeNode rightNode;

    public  TreeNode(String val){
        this.val = val;
        this.leftNode = null;
        this.rightNode = null;
    }
    public String getVal() {
        return val;
    }

    public void setVal(String val) {
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
}
