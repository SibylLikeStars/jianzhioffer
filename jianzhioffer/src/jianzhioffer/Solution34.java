package jianzhioffer;


import jianzhioffer.utils.TreeNode;

import java.util.ArrayList;

/**
 * @ClassName : Solution34
 * @Description : 二叉树中和为某一值的路径
 * 深度遍历+回溯，递归实现。
 * @Date : 2019/9/19 16:16
 */
public class Solution34 {
    private ArrayList<ArrayList<Integer>> resList=new ArrayList<>();
    private ArrayList<Integer> list=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null)
            return resList;
        list.add(root.val);
        target-=root.val;
        if (target==0 && root.left==null && root.right==null){
            resList.add(new ArrayList<>());
        }else{
            FindPath(root.left,target);
            FindPath(root.right,target);
        }
        list.remove(list.size()-1);
        return resList;
    }


    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target) {
        return findPath(root,target,new ArrayList<>(),new ArrayList<>());
    }


    public ArrayList<ArrayList<Integer>> findPath(TreeNode node, int target,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> res){
        if (node==null)
            return res;
        list.add(node.val);
        target-=node.val;
        if (target==0 && node.left==null && node.right==null){
            res.add(new ArrayList<>(list));
        }else{
            findPath(node.left,target,list,res);  //有返回值的方法，不一定需要接收
            findPath(node.right,target,list,res);
        }
        list.remove(list.size()-1);
        return res;
    }

}
