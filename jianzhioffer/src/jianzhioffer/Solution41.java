package jianzhioffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName : Solution41
 * @Description : 数据流中的中位数
 * 用最大堆和最小堆来实现：中位数，把数组分成了两部分，一部分全小于mid，另一部分全大于mid
 * 最大堆存小的数，最小堆存大的数，奇数放小数，偶数使放大数
 * @Date : 2019/9/19 19:51
 */
public class Solution41 {
    int count=0;
    PriorityQueue<Integer> largePart=new PriorityQueue<>();
    PriorityQueue<Integer> smallPart=new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    public void insert(int num){
        count++;
        if ((count&1)==1){
            if (!largePart.isEmpty() && largePart.peek()<num){
                largePart.offer(num);
                num=largePart.poll();
            }
            smallPart.offer(num);
        }else{
            if (!smallPart.isEmpty() && smallPart.peek()>num){
                smallPart.offer(num);
                num=smallPart.poll();
            }
            largePart.offer(num);
        }
    }

    public double getMidian(){
        if ((count&1)==1)
            return smallPart.isEmpty()?-1:smallPart.peek();
        else
            return (smallPart.peek()+largePart.peek())/2.0;
    }

}
