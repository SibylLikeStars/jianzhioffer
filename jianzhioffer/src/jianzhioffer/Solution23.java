package jianzhioffer;

import jianzhioffer.utils.ListNode;

/**
 * @ClassName : Solution23
 * @Description : 链表中环的入口节点
第一步：判断链表中是否有环
//  定义两个速度不同的指针，慢的一次一步，快的一次两步，如果有环，走得快的指针一定能追上走得慢的指针，如果走得快的指针到达链表的末尾时还没追上，则意味着没有环。
// 第3步：找到环的出入口
//        定义两个指针，若环的节点数为n，则指针P1先行n步时，P2指针开始以相同的速度移动，此时P1已经到达环的入口了。
// 第2步：得到环的节点数
//        两指针相遇的节点一定在环中，从该节点出发进行遍历，当再回到该节点时，即可得到节点数。
 * @Date : 2019/9/16 13:36
 */
public class Solution23 {

    public ListNode EntryNodeOfLoop(ListNode pHead){
        if (pHead==null)
            return null;
        ListNode meetNode=findMeetNode(pHead);
        ListNode curNode=meetNode;
        int loopLen=1;
        while (curNode.next!=meetNode){
            curNode=curNode.next;
            loopLen++;
        }
        curNode=pHead;
        int i=0;
        while (i<loopLen){
            curNode=curNode.next;
            i++;
        }
        ListNode tmp=pHead;
        while (tmp!=curNode){
            tmp=tmp.next;
            curNode=curNode.next;
        }
        return curNode;
    }

    //找到环中任意一个点
    private ListNode findMeetNode(ListNode pHead) {
        ListNode slow=pHead.next;
        if (slow==null)
            return null;
       ListNode quick=slow.next;
       while (quick!=null && slow!=null){
           if (quick==slow)//当相等时，停止
               return quick;
           slow=slow.next; //慢的指针一次一步
           quick=quick.next;
           if (quick!=slow)
               quick=quick.next;  //快的指针一次走两步
       }
       return null;
    }
}
