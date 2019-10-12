package jianzhioffer;

/**
 * @ClassName : Solution46
 * @Description : 把数字翻译成字符串
 *  * 思路：从后往前开始翻译，规律是// f(r-2)=f(r-1)+g(r-2,r-1)*f(r)
 *  * 参考：https://www.jianshu.com/p/80e1841909b7
 * @Date : 2019/9/19 20:29
 */
public class Solution46 {
    public static int getTranslationCount(int number){
        if (number<0)
            return 0;
        String s=String.valueOf(number);
        int f1=1;
        int f2=1;
        int g=0;
        int temp;
        int length=s.length();
        for (int i=length-2;i>=0;--i){
            if (Integer.parseInt(s.charAt(i)+""+s.charAt(i+1))<26){
                g=1;
            }else {
                g=0;
            }
            temp=f2;
            f2=f2+g*f1;  // f(r-2)=f(r-1)+g(r-2,r-1)*f(r)
            f1=temp;

        }
        return f2;
    }
}

