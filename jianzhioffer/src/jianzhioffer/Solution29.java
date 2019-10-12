package jianzhioffer;

import java.util.ArrayList;

// 顺时针打印矩阵
public class Solution29 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix==null)
            return null;
        int rows=matrix.length;
        int cols=matrix[0].length;
        int start=0;
        ArrayList<Integer> res=new ArrayList<>();
        while (cols<start*2 && rows>start*2){
            printMatrixInClockWise(matrix,cols,rows,start,res);
            ++start;
        }
        return res;
    }

    public void  printMatrixInClockWise(int[][] matrix, int cols, int rows, int start,ArrayList<Integer> res) {
        int endX=cols-1-start;
        int endY=rows-1-start;
        // 左——右
        for (int i=start;i<=endX;i++){
            int number=matrix[start][i];
            res.add(number);
        }
        //上——下
        if (start<endY){
            for (int i=start+1;i<=endY;++i){
                int number =matrix[i][endX];
                res.add(number);
            }
        }
        // 右——左
        if (start<endX&& start<endY){
            for (int i=endX-1;i>=start;--i){
                int number = matrix[i][endY];
                res.add(number);
            }
        }

        if (start<endX&& start<endY){
            for (int i=endY-1;i>=start+1;--i){
                int number=matrix[i][start];
                res.add(number);
            }
        }


    }


}
