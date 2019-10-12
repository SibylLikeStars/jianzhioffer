package jianzhioffer;

import jianzhioffer.utils.ListNode;

/**
 * @ClassName : Solution18_2
 * @Description : 删除重复的节点
 *  1 -》 2 -》 2 -》 3 -》 3 -》 4 -》 5
 *  * 删除后 1 -》 4 -》 5
 *1）传NULL
 * 2）只有一个节点
 * 3）头节点开始就有重复
 * 4）中间节点重复
 * 5）尾部节点重复
 * 6）链表中没有重复链表
 * 7）所有节点都是重复的
 * @Date : 2019/9/16 12:58
 */
public class Solution18_2 {
    public ListNode deleteNode(ListNode head, ListNode deListNode) {
        if (head==null)
            return null;
        if (deListNode==null)
            return head;
        //头节点要保存一个
        ListNode first=new ListNode(-1);
        first.next=head;

        ListNode node=head;
        ListNode pre=first;
        while (node!=null && node.next!=null){
            if (node.val==node.next.val){
                int val=node.val;
                while (node!=null && node.val==val){
                    node=node.next;
                }
                pre.next=node;
            }else{
                pre=node;
                node=node.next;
            }
        }
        return first.next;
    }
}
