package jianzhioffer;

/**
 * @ClassName : Pro45Ugly
 * @Description : 得到第n个丑数
 * @Date : 2019/3/11 16:22
 */
public class Solution49 {
    // 来自牛客的优选答案，for循环部分很巧，不知道怎么想到的（剑指offer上有）
    public int GetUglyNumber_Solution(int index) {
        if (index<=0)
            return 0;
        if (index<7)
            return index;
        // 第一步，定义一个数组，里面是排好序的数组
        // 从生成的角度来得到
        int [] res=new int[index];
        res[0]=1;
        int t2 = 0, t3 = 0, t5 = 0;
        for(int i = 1;i < index; i++){
            res[i] = Math.min(res[t2]*2,Math.min(res[t3]*3,res[t5]*5));
            if(res[i] == res[t2]*2)
                t2++;
            if(res[i] == res[t3]*3)
                t3++;
            if(res[i] == res[t5]*5)
                t5++;
        }
        return res[index - 1];
    }
}
