package jianzhioffer;

import java.util.Arrays;

/**
 * @ClassName : Solution61
 * @Description : 扑克牌中的顺子
 * @Date : 2019/4/4 10:05
 */
public class Solution61 {
    // 方法1：满足两个条件，1、（最大值-最小值）《5；2-没有重复数字
    // 先排序
    public boolean isContinuous(int [] numbers) {
        if(numbers==null||numbers.length!=5)
            return false;
        Arrays.sort(numbers);//将其排序
        // the count of 0
        int n0=0;
        for (int i:numbers){
            if (i==0)
                n0++;
        }
        int max=numbers[4];  //最大数
        int min=numbers[n0]; //最小数
        if (max-min<5){
            int i=n0;
            int j=i+1;
            while (j<numbers.length){
                if (numbers[i]==numbers[j])
                    return false;
                i=j++;
            }
            return true;
        }
        return false;
    }

    // 思路2:条件1-0的个数等于相邻数字的空缺总数；条件2-没有对子
}
