package jianzhioffer;


import jianzhioffer.utils.TreeNode;

/**
 * @ClassName : Solution26
 * @Description : 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 递归！！！！！！
 * @Date : 2019/9/16 14:33
 */
public class Solution26 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean res=false;
        if (root1!=null && root2!=null){
            if (root1.val==root2.val)
                res=hasSubTreeHelper(root1,root2);
            if (!res)
                res=hasSubTreeHelper(root1.left,root2);
            if (!res)
                res=hasSubTreeHelper(root1.right,root2);
        }
        return res;
    }

    private boolean hasSubTreeHelper(TreeNode root1, TreeNode root2) {
        if (root2==null)
            return true;
        if (root1==null)
            return false;
        if (root1.val!=root2.val)
            return false;
        return hasSubTreeHelper(root1.left,root2.left) && hasSubTreeHelper(root1.right,root2.right);
    }
}
