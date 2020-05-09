package cn.chenhuanming.leet.code.easy;

import cn.chenhuanming.leet.code.common.TreeNode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 验证二叉搜索树 {
    public static void main(String[] args) {
        验证二叉搜索树 instance = new 验证二叉搜索树();
        boolean validBST = instance.isValidBST(TreeNode.createTree(new int[]{1,1}, new int[]{1,1}));
        System.out.println(validBST);
    }

    private double last = -Double.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        if(isValidBST(root.left)){
            if(root.val > last){
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }
}
