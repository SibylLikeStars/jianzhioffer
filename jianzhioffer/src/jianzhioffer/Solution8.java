package jianzhioffer;

import jianzhioffer.utils.TreeLinkNode;

/**
 * @ClassName : Solution8
 * @Description : 二叉树的下一节点
 * 中序遍历的情况下，输出指定节点的下一节点
 * 有右子树：右子树的最左子节点
 * 无右子树：右节点，则一直向上遍历，知道找到作为左节点的父节点
 *
 * @Date : 2019/9/15 17:11
 */
public class Solution8 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right!=null){
            pNode=pNode.right;
            while (pNode.left!=null){
                pNode=pNode.left;
            }
            return pNode;
        }else{
            TreeLinkNode father=pNode;
            while (father.next!=null){
                pNode=father;
                father=pNode.next;
                if (father.left==pNode){
                    return father;
                }
            }
            return null;
        }
    }
}