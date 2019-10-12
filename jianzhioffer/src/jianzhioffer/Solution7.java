package jianzhioffer;

import jianzhioffer.utils.TreeNode;

import java.util.Arrays;

/**
 * 7、重建二叉树
 */
public class Solution7 {
    //前序遍历+中序遍历重建二叉树，返回根节点
    public static TreeNode rebuildTree(int [] pre, int[] in){
        if (pre==null || in==null || pre.length==0 || in.length==0 || pre.length!=in.length)
            return null;
        TreeNode node=new TreeNode();
        node.val=pre[0];
        for (int i=0;i<in.length;i++){
            if (in[i]==pre[0]){
                node.left=rebuildTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                node.right=rebuildTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return node;
    }

    // 后序遍历+中序遍历，可以唯一得到二叉树
    public static TreeNode reConstructBinaryTreeByBI(int[] back,int []in){
        if (back==null||in==null || back.length==0||in.length==0|| back.length!=in.length)
            return null;
        TreeNode root=new TreeNode(back[back.length-1]);
        for (int i=0 ;i<in.length;i++){
            if (back[back.length-1]==in[i]){
                root.left=reConstructBinaryTreeByBI(Arrays.copyOfRange(back,0,i),Arrays.copyOfRange(in,0,i));
                root.right=reConstructBinaryTreeByBI(Arrays.copyOfRange(back,i,back.length-1),Arrays.copyOfRange(in,i+1,in.length));

            }
        }
        return root;
    }

    public static void main (String args[]){
        int [] pre=new int[]{1,2,4,7,3,5,6,8};
        int [] in = new int[]{4,7,2,1,5,3,8,6};
        TreeNode t1=rebuildTree(pre,in);
        System.out.println(t1.toString());
    }
}
