package jianzhioffer;

/**
 * @ClassName : Solution10
 * @Description : 斐波那契数列
 *  求斐波那契数列 的第n个
 *  斐波那契数列：F(0)=0，F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)
 * @Date : 2019/9/15 18:29
 */
public class Solution10 {
    public int Fibonacci(int n) {
        if (n==0)
            return 0;
        if (n==1)
            return 1;
        if (n==2)
            return 1;
        int a=0;
        int b=1;
        int i=1;  //注意初始条件哦
        int ans=0;
        while (i<n){
            ans=a+b;
            a=b;
            b=ans;
            i++;
        }
        return ans;
    }

    //递归
    public int Fibonacci2(int n) {
        if (n==0)
            return 0;
        if (n==1)
            return 1;
        if (n==2)
            return 1;
        return Fibonacci2(n-1)+Fibonacci2(n-2);
    }

}
