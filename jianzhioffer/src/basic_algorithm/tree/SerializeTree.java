package basic_algorithm.tree;

import jianzhioffer.utils.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName : SerializeTree
 * @Description : 树的遍历
 * 前、中、后
 * 层序遍历、二叉树重建见剑指offer
 * @Date : 2019/4/27 20:08
 */
public class SerializeTree {

    /*** @Description : 前序遍历 Preorder traversal, DLR*/
    //递归
    public void  DLR(TreeNode root, ArrayList<TreeNode> list){
        if (root!=null){
            list.add(root);
            DLR(root.left,list);
            DLR(root.right,list);
        }
    }
    //非递归前序
    public static void DLR(TreeNode head){
        if(head!=null){
            Stack<TreeNode> stack=new Stack<>();
            stack.push(head);
            while(!stack.isEmpty()){
                head=stack.pop();
                System.out.print(head.val+" ");
                if(head.right!=null){
                    stack.push(head.right);
                }
                if(head.left!=null){
                    stack.push(head.left);
                }
            }
        }
    }


    /*** @Description : 中序遍历 Inorder traversal, LDR*/
    public void LDR(TreeNode root,ArrayList<TreeNode> list){
        if (root!=null){
            LDR(root.left,list);
            list.add(root);
            LDR(root.right,list);
        }
    }
    //非递归中序
    static void LDR(TreeNode head){
        if(head!=null){
            Stack<TreeNode> stack=new Stack<>();
            while(!stack.isEmpty()||head!=null){
                if(head!=null){
                    stack.push(head);
                    head=head.left;
                }else{
                    head=stack.pop();
                    System.out.print(head.val+" ");
                    head=head.right;
                }

            }
        }
    }

    /*** @Description : 后序遍历 Postorder traversal, LRD*/
    public void LRD(TreeNode root,ArrayList<TreeNode> list){
        if (root!=null){
            LRD(root.left,list);
            LDR(root.right,list);
            list.add(root);
        }
    }
    //非递归后序
    public static void LRD(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> s1 = new Stack<TreeNode>();
            Stack<TreeNode> s2 = new Stack<TreeNode>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().val + " ");
            }
        }
    }

//    public static void main(String [] args){
//        int n=10;
//        TreeNode[] treeNodes=new TreeNode[n];
//        for (int i=0;i<n;i++){
//            treeNodes[i]=new TreeNode(i);
//        }
//        for (int i=0;i<n/2+1;i++){
//            if (i*2+1<n)
//                treeNodes[i].left=treeNodes[2*i+1];
//            if (i*2+2<n)
//                treeNodes[i].right=treeNodes[i*2+2];
//
//        }
//
//        TreeNode root =treeNodes[0];
//        preOrderUnRecur(root);
//        System.out.println();
//        DLR(root);
//    }
}
