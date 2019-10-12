package jianzhioffer;

/**
 * @ClassName : Solution64
 * @Description : 求1+2+……+n,不能用乘除、循环、条件分支
 * 那就用递归
 * @Date : 2019/4/30 15:09
 */
public class Solution64 {

    public static int Sum_Solution(int n) {
        int sum = n;
        boolean result = (n > 0) && ((sum += Sum_Solution(n-1)) > 0);//短路与的妙用。就是很妙
        return sum;
    }

    public static void main(String[] args){
        System.out.print(Sum_Solution(3));
    }
}
