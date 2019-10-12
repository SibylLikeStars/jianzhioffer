package jianzhioffer;

import a_important.tool.TreeNode;

/**
 * @ClassName : Solution55
 * @Description : 二叉树的深度
 * @Date : 2019/9/19 20:43
 */
public class Solution55 {
    public int TreeDepth(TreeNode root) {
        if (root==null)
            return 0;
        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        return Math.max(left,right)+1;
    }
}
