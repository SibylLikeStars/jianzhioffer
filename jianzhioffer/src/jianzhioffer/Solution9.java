package jianzhioffer;

import java.util.Stack;

/**
 * @ClassName : Solution9
 * @Description : 用两个栈实现队列
 * push: 只对stack1
 * pop：如果stack2不为空，则stack2.pop()；否则把stack1的pop放到stack2中，再pop()
 *
 * @Date : 2019/9/15 18:24
 */
public class Solution9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
       if (stack2.isEmpty()){
           while (!stack1.isEmpty()){
               stack2.push(stack1.pop());
           }
       }
       return stack2.pop();
    }
}
