package cn.chenhuanming.leet.code;

import cn.chenhuanming.leet.code.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenhuanming
 * Created at 2018/12/26
 */
public class 判断是否完全二叉树 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new int[]{1, 2, 4, 3}, new int[]{2, 4, 1, 3});


        TreeNode root2 = TreeNode.createTree(new int[]{1, 2, 4, 5, 3}, new int[]{4, 2, 5, 1, 3});

        System.out.println(isCompleteBinaryTree(root));

        System.out.println(isCompleteBinaryTree(root2));
    }

    static boolean isCompleteBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.peek() != TreeNode.NIL) {
            TreeNode treeNode = queue.poll();
            queue.offer(treeNode.left == null ? TreeNode.NIL : treeNode.left);
            queue.offer(treeNode.right == null ? TreeNode.NIL : treeNode.right);
        }

        while (!queue.isEmpty()) {
            if (queue.poll() != TreeNode.NIL) {
                return false;
            }
        }

        return true;
    }
}
