package cn.chenhuanming.leet.code.easy;

import cn.chenhuanming.leet.code.common.TreeNode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class 对称二叉树 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        System.out.println(123);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetricImpl(root.left, root.right);
    }

    private boolean isSymmetricImpl(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null ^ t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isSymmetricImpl(t1.left, t2.right) && isSymmetricImpl(t1.right, t2.left);
    }
}
