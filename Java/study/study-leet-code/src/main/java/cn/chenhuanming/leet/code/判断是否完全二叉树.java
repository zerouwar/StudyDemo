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
        Node root = Node.createTree(new int[]{1, 2, 4, 3}, new int[]{2, 4, 1, 3});


        Node root2 = Node.createTree(new int[]{1, 2, 4, 5, 3}, new int[]{4, 2, 5, 1, 3});

        System.out.println(isCompleteBinaryTree(root));

        System.out.println(isCompleteBinaryTree(root2));
    }

    static boolean isCompleteBinaryTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.peek() != Node.NIL) {
            Node node = queue.poll();
            queue.offer(node.left == null ? Node.NIL : node.left);
            queue.offer(node.right == null ? Node.NIL : node.right);
        }

        while (!queue.isEmpty()) {
            if (queue.poll() != Node.NIL) {
                return false;
            }
        }

        return true;
    }
}
