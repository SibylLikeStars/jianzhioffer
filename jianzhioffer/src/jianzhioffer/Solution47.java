package jianzhioffer;

/**
 * @ClassName : Solution47
 * @Description : 礼物的最大值
 * @Date : 2019/9/19 20:34
 */
public class Solution47 {
    static int maxValue(int [][] gift){
        int rows=gift.length;
        int cols=gift[0].length;
        int [][] maxValue=new int[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                maxValue[i][j]=0;
            }
        }
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                int left=0;
                int up=0;
                if (i>0)
                    up=maxValue[i-1][j];
                if (j>0)
                    left=maxValue[i][j-1];
                maxValue[i][j]=Math.max(left,up)+gift[i][j];
            }
        }
        return maxValue[rows-1][cols-1];
    }
}
