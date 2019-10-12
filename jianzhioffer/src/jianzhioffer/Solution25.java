package jianzhioffer;


import jianzhioffer.utils.ListNode;

/**
 * @ClassName : Solution25
 * @Description : 合并两个排序好的链表
 * 要保存一个前导节点，否则等会儿找不到了~
 * 可以用递归做
 * @Date : 2019/9/16 13:58
 */
public class Solution25 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1==null && list2==null)
            return null;
        if (list1==null)
            return list2;
        if (list2==null)
            return list1;
        ListNode headFirst=new ListNode(-1);
        ListNode head=headFirst;
        while (list1!=null && list2!=null){
            if (list1.val<=list2.val){
                head.next=list1;
                list1=list1.next;
            }else{
                head.next=list2;
                list2=list2.next;
            }
            head=head.next;
        }
        if (list1!=null){
            head.next=list1;
        }
        if (list2!=null)
            head.next=list2;
        return headFirst.next;


    }
}
