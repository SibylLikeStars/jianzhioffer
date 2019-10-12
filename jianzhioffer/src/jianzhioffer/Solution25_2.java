package jianzhioffer;


import jianzhioffer.utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName : Solution25_2
 * @Description : 合并 k 个排序链表
 * leetcode 23: 返回合并后的排序链表。请分析和描述算法的复杂度。
 * 字节手撕
 *
 * 方法1：暴力法
 * 找出所有节点，放到一个数组中，对这个数组进行排序，然后遍历
 *
 * 方法2：优先队列
 * 时间复杂度：O(n*log(k))O(n∗log(k))，n 是所有链表中元素的总和，k 是链表个数。
 *
 * 方法3：分冶
 * 链表两两合并
 *
 * @Date : 2019/9/16 14:12
 */
public class Solution25_2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0)
            return null;
        PriorityQueue<ListNode> queue=new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        ListNode headFirst=new ListNode(-1);
        ListNode head=headFirst;
        //首先将各个链表的头节点加到优先队列中，先排一次
        for (ListNode node:lists){
            if (node!=null)
                queue.add(node);
        }
        while (!queue.isEmpty()){
            head.next=queue.poll();  //从优先队列中拿出最小的
            head=head.next;
            if (head.next!=null)
                queue.add(head.next); //然后将拿出的这个的next放入优先队列
        }
          return headFirst.next;


    }

    //分冶
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists==null || lists.length==0)
            return null;
        return merge(lists,0,lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left==right)
            return lists[left];
        int mid=left+(right-left)>>1;
        ListNode l1=merge(lists,left,mid);
        ListNode l2=merge(lists,mid+1,right);
        return mergeTwoList(l1,l2);
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;
        if (l1.val<l2.val){
            l1.next=mergeTwoList(l1.next,l2);
            return l2;
        }else{
            l2.next=mergeTwoList(l1,l2.next);
            return l2;
        }
    }

}
