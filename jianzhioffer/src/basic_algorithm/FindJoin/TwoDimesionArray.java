package basic_algorithm.FindJoin;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 二维数组求连通域
3 5
1 1 0 0 0
0 0 0 1 1
0 0 1 1 1
 */
public class TwoDimesionArray {
    static Integer[] pre;
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        int rows=in.nextInt(); //行数
        int cols=in.nextInt(); //列数
        int[][] arr=new int[rows][cols]; //二维数组
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                arr[i][j]=in.nextInt();
            }
        }
        //初始化pre数组
        pre=new Integer[rows*cols+1];
        pre[rows*cols]=0;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                pre[i*cols+j]=i*cols+j;
            }
        }
        //按从左上角开始遍历，当arr[i,j]==1时，查看右方和下方是否为1，是则绑定
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (arr[i][j]==1) {
                    int down = i + 1;
                    int right = j + 1;
                    if (down < rows && arr[down][j] == 1) {
                        join(i * cols + j, down * cols + j);
                    }
                    if (right < cols && arr[i][right] == 1) {
                        join(i * cols + j, i * cols + right);
                    }
                }
            }
        }

        //计算连通域个数
        int nums=0;
        long maxConnected=0;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                find(i*cols+j);
                if (arr[i][j]==1 && pre[i*cols+j]==i*cols+j){
                    nums++;
                }
            }
        }
        Map<Integer,Long> map=Arrays.stream(pre).collect(Collectors.groupingBy(v->v,Collectors.counting()));
        for (Map.Entry<Integer,Long> entry:map.entrySet()){
            maxConnected=Math.max(maxConnected,entry.getValue());
        }
        System.out.println("连通域个数为："+nums);
        System.out.println("连通域的最大大小为："+maxConnected);
    }

    private static void join(int x,int y){
        int px=find(x);
        int py=find(y);
        if (px!=py){
            pre[x]=py;
        }
    }

    private static int find(int x){
        if (x!=pre[x]){
            pre[x]=find(pre[x]);
        }
        return pre[x];
    }
}
