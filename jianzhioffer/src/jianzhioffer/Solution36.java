package jianzhioffer;


import jianzhioffer.utils.TreeNode;

/**
 * @ClassName : Solution36
 * @Description : 二叉搜索树与双向链表
 * 中序遍历的过程中，把相邻的两个节点互指
 *
 * 思路：用中序遍历做，head相当于pre，记录上一次的节点。
 * @Date : 2019/9/19 19:03
 */
public class Solution36 {
    TreeNode pre=null;
    TreeNode realHead=null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        convertNode(pRootOfTree);
        return realHead;
    }
    private void convertNode(TreeNode node){
        if (node==null)
            return;
        convertNode(node.left);
        if (pre==null){
            pre=node;
            realHead=node;
        }else{
            pre.right=node;
            node.left=pre;
            pre=node;
        }
        convertNode(node.right);

    }
}
