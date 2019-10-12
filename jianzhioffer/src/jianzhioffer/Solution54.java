package jianzhioffer;

import a_important.tool.TreeNode;

/**
 * @ClassName : Solution54
 * @Description : 二叉排序树的第K个节点
 * @Date : 2019/9/19 20:35
 */
public class Solution54 {
    int count=0;
    TreeNode res=null;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot==null || k<=0)
            return null;
        return getKthNode(pRoot,k);

    }

    //中序遍历
    private TreeNode getKthNode(TreeNode pRoot, int k) {

        if (pRoot.left!=null)
            getKthNode(pRoot.left,k);
        count++;
        if (count==k){
            res=pRoot;
        }
        if (res==null && pRoot.right!=null)
            getKthNode(pRoot.right,k);
        return res;
    }
}
