package cn.chenhuanming.leet.code.easy;

import cn.chenhuanming.leet.code.common.TreeNode;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 另一个树的子树 {
    public static void main(String[] args) {
        另一个树的子树 instance = new 另一个树的子树();
        boolean subtree = instance.isSubtree(
                TreeNode.createTree(new int[]{3, 4, 1, 2, 5}, new int[]{1, 4, 2, 3, 5}),
                TreeNode.createTree(new int[]{4, 1, 2}, new int[]{1, 4, 2})
        );
        System.out.println(subtree);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }
        if(isIdentical(s,t)){
            return true;
        }
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public boolean isIdentical(TreeNode s,TreeNode t){
        if(s==t){
            return true;
        }
        if(s!=null&&t!=null){
            if(s.val==t.val){
                return isIdentical(s.left,t.left) && isIdentical(s.right,t.right);
            }
        }
        return false;
    }
}
