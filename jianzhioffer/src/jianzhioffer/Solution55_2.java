package jianzhioffer;

import jianzhioffer.utils.TreeNode;

/**
 * @ClassName : Solution55_2
 * @Description : 判断是不是平衡二叉树
 * @Date : 2019/9/19 20:45
 */
public class Solution55_2 {
    public boolean isBalance(TreeNode root){
        return getDepth(root)!=-1;
    }

    private int getDepth(TreeNode root) {
        if (root==null)
            return 0;
        int left=getDepth(root.left);
        if (left==-1)
            return -1;
        int right=getDepth(root.right);
        if (right==-1)
            return -1;
        return Math.abs(left-right)>1?-1:1+Math.max(left,right);

    }

    public int TreeDepth(TreeNode root) {
        if (root==null)
            return 0;
        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        return Math.max(left,right)+1;
    }
}
