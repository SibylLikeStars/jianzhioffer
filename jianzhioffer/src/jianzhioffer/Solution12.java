package jianzhioffer;

/**
 * @ClassName : Solution12
 * @Description : 矩阵中的最短路径
 * 给一个字符数组和字符串，查看这个字符数组中能否拼出这个字符串来
 * 回溯法
 * 牛客没有
 * @Date : 2019/9/16 10:28
 */
public class Solution12 {
    public boolean hasPath(char[] maze,int rows,int cols,char[] str){
        if (maze==null || rows==0 || cols==0 || str==null ||str.length==0)
            return false;
        int n=maze.length;
        int [] visit=new int[n];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (hasPathHelper(maze,rows,cols,str,i,j,0,visit))
                    return true;
            }
        }
        return false;
    }

    private boolean hasPathHelper(char[] maze, int rows, int cols, char[] str, int i, int j, int index, int[] visit) {
        int curindex=i*cols+j;
        if (i<0 || i>=rows || j<0 || j>=cols || maze[curindex]!=str[index] || visit[curindex]==1)
            return false;
        if (index==str.length-1)
            return true;
        visit[index]=1;
        if (hasPathHelper(maze,rows,cols,str,i+1,j,index+1,visit) ||
                hasPathHelper(maze,rows,cols,str,i-1,j,index+1,visit) ||
                hasPathHelper(maze,rows,cols,str,i,j+1,index+1,visit) ||
                hasPathHelper(maze,rows,cols,str,i,j-1,index+1,visit) )
            return true;
        visit[index]=0;
        return false;
    }
}
