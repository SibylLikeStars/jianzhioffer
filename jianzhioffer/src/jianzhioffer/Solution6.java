package jianzhioffer;

import jianzhioffer.utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 从尾到头打印链表：输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
  思路：利用栈stack先进后出的特点
 */
public class Solution6 {
    //非递归版本
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<ListNode> stack=new Stack<>();
        while (listNode!=null){
            stack.push(listNode);
            listNode=listNode.next;
        }
        ArrayList<Integer> res=new ArrayList<>();
        while (!stack.isEmpty()){
            res.add(stack.pop().val);
        }
        return res;
    }

    //递归版本
    public  ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> ans=new ArrayList<>();
        if (listNode==null)
            return null;
        helper(listNode,ans);
        return ans;
    }
    private  void helper(ListNode listNode,ArrayList<Integer> ans){
        if (listNode!=null){
            if (listNode.next!=null)
                helper(listNode.next,ans);
            ans.add(listNode.val);
        }
    }

}
