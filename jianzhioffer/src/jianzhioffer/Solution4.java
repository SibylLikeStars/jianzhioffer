package jianzhioffer;

/**
 * 二维数组中的查找：每一行都按照从左到右递增的顺序排序，列从上往下递增，输入二维数组和一个整数，判断数组中是否存在该整数
 *  思路：从右上或左下开始查找，不能从左上或右下，因为两个方向上的变化都是一样的
 */
public class Solution4 {

    public static boolean find(int[][] array,int target){
        if (array==null){
            return false;
        }
        int rows=array.length;
        int columns=array[0].length;
        int r=0;
        int c=columns-1;
        while(r<rows&&c>=0){
            if (array[r][c]==target){
                return true;
            }
            if (array[r][c]>target){//比目标大，则向左，c--
                c--;
            }else{
                r++;      //比目标小，则向下，r++
            }
        }
        return false;
    }

    public static void main(String args[]){
        int[][] matrix=new int[][]{{1,2,8,9},{2,4,9,2},{4,7,10,13},{6,8,11,15}};
        boolean result=find(matrix,7);
        System.out.println(result);

    }
}
