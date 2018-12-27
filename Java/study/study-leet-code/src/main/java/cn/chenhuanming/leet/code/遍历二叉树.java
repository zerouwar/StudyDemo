package cn.chenhuanming.leet.code;

/**
 * @author chenhuanming
 * Created at 2018/12/26
 */
public class 遍历二叉树 {
    public static void main(String[] args) {
        Node root = Node.createTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6});

        preOrderTraversal(root);
    }

    /**
     * 前序遍历，上->左->右
     * @param node
     */
    static void preOrderTraversal(Node node){
        System.out.print(node.val+" ");
        if(node.left!=null){
            preOrderTraversal(node.left);
        }
        if(node.right!=null){
            preOrderTraversal(node.right);
        }
    }

}
