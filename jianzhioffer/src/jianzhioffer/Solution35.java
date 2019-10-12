package jianzhioffer;


import jianzhioffer.utils.RandomListNode;

/**
 * @ClassName : Solution35
 * @Description : 复杂链表复制
 * @Date : 2019/9/19 16:37
 */
public class Solution35 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead==null)
            return null;
        // 第一步：先复制，并并入到原链表中
        RandomListNode node=pHead;
        while (node!=null){
            RandomListNode tmp=new RandomListNode(node.label);
            tmp.next=node.next;
            tmp.random=null;
            node.next=tmp;
            node=tmp.next;
        }
        node=pHead.next;
        // 第二步：复制第二指向

        while (node!=null){
            RandomListNode tmp=node.next;  //获得克隆节点位置
            if (node.random!=null){
                tmp.random=node.random.next;
            }
            node=tmp.next;
        }
        // 删去原有的
        node=pHead;
        RandomListNode newHead=pHead.next;
        RandomListNode tmp=pHead.next;
        node.next=tmp.next;
        node=node.next;
        while (node!=null){
            tmp.next=node.next;
            tmp=tmp.next;
            node.next=tmp.next;
            node=node.next;
        }
        return newHead;

    }
}
