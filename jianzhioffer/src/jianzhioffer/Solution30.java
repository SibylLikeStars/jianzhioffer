package jianzhioffer;

import java.util.Stack;

/**
 * @ClassName : Solution30
 * @Description : 包含main函数的栈
 * 要在O(1)的时间内获得栈中的最小值。
 * @Date : 2019/9/16 14:45
 */
public class Solution30 {

    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        }else{
            minStack.push(Math.min(node,minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
