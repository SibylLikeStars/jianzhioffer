package jianzhioffer;

/**
 * @ClassName : Solution31
 * @Description : 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * @Date : 2019/9/16 14:50
 */
import java.util.Stack;

public class Solution31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA==null && popA==null)
            return true;
        if (pushA==null || popA==null)
            return false;
        if (pushA.length!=popA.length)
            return false;
        Stack<Integer> stack=new Stack<>();
        int index=0;
        //精髓！！！！
        for (int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek()==popA[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
