package basic_algorithm.sort;

import java.util.Arrays;

/**
 * 5、归并排序
 * 最好：O(NlogN)
 * 最坏：O(NlogN)
 * 平均：O(NlogN)
 * 辅助：O(N)
 * 不稳定
 */
public class Sort5_mergeSort {

    public static int[] msort(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            msort(a,low,mid);
            msort(a,mid+1,high);
            //左右归并
            merge(a,low,mid,high);
        }
        return a;
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        if (temp.length >= 0)
            System.arraycopy(temp, 0, a, low, temp.length);
    }

    public static void main(String [] args){
        int[] array=new int[]{5,1,9,3,7,4,8,6,2};
        System.out.println("原数组: "+ Arrays.toString(array));
        msort(array,0,array.length-1);
        System.out.println("排序后: "+Arrays.toString(array));
    }
}
