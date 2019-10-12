package jianzhioffer;

/**
 * @ClassName : S53_Solution53
 * @Description : 排序数组中某个数字出现的次数
 * @Date : 2019/4/1 10:41
 */
public class Solution53 {
    // 方法1：二分查找，找到这个数；在这个数左右扫描。——O[N]
    // 方法2：二分查找，找到这个数的起始下标和结束下标
    public int GetNumberOfK(int [] array , int k) {
        // 1-输入合法性检查
        // 2-找起始下标
        // 3-找结束下标
        // 第一次没有通过编译的原因是：二分查找的时候，如果不满足条件，需要重新查找，此时起止坐标的赋值不对
        if (array==null||array.length==0)
            return 0;
        int length=array.length;
        int startIndex=getStsrtK(array,k,0,length-1);
        int endIndex=getEndK(array,length,k,0,length-1);
        int res=0;
        if (startIndex>-1&&endIndex>-1){
            res=endIndex-startIndex+1;
        }
        return res;
    }

    private int getEndK(int[] array, int length, int k, int start, int end) {
        if(start>end)
            return -1;
        int mid=(end+start)>>1;
        int midData=array[mid];
        if (midData==k){
            if ((mid<length-1&&array[mid+1]!=k)||mid==length-1)
                return mid;
            else
                start=mid+1;  //这些+-1不能忘记！
        }
        else if (midData<k){
            start=mid+1;
        }else{
            end=mid-1;
        }
        return getEndK(array,length,k,start,end);
    }

    private int getStsrtK(int[] array, int k, int start, int end) {
        if (start>end)
            return -1;
        int mid=(end+start)>>1;
        int midData=array[mid];
        if (midData==k){
            if ((mid>0&&array[mid-1]!=k)||mid==0)
                return mid;
            else
                end=mid-1;
        }
        else if (midData>k){
            end=mid-1;
        }
        else {
            start=mid+1;
        }
        return getStsrtK(array,k,start,end);
    }

}
