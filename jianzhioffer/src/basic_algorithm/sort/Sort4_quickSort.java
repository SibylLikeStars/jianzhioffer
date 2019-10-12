package basic_algorithm.sort;

import java.util.Stack;

/**
 * 4、快排
 * 最好：O(NlogN）
 * 最坏：O(N2)
 * 平均：O(NlogN）
 * 辅助：O(logN)-O(N)
 * 不稳定
 * 递归版、非递归版、优化版
 */
public class Sort4_quickSort {

    //方法1：递归版
    public static void quickSort(int [] arr){
        qSort(arr,0,arr.length-1);
    }
    public static void qSort(int [] arr,int low,int high){
        int pivot;
        if (low<high){
            pivot=partition(arr,low,high);
            qSort(arr,low,pivot-1);
            qSort(arr,pivot+1,high);
        }
    }
    public static int  partition(int [] arr,int low,int high){
        int pivotKey;
        pivotKey=arr[low];  //固定选择第一个数作为枢
        while(low<high){
            while(low<high && arr[high]>=pivotKey){
                high--;
            }
            arr[low]=arr[high];
            while (low<high && arr[low]<=pivotKey){
                low++;
            }
            arr[high]=arr[low];
        }
        arr[low]=pivotKey;
        return low;
    }

    //方法2：非递归版
    private static void quickSort(int[] a, int left, int right) {
        Stack<Integer> s = new Stack<Integer>(); // 用栈模拟
        if (left < right) {
            s.push(left);
            s.push(right);
            while (!s.isEmpty()) {
                int r = s.pop();
                int l = s.pop();
                int p = partition(a, l, r);
                if (l < p - 1) {
                    s.push(p - 1);
                    s.push(l);
                }
                if (r > p + 1) {
                    s.push(r);
                    s.push(p + 1);
                }
            }
        }
    }

    //方法3：优化版本
    public static void quickSortPro(int [] arr){
        qSortPro(arr,0,arr.length-1);
    }
    public static void qSortPro(int [] arr,int low,int high){
        int pivot;
        // 优化3：当数组长度不超过阈值时，采用插值排序
        // 优化4：优化递归操作，采用尾递归，缩减堆栈深度
        while(low<high){
            pivot=partition(arr,low,high);
            qSortPro(arr,low,pivot-1);
            low=pivot+1;  // 如此相当于另一部分的递归
        }
    }
    public static int  partitionPro(int [] arr,int low,int high){
        int pivotKey;
        // 优化1：枢取数组左中右三个数间的中间值
        int mid=(low+high)/2;
        if (arr[low]>arr[high]){
            swap(arr,low,high);
        }
        if (arr[mid]>arr[high]){
            swap(arr,mid,high);
        }
        if (arr[mid]<arr[low]){
            swap(arr,mid,low);
        }
        pivotKey=arr[mid]; //此时mid上就是中间值

        // 优化2：省去不必要的交换，因为枢的最终目的其实就是low，我们直接将其赋值到最后选出来的low即可
        while(low<high){
            while(low<high && arr[high]>=pivotKey){
                high--;
            }
            arr[low]=arr[high];
            while (low<high && arr[low]<=pivotKey){
                low++;
            }
            arr[high]=arr[low];
        }
        arr[low]=pivotKey;
        return low;
    }
    public static void swap(int [] arr,int m,int n){
        int temp=arr[m];
        arr[m]=arr[n];
        arr[n]=temp;
    }

}
