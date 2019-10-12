package jianzhioffer;


import jianzhioffer.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @ClassName : Solution32
 * @Description : 从上往下打印出二叉树
 * 二叉树的层序遍历
 * @Date : 2019/9/16 16:56
 */
public class Solution32 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null)
            return res;
        ArrayDeque<TreeNode> deque=new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            TreeNode node=deque.poll();
            res.add(node.val);
            if (node.left!=null)
                deque.add(node.left);
            if (node.right!=null)
                deque.add(node.right);
        }
        return res;
    }
}
