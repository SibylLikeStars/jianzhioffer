package jianzhioffer;

import jianzhioffer.utils.ListNode;

/**
 * @ClassName : Solution24
 * @Description : 反转链表
 * 三个指针，前中后
 * 最重要的是cur.nect=pre；指针转向
 * @Date : 2019/9/16 13:49
 */
public class Solution24 {
    public ListNode ReverseList(ListNode head) {
        if (head==null)
            return null;
        if (head.next==null)
            return head;
        ListNode pre=null;
        ListNode cur=head;
        ListNode next=head.next;
        ListNode newHead=null;
        while (cur!=null){
            next=cur.next;
            if (next==null)
                newHead=cur;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return newHead;
    }
}
