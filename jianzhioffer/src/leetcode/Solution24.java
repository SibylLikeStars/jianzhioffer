package leetcode;

import leetcode.utils.ListNode;

/**
 * 24、两两交换链表的节点
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode preHead=new ListNode(-1);
        preHead.next=head;
        ListNode cur=head;
        ListNode next,pre=preHead;
        while (pre.next!=null && pre.next.next!=null){ //此处条件有两个！
            next=cur.next;  //获得下一节点
            cur.next=next.next; //cur指向下一节点的再下节点
            next.next=cur; //将next挪到cur前面
            pre.next=next; //pre指向调整好之后的next
            pre=cur;
            cur=cur.next;
        }
        return preHead.next;
    }
}
