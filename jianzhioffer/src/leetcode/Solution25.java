package leetcode;

import leetcode.utils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 25、K个一组翻转链表???，没通过，一直死循环？？？
 */
public class Solution25 {
    public static void main(String[] args){
        Solution25 s=new Solution25();
        ListNode a=new ListNode(1);
        ListNode  b=new ListNode(2);
        ListNode  c=new ListNode(3);
        ListNode  d=new ListNode(4);
        ListNode  e=new ListNode(5);
        a.next=b;b.next=c;c.next=d;d.next=e;
        ListNode h=s.reverseKGroup4(a,2);
        while (h!=null){
            System.out.print(h.val+"->");
        }

    }
    public ListNode reverseKGroup4(ListNode head, int k) {
        int i = k;
        ListNode[] stack = new ListNode[k];//没有无参构造方法，但是构建了没有值的结点。相当于int i;
        ListNode q = head;
        while(k>0) {//把当前k个结点存入栈中。
            stack[i-k] = q;
            if (q!=null) q=q.next;
            else return head;//结点凑不到k个时，直接返回原部分链表。
            k--;
        }
        while(k<i-1) {
            k++;
            stack[i-k].next=stack[i-k-1];
        }
        stack[0].next=reverseKGroup(q, k+1);
        return stack[i-1];
    }

    public ListNode reverseKGroup3(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (true) {
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k) {
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            if (count != k) {
                p.next = head;
                break;
            }
            while (!stack.isEmpty()){
                p.next = stack.pollLast();
                p = p.next;
            }
            p.next = tmp;
            head = tmp;
        }
        return dummy.next;
    }


    //第一个版本，超时？？
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || k<=0)
            return head;
        ListNode first=new ListNode(-1);
        ListNode cur=first;
        Stack<ListNode> stack=new Stack<>();
        while (head!=null){
            if (stack.isEmpty() || stack.size()<k){
                stack.push(head);
            }
           if (stack.size()==k){
               while (!stack.isEmpty()){
                   cur.next=stack.pop();
                   cur=cur.next;
               }
           }
           head=head.next; //不知道为什么这里就循环了？？？？
        }
        Stack<ListNode> tmp=new Stack<>();
        while (!stack.isEmpty()){
            tmp.push(stack.pop());
        }
        while (!tmp.isEmpty()){
            cur.next=tmp.pop();
            cur=cur.next;
        }
        return first.next;
    }

    //这个通过了一些
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode cur=null;
        ListNode newHead=null;
        Stack<ListNode> stack=new Stack<>();
        while (!stack.isEmpty() || head!=null){
            stack.push(head);
            head=head.next;
            if (stack.size()==k){
                if (newHead==null){
                    newHead=stack.pop();
                    cur=newHead;
                }
                while (!stack.isEmpty()){
                    cur.next=stack.pop();
                    cur=cur.next;
                }
            }
            if (head==null){
                Stack<ListNode> s2=new Stack<>();
                while (!stack.isEmpty())
                    s2.push(stack.pop());
                if (newHead==null){
                    newHead=s2.pop();
                    cur=newHead;
                }
                while (!s2.isEmpty()){
                    cur.next=s2.pop();
                    cur=cur.next;
                }
            }

        }
        return  newHead;
    }
}
