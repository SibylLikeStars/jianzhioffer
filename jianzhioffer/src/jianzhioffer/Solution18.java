package jianzhioffer;


import jianzhioffer.utils.ListNode;

/**
 * @ClassName : Solution18
 * @Description : O(1)时间删除链表节点
 * 将删除当前节点，转换为删除下一节点，把指针指向改变。
 * @Date : 2019/9/16 11:12
 */
public class Solution18 {
    public void deleteNode(ListNode head, ListNode deListNode) {
        if (head==null || deListNode==null)
            return;
        if (head==deListNode)
            head=null;
        if (deListNode.next==null){
            ListNode tmp=head;
            while (tmp.next!=deListNode)
                tmp=tmp.next;
            tmp.next=null;
        }else{
            deListNode.val=deListNode.next.val;
            deListNode.next=deListNode.next.next;
        }
    }
}
