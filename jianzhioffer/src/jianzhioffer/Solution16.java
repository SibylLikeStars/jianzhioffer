package jianzhioffer;

/**
 * @ClassName : Solution16
 * @Description : 计算乘方
 * 二分法提高效率
 * double的相等判断
 * >>1代替除以2
 * 特殊情况的考虑
 * @Date : 2019/9/16 10:59
 */
public class Solution16 {
    public double Power(double base, int exponent) {
        if (exponent==0)
            return 1;
        if ((base-0<=0.000001) && (base-0>-0.000001))
            return 0.0;
        double res;
        if ((exponent&1)==1){
            res=powerHelper(base,exponent);
        }else{
            res=1.0/powerHelper(base,-exponent);
        }
        return res;

    }

    private double powerHelper(double base, int exponent) {
        if (exponent==0)
            return 1;
        if ((base-0<=0.000001) && (base-0>-0.000001))
            return 0.0;
        double res=Power(base,exponent>>1);
        res*=res;
        if ((exponent&1)==1){
            res*=base;
        }
        return res;
    }
}
