package jianzhioffer;

/**
 * @ClassName : Solution13
 * @Description : 机器人的运动路径
 * 牛客没有
 * 这个就不用回溯了，直接统计
 * @Date : 2019/9/16 10:41
 */
public class Solution13 {
    public int moveCount(int thred,int rows,int cols){
        if (thred<0 || rows<=0 || cols<=0)
            return 0;
        int [] visit=new int[rows*cols];
        return moveCountHelper(thred,rows,cols,0,0,visit);
    }

    private int moveCountHelper(int thred, int rows, int cols, int i, int j, int[] visit) {
        int count=0;
        if (i>=0 && i<rows && j>=0 && j<cols && visit[i*cols+j]==0 && calcuSum(i)+calcuSum(j)<=thred){
            visit[i*cols+j]=1;
            count=1+moveCountHelper(thred,rows,cols,i+1,j,visit)
                    +moveCountHelper(thred,rows,cols,i-1,j,visit)
                    +moveCountHelper(thred,rows,cols,i,j+1,visit)
                    +moveCountHelper(thred,rows,cols,i,j-1,visit);
        }
        return count;
    }

    //计算一个数各个位上的和
    private int calcuSum(int i) {
        int sum=0;
        while (i!=0){
            sum+=i%10;
            i=i/10;
        }
        return sum;
    }
}
