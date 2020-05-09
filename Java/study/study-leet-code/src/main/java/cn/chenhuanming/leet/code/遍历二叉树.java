package cn.chenhuanming.leet.code;

import cn.chenhuanming.leet.code.common.TreeNode;

/**
 * @author chenhuanming
 * Created at 2018/12/26
 */
public class 遍历二叉树 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6});

        preOrderTraversal(root);
    }

    /**
     * 前序遍历，上->左->右
     * @param treeNode
     */
    static void preOrderTraversal(TreeNode treeNode){
        System.out.print(treeNode.val+" ");
        if(treeNode.left!=null){
            preOrderTraversal(treeNode.left);
        }
        if(treeNode.right!=null){
            preOrderTraversal(treeNode.right);
        }
    }

}
