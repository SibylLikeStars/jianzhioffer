package jianzhioffer;


import jianzhioffer.utils.TreeNode;

/**
 * @ClassName : Solution28
 * @Description : 判断俩二叉树是否对称
 * @Date : 2019/9/16 14:38
 */
public class Solution28 {
    public boolean isSymmetrical(TreeNode root1, TreeNode root2){
        if (root1==null && root2==null)
            return true;
        if (root1==null || root2==null)
            return false;
        if (root1.val!=root2.val)
            return false;
        return isSymmetrical(root1.left,root2.right) && isSymmetrical(root1.right,root2.left);
    }
}
