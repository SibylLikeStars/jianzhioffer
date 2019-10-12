package jianzhioffer;

/**
 * @ClassName : Solution15
 * @Description : 二进制中1的个数
 * @Date : 2019/9/16 10:56
 */
public class Solution15 {
    //方法3：最推荐的做法
    public int NumberOf1(int n) {
        int count=0;
        while (n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }

    //方法2：
    // 改进方法1，不移动原有的数，移动比较参照的“1”
    public static int count2(int n){
        int count=0;
        int flag=1;
        while(flag!=0){
            if ((n&flag)!=0)
                count++;
            flag=flag<<1;
        }
        return count;
    }

    //方法1：可能引起死循环
    // 一个整数与1做&计算，结果为1，则末位为1，将该数右移1位，继续操作，直至该数为0
    // 缺陷：若这个数是负数，则可能陷入死循环
    public static int count1(int n){
        int count=0;
        while(n!=0){
            if ((n&1)!=0)
                count++;
            n=n>>1;
        }
        return count;
    }
}
