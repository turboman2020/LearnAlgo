package CodeInterviews.src.Tree.Traverse;

public class TreeNode {
    int value;
    TreeNode leftChild;
    TreeNode rightChild;
    public TreeNode(){};
    public TreeNode(int value){
       this(value, null, null);
    }
    public TreeNode(int value, TreeNode leftChild, TreeNode rightChild){
        this.value = value;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
