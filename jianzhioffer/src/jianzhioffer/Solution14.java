package jianzhioffer;

import static java.lang.Math.pow;

/**
 * @Description : 有一条长度为n的绳子，至少切1刀，把绳子切成m段，问各段绳子的长度之乘积最大值是多少？
 * 数学
 * @Date : 2019/1/23 14:08
 */
public class Solution14 {

    // 方法1：动态规划法
    public static int cutRope(int n){
        // 当长度小于等于3时，不能使用动态规划
        if (n<2){
            return 0;
        }
        if (n==2){
            return 1;
        }
        if (n==3){
            return 2;
        }
        // 当长度大于3时，使用动态规划，product[]是一个辅助数组，但前4项代表分出来子长度的最大乘积；
        int [] product=new int[n+1];
        product[0]=0;
        product[1]=1;
        product[2]=2;
        product[3]=3;
        int max=0;
        for(int i=4;i<=n;++i){  // 表示长度为i的绳子切成若干段，最大乘积是多少
            max=0;
            for (int j=1;j<=i;++j){
                int temp=product[j]*product[i-j];
                if (max<temp)
                    max=temp;
                product[i]=max;
            }
        }
        max=product[n];
        product=null;
        return max;
    }


    // 方法2：贪婪算法
    // 分析之后几乎就是一个公式的事，所以时间复杂度就是O[1]
    public static int cutRope2(int n){
        if (n<2){
            return 0;
        }
        if (n==2){
            return 1;
        }
        if (n==3){
            return 2;
        }
        int timesOf3=n/3;//最多可以剪这么多段长度为3的绳子
        if (n-timesOf3*3==1){ //如果最后剩余长度不是2、而是1，则宁可剩余4
            timesOf3-=1;
        }
        int timesOf2=(n-timesOf3*3)/2;
        return (int)(pow(3,timesOf3))*(int)(pow(2,timesOf2)); //pow(n,m)计算n的m次方

    }


    public static void main(String [] args){
            System.out.println(cutRope(8));
            System.out.println(cutRope2(8));
}
}
