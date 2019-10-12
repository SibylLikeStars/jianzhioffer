package jianzhioffer;

/**
 * @ClassName : Solution42
 * @Description : 连续子数组的最大和
 * 基于数组中有正有负的情况，不然，如果同号，那么就直接排序取最小，不存在连续最大和的问题
 * @Date : 2019/9/19 19:51
 */
public class Solution42 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array==null || array.length==0)
            return 0;
        int max=Integer.MIN_VALUE;
        int cur=0;
        for (int x:array){
            if (cur<=0)
                cur=x;
            else
                cur+=x;
            max=Math.max(cur,max);
        }
        return max;
    }
}
