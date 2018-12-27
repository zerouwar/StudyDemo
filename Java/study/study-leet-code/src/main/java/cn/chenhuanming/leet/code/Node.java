package cn.chenhuanming.leet.code;

/**
 * @author chenhuanming
 * Created at 2018/12/26
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    /**
     * 根据前序序列和中序序列构建二叉树
     * 依据前序序列中的节点a，在中序序列中a左边都是a的左子树节点，右边都是a的右子树节点
     * @param preOrder
     * @param inOrder
     * @return
     */
    public static Node createTree(int[] preOrder, int[] inOrder) {
        return createTree(preOrder,0,inOrder,0,inOrder.length-1);
    }

    /**
     * 根据前序序列和中序序列构建一个Node节点
     * @param preOrder
     * @param preIndex
     * @param inOrder
     * @param left
     * @param right
     * @return
     */
    private static Node createTree(int[] preOrder, int preIndex, int[] inOrder, int left, int right) {
        if (left > right || preIndex >= preOrder.length) {
            return null;
        }

        Node node = new Node();
        node.val = preOrder[preIndex];

        for (int i = left; i <= right; i++) {
            if(preOrder[preIndex]==inOrder[i]){
                node.left = createTree(preOrder,preIndex+1,inOrder,left,i-1);
                node.right = createTree(preOrder,preIndex+(i-left+1),inOrder,i+1,right);
                break;
            }
        }
        return node;
    }
}
