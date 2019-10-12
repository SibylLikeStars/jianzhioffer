package jianzhioffer;

import jianzhioffer.utils.ListNode;

/**
 * @ClassName : S52_Solution52
 * @Description : 两个链表的第一个公共节点
 * @Date : 2019/4/1 10:04
 */

public class Solution52 {
    // 对方法3的优化：主要是代码进行优化~~~
    // 先行的思想
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null)
            return null;
        ListNode res=null;
        int len1=getListNodeLength(pHead1);
        int len2=getListNodeLength(pHead2);
        ListNode listLong=pHead1;
        ListNode listShort=pHead2;
        int gap=len1-len2;
        if (len2>len1){
           listLong=pHead2;
           listShort=pHead1;
            gap=len2-len1;
        }
        for (int i=0;i<gap;i++)
            listLong=listLong.next;
        ListNode temp=pHead1;
        while(listLong!=null&&listShort!=null){
            if (listLong==listShort){
                res=listLong;
                break;
            }else{
                listLong=listLong.next;
                listShort=listShort.next;
            }
        }
        return res;
    }

    private int getListNodeLength(ListNode pHead) {
        int len=0;
        while (pHead!=null){
            pHead=pHead.next;
            len++;
        }
        return len;
    }


    // 方法3：先计算长度
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        // 1-输入合法性判断
        // 2-计算俩链表长度之差
        // 3-长链表先行，依次遍历
        ListNode res=null;
        if (pHead1==null||pHead2==null)
            return null;
        int len1=0;
        int len2=0;
        ListNode temp=pHead1;
        while (temp!=null){
            temp=temp.next;
            len1++;
        }
        temp=pHead2;
        while (temp!=null){
            temp=temp.next;
            len2++;
        }
        if (len1>=len2){
            int gap=len1-len2;
            for (int i=0;i<gap;i++)
                pHead1=pHead1.next;
            while(pHead1!=null&&pHead2!=null){
                if (pHead1==pHead2){
                    res=pHead1;
                    break;
                }else{
                    pHead1=pHead1.next;
                    pHead2=pHead2.next;
                }
            }
        }else{
            int gap=len2-len1;
            for (int i=0;i<gap;i++)
                pHead2=pHead2.next;
            while(pHead1!=null&&pHead2!=null){
                if (pHead1==pHead2){
                    res=pHead1;
                    break;
                }else{
                    pHead1=pHead1.next;
                    pHead2=pHead2.next;
                }
            }
        }
        return res;

    }
}
