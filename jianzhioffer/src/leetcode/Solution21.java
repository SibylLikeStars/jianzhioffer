package leetcode;

import leetcode.utils.ListNode;

/**
 * 合并有序列表
 */

//class ListNode {
//     int val;
//    ListNode next;
//     ListNode(int x) { val = x; }
//}

public class Solution21 {

    //通过循环的方式实现：
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode preHead=new ListNode(-1);
        ListNode prev=preHead;  //注意1
        while (l1!=null && l2!=null){ //注意2
            if (l1.val<l2.val){
                prev.next=l1;
                l1=l1.next;
            }else{
                prev.next=l2;
                l2=l2.next;
            }
            prev=prev.next; //注意3
        }
        prev.next=l1==null?l2:l1;
        return preHead.next;
    }

    //递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null && l2==null)
            return null;
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;
        if (l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
