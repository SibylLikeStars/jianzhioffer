package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 */
public class Solution56 {

    //合并区间

    //排序
     public int[][] merge(int[][] intervals) {
         List<int[]> list=new ArrayList<>();
         if (intervals==null ||intervals.length==0){
             return list.toArray(new int[0][]);
         }
         Arrays.sort(intervals,new Comparator<int[]>(){
             @Override
             public int compare(int[] o1, int[] o2) {
                 return o1[0]-o2[0];
             }
         });
         int i=0;
         while (i<intervals.length){
             int left=intervals[i][0];
             int right=intervals[i][1];
             while(i<intervals.length-1 && right>=intervals[i+1][0]){
                 right=Math.max(intervals[i+1][1],right);
                 i++;
             }
             list.add(new int[] {left,right});
             i++;
         }
         return list.toArray(new int[0][]);



     }

    //并查集的方式可能不太好，空间消耗太大了
//    public int[][] merge(int[][] intervals) {
//        int n=intervals.length;  //组数
//        int begin=Integer.MAX_VALUE;
//        int end=Integer.MIN_VALUE;
//        for (int[] x:intervals){
//            begin=Math.min(begin,x[0]);
//            end=Math.max(end,x[1]);
//        }
//        int len=end-begin+1;
//        Integer[] tmp=new Integer[len];
//        //初始化数组
//        for (int[] x:intervals){
//            for (int i=x[0];i<x[1];i++){
//                tmp[i+len]=x[0];
//            }
//        }
//    }
}
