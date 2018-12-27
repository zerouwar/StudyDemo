package cn.chenhuanming.leet.code;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenhuanming
 * Created at 2018/12/26
 */
public class 判断是否完全二叉树 {
    public static void main(String[] args) {
        Node root = Node.createTree(new int[]{1, 2, 4, 5, 6, 7, 3}, new int[]{4, 2, 6, 5, 7, 1, 3});


        Node root2 = Node.createTree(new int[]{1, 2, 4, 5, 3}, new int[]{4, 2, 5, 1, 3});

        System.out.println(isCompleteBinaryTree(root));

        System.out.println(isCompleteBinaryTree(root2));
    }

    static boolean isCompleteBinaryTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != root && (node.left != null || node.right != null) && queue.isEmpty()) {
                return false;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return true;
    }
}
