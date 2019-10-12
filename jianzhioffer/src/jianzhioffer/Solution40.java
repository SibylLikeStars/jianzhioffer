package jianzhioffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName : Solution40
 * @Description : 最小的K个数
 *
 * 求最小的用最大堆，求最大的用最小堆
 * @Date : 2019/9/19 19:42
 */
public class Solution40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if (input==null || input.length==0 || input.length<k || k==0)
            return res;
        //最大堆
        PriorityQueue<Integer> queue=new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int x:input){
            if (queue.size()<k){
                queue.offer(x);
            }else if (x<queue.peek()){
                queue.poll();
                queue.offer(x);
            }
        }
        res.addAll(queue);
        return res;
    }
}
