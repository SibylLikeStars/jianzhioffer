package jianzhioffer;

/**
 * @ClassName : Solution65
 * @Description : TODO
 * @Date : 2019/4/30 14:51
 */
public class Solution65 {
    static int  add(int a,int b){
        int sum;
        int carry;
        do {
            sum=a^b;
            carry=(a&b)<<1;
            a=sum;
            b=carry;
        }while (b!=0);  //直至没有进位
        return a;
    }
    public static void main(String[] args){
        System.out.print(add(3,4));
    }
}
