package basic_algorithm.sort;

import java.util.Arrays;

/**
 * 2、冒泡排序
 * 最好：没有优化-O(N2)，优化O(N)
 * 最坏：O(N2)
 * 平均：O(N2)
 * 稳定
 */
public class Sort2_bubbleSort {
    //3、冒泡排序的优化
    // 设置标志位，若每一轮结束时，flag为true，则要进入下一轮。若没有发生交换，则flag为false，不满足继续下一轮的条件，从而退出for循环
    public static int [] bubbleSort3(int[] arr ){
        boolean flag=true;
        int[] res=Arrays.copyOfRange(arr,0,arr.length);
        for (int i=0;(i<(res.length-1))&&flag;i++){   //如果有一轮没有交换，说明排序已经完成了，标志位false
            flag=false;
            for (int j=0;j<res.length-1-i;j++){
                if (res[j]>res[j+1]){
                    int temp=res[j+1];
                    res[j+1]=res[j];
                    res[j]=temp;
                    flag=true;
                }
            }
        }
        return res;
    }

    // 2、正宗冒泡排序
    // 下沉式
    public static int [] bubbleSort2(int[] arr){
        int[] res=Arrays.copyOfRange(arr,0,arr.length);
        for (int i=0;i<res.length-1;i++){     // 每循环一次，把最小值冒泡到顶端，同时，较小的数也会上前移动
            for (int j=0;j<res.length-1-i;j++){
                if (res[j]>res[j+1]){
                    int temp=res[j+1];
                    res[j+1]=res[j];
                    res[j]=temp;
                }
            }
        }
        return res;
    }
    // 上浮式
    public static int [] bubbleSort4(int[] arr){
        int[] res=Arrays.copyOfRange(arr,0,arr.length);
        for (int i=0;i<res.length-1;i++){     // 每循环一次，把最小值冒泡到顶端，同时，较小的数也会上前移动
            for (int j=res.length-2;j>=i;j--){
                if (res[j]>res[j+1]){
                    int temp=res[j+1];
                    res[j+1]=res[j];
                    res[j]=temp;
                }
            }
        }
        return res;
    }


    // 1、非正宗冒泡
    // 外层for循环完成一次，则将i的位置放置当前最小值，最坏情况，（n-1）*（n-2），时间复杂度O(n*n)
    public static int[] bubbleSort1(int[] arr){
        int[] res= Arrays.copyOfRange(arr,0,arr.length);
        for (int i=0;i<res.length-1;i++){         // 循环一次，保证前i个都是最小值
            for (int j=i+1;j<res.length;j++){
                if (res[i]>res[j]){
                    int temp=res[i];
                    res[i]=res[j];
                    res[j]=temp;
                }
            }
        }
        return res;
    }

    public static void main(String [] args){
        int [] array=new int []{1,1,2,0,9,3,12,99,7,8,3,4,65,22 };
//        int [] array=new int []{99,88,7,6,5,4,3,2,1,1,0};
        int [] result1=bubbleSort1(array);
        int [] result2=bubbleSort2(array);
        int [] result4=bubbleSort4(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result4));
    }
}
