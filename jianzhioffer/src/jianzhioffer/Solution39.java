package jianzhioffer;

import java.util.Arrays;

/**
 * @ClassName : Solution39
 * @Description : 数组中出现的次数超过一半的数字
 * 方法1：统计学上的中位数，先排序，取中间
 * 方法2**：先找出出现频率最高的，再【验证其是否真的超过一半】。
 * @Date : 2019/9/19 19:34
 */
public class Solution39 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array==null || array.length==0)
            return 0;
        int aimNum=array[0];
        int time=1;
        for (int i=1;i<array.length;i++){
           if (time>0){
               if (array[i]==aimNum){
                   time++;
               }else{
                   time--;
               }
           }else{
               aimNum=array[i];
               time=1;
           }
        }
        final int num=aimNum;
        int occurTime= (int)Arrays.stream(array).filter(v->v==num).count();
        if (occurTime*2>array.length)
            return num;
        else
            return 0;
    }
}
