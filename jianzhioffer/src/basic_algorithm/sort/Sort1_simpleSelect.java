package basic_algorithm.sort;

import java.util.Arrays;

/**
 * 1、简单选择排序
 * 最好：O(N2)
 * 最坏：O(N2)
 * 平均：O(N2)
 * 辅助：O(1)
 * 稳定
 */
public class Sort1_simpleSelect {
    private static int [] simpleSelect(int [] arr){
        int [] res= Arrays.copyOfRange(arr,0,arr.length);
        int n=res.length;
        int min;
        // 边界条件：至少要n-1轮，找最小值过程中，j从i+1到n-1
        for (int i=0;i<n-1;i++){
            min=i;
            for (int j=i+1;j<n;j++){  //从i+1<=j<n-1中找出最小的数，并将其下标赋值给min
                if (res[min]>res[j]){
                    min=j;
                }
            }
            if (i!=min){  //如果min与i不同，则将这两个位置的值互换
                int temp=res[i];
                res[i]=res[min];
                res[min]=temp;
            }
        }
        return res;
    }

    public static void main(String [] args){
        int [] array=new int []{1,1,2,0,9,3,12,99,7,8,3,4,65,22 };
        int [] result=simpleSelect(array);
        System.out.println(Arrays.toString(result));
    }
}
