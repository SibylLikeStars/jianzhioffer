package jianzhioffer;


import jianzhioffer.utils.ListNode;

/**
 * @ClassName : Solution22
 * @Description : 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 一个节点，先走k-1步
  注意事项：1-当输入的head为空；2-输入的k为0，则计算机中k-1反而是个很大的数，导致程序崩溃；3-当k的值比链表本身还长时
 * @Date : 2019/9/16 13:28
 */
public class Solution22 {
    //方法1
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head==null || k<1)
            return null;
        ListNode quick=head;
        int i=0;
        while (i<k-1){
            quick=quick.next;
            if (quick==null)  //长度不足k
                return null;
            i++;
        }
        while (quick.next!=null){
            quick=quick.next;
            head=head.next;
        }
        return head;
    }

    //方法2：在方法1的基础上改进，增强鲁棒性
    // 通过牛客网调试
    public ListNode FindKthToTail2(ListNode head,int k) {
        if (head==null|| k<1)  //前两个风险
            return null;
        ListNode aHead=head;
        ListNode bHead=head;
        for (int i=0;i<k-1;i++){
            if (aHead.next!=null) {
                aHead = aHead.next;
            }else {
                return null;
            }
        }
        while(aHead.next!=null){
            aHead=aHead.next;
            bHead=bHead.next;
        }
        return bHead;
    }
}
