package jianzhioffer;


import jianzhioffer.utils.TreeNode;

/**
 * @ClassName : Solution27
 * @Description : 二叉树的镜像
 * 这种void，且参数是引用类型的最好了~直接递归，不用考虑
 * @Date : 2019/9/16 14:38
 */
public class Solution27 {
    public void Mirror(TreeNode root) {
        if (root==null)
            return;
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
