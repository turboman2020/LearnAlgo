package src.DataStruct.CH01_Tree.utils;

public class AVL {

    //创建AVL树
    public TreeNode createAVLTree(int [] arrays){
        TreeNode root= new TreeNode(arrays[0]);

        for(int i = 1; i < arrays.length; i ++){
            insert(root, arrays[i]);
        }

        return root;
    }

    //插入结点
    public TreeNode insert(TreeNode node, int val){

        if(node == null)
            return new TreeNode(val);
        if(val < node.val)
            node.leftNode = insert(node.leftNode, val);
        else if(val > node.val)
            node.rightNode = insert(node.rightNode, val);
        else
            return node; //重复结点不插入， 直接返回
        //更新高度
        updateHeight(node);
        //旋转操作
        node = rotate(node);
        return node;

    }

    //删除结点
    public TreeNode delete(TreeNode node, int val){

        if(node == null)
            return null;
        if(val < node.val)
            node.leftNode = delete(node.leftNode, val);
        else if(val > node.val)
            node.rightNode = delete(node.rightNode, val);
        else{ //找到结点

            if(node.leftNode == null || node.rightNode == null){
                TreeNode child = node.leftNode == null ? node.rightNode : node.leftNode;

                if(child == null)
                    return null;
                else
                    node = child ;
            }
            else { // 子节点数量 = 2 ，则将中序遍历的下个节点删除，并用该节点替换当前节点
                TreeNode temp = node.rightNode;
                while(temp.leftNode != null)
                    temp = temp.leftNode;

                node.rightNode = delete(node.rightNode, temp.val);
                node.val = temp.val;
            }
        }

        //更新高度
        updateHeight(node);
        //旋转操作
        node = rotate(node);
        return node;

    }

    //旋转结点
    public TreeNode rotate(TreeNode node){
        int balanceFactor = balanceFactor(node);
        //左偏树
        if(balanceFactor > 1){
            if(balanceFactor(node.leftNode) >= 0){
                //右旋
                return rightRotate(node);
            } else{
                //先左旋再右旋
                node.leftNode = leftRotate(node.leftNode);
                return rightRotate(node);
            }
        }
        //右偏树
        if(balanceFactor < -1){
            if(balanceFactor(node.rightNode) <= 0){
                //右旋
                return leftRotate(node);
            } else{
                //先右旋再左旋
                node.leftNode = rightRotate(node.rightNode);
                return leftRotate(node);
            }
        }

        return node;
    }

    //左旋方法
    public TreeNode leftRotate(TreeNode node){
        TreeNode child = node.rightNode;
        TreeNode grandChild = child.leftNode;
        child.leftNode = node;
        node.rightNode = grandChild;

        updateHeight(node);
        updateHeight(child);
        return child;
    }

    //右旋方法
    public TreeNode rightRotate(TreeNode node){
        TreeNode child = node.leftNode;
        TreeNode grandChild = child.rightNode;
        child.rightNode = node;
        node.leftNode = grandChild;

        updateHeight(node);
        updateHeight(child);
        return child;
    }

    //辅助方法
    //获取结点高度
    public int heigh(TreeNode node){
        if(node == null)
            return -1;
        return node.height;
    }

    //更新结点高度
    public void updateHeight(TreeNode node){
        node.height = Math.max(heigh(node.leftNode), heigh(node.rightNode)) +1;
    }

    //结点的平衡因子（平衡二叉树的平衡因子f, -1 <= f <= 1）
    public int balanceFactor(TreeNode node){
        // 空节点平衡因子为 0
        if(node == null)
            return 0;
        // 节点平衡因子 = 左子树高度 - 右子树高度
        return heigh(node.leftNode) - heigh(node.rightNode);
    }
}
