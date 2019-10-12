package jianzhioffer;

/**
 * @ClassName : Solution62
 * @Description : TODO
 * @Date : 2019/4/4 11:11
 */
public class Solution62 {

    // 方法1：用数组模拟环形链表，来自牛客的高赞做法，非常简单精简了
    public static int findLastNumber(int n,int m){
        if (n<1||m<1)
            return -1;
        int [] array=new int[n];
        int i=-1;  //初始下标
        int step=0; //步长
        int count=n; //剩余的小朋友
        while (count>0){ //剩余的小朋友待0时
            i++;
            if (i>=n)  //环的效果
                i=0;
            if (array[i]==-1) //那些出去了的小朋友（不一定要删除这个节点，可以标记）
                continue;
            step++;
            if (step==m){  //到达步长
                array[i]=-1;
                step=0;
                count--;
            }
        }
        return i;
    }

    // 方法2：从数学的角度出发
}
