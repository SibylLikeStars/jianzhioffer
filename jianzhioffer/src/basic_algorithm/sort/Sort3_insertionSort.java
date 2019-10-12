package basic_algorithm.sort;

import java.util.Arrays;

/**
 * 3、直接插入排序
 * 最坏：O(N2)
 * 最好：O(N)
 * 平均：O(N2)
 * 辅助：O(1)
 * 稳定
 */
public class Sort3_insertionSort {
    public static int [] straightInsertionSort(int [] arr){
        int [] res= Arrays.copyOfRange(arr,0,arr.length);
        int temp;//哨兵
        int n=res.length;
        int i;
        int j;
        for (i=1;i<n;i++){  //假设前面的arr[0]-arr[i-1]都排列好了，边界条件，1<=i<=n-1
            if (res[i]<res[i-1]){ // 如果a[i]比前面的最大值还小，说明应该插入
                temp=res[i];  // 等会儿会被移动所覆盖，先找个地方放一下
                for (j=i-1;j>=0&&res[j]>temp;j--) { //这里有一个边界条件，j>=0，一定不能错！从i-1的位置挨个往前找，如果发现比要插入的temp大，则将这个值往后移一位，让出空格
                    res[j + 1] = res[j];
                }
                res[j+1]=temp;
            }
        }

        return res;
    }

    public static void main(String [] args){
        int [] array=new int []{5,3,4,6,2};
        int [] result=straightInsertionSort(array);
        System.out.println(Arrays.toString(result));
    }
}
