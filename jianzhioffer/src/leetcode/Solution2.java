package leetcode;

import leetcode.utils.ListNode;

/**
 * 2、两数相加：用链表倒序保存的非负整数，相加
 * 方法1：while循环，依次判断。注意进位enter==1的时候，还要再次进入循环。考虑的条件和情况会比较多。
 * 方法2：参考了leetcode给出的官方做法，太简洁了
 * 方法3：迭代和递归的最简写法：https://leetcode-cn.com/problems/add-two-numbers/solution/zui-jian-xie-fa-by-baal-3/
 *        tips就是，两个条件，可以分开判断
 */
public class Solution2 {
    //官方的
    public  ListNode addTwoNumbersAuth(ListNode l1, ListNode l2) {
        ListNode dummyHead=new ListNode(0);
        ListNode p=l1,q=l2,cur=dummyHead;
        int carry=0;
        while (p!=null || q!=null){
            int x=p==null?0:p.val;
            int y=q==null?0:q.val;
            int sum=x+y+carry;
            carry=sum/10;
            ListNode node=new ListNode(sum%10);
            cur.next=node;
            if (p!=null) p=p.next;
            if (q!=null) q=q.next;
        }
        if (carry==1)
            cur.next=new ListNode(carry);
        return dummyHead.next;
    }

    //自己写的
    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null&&l2==null)
            return null;
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;
        ListNode head;
        ListNode nextNode;
        int enter=0;
        int sum=l1.val+l2.val;
        if (sum>=10){
            head=new ListNode(sum%10);
            enter=1;
        }else{
            head=new ListNode(sum);
        }
        nextNode=head;
        while((l1!=null) || (l2!=null)||enter!=0){
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
            if (l1==null&&l2==null){
                if (enter==1){
                    nextNode.next=new ListNode(1);
                }
                break;
            }else if (l1!=null&&l2!=null){
                int temp=(l1==null?0:l1.val)+(l2==null?0:l2.val)+enter;
                ListNode node;
                if (temp>=10){
                    node=new ListNode(temp%10);
                    enter=1;
                }else{
                    node=new ListNode(temp);
                    enter=0;
                }
                nextNode.next=node;
                nextNode=nextNode.next;
            }else{
                ListNode a=l1==null?l2:l1;
                if (enter==1){
                    int temp=a.val+enter;
                    ListNode node;
                    if (temp>=10){
                        node=new ListNode(temp%10);
                        enter=1;
                    }else{
                        node=new ListNode(temp);
                        enter=0;
                    }
                    nextNode.next=node;
                    nextNode=nextNode.next;
                }else{
                    nextNode.next = a;
                    break;
                }
            }
        }
        return head;
    }
}
