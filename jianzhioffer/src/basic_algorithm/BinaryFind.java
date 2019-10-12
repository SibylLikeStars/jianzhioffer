package basic_algorithm;

/**
 * 二分查找
 */
public class BinaryFind {
    //方法1：循环实现
    public int binFind(int[] arr, int target){
        if (arr==null||arr.length==0)
            return -1;
        int low=0,high=arr.length-1,mid=0;
        while (low<=high){
            mid=(low+high)/2;
            if (arr[mid]==target){
                return mid;
            }else if (arr[mid]>target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }

    //方法2：递归实现
    public int binFind1(int[] arr, int target){
        if (arr==null||arr.length==0)
            return -1;
        int low=0,high=arr.length-1;
        return binFindHelper(arr,target,low,high);
    }

    private int binFindHelper(int[] arr, int target, int low, int high) {
        int mid=(low+high)/2;
        if (arr[mid]==target){
            return mid;
        }else if(arr[mid]>target){
            return binFindHelper(arr,target,low+1,mid);
        }else{
            return  binFindHelper(arr,target,mid,high-1);
        }
    }
}
