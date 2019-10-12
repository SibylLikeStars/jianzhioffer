package jianzhioffer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @ClassName : Solution59
 * @Description : 滑动窗口的最大值
 * @Date : 2019/4/3 13:34
 */
public class Solution59 {


    // 59.1 滑动窗口的最大值
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result=new ArrayList<>();
        if (num==null||size>num.length||size<1)
            return result;

        ArrayDeque<Integer> que = new ArrayDeque<>();
        for (int i=0;i<num.length;++i){
            if (que.isEmpty()){  //先判断是否为空
                que.add(i);
            }
            else if (i-que.peek()>=size){  // 再判断队列是否有过期的数据
                que.pollFirst();
            }
            while((!que.isEmpty()) && num[que.peekLast()] <= num[i])  //从后往前，比较当前值与队末值得大小
                que.pollLast();
            que.add(i);
            if (i-size+1>=0)  //只要满足已经进入滑窗，就可以将当前队首作为下标的值输出
                result.add(num[que.peek()]);
        }
        return result;

    }
}
