package jianzhioffer;

/**
 * @ClassName : S51_Solution51
 * @Description : 数组中的逆序对
 * @Date : 2019/4/1 9:28
 */
public class Solution51 {
    // 方法1，逐一遍历，逐一比较，时间复杂度n2
    // 方法2，利用归并排序的方法
    public int InversePairs(int [] array) {
        int length=array.length;
        if (array==null||length==0)
            return 0;
        int[] copy=new int[length];
        for (int i=0;i<length;i++)
            copy[i]=array[i];
        int count=InversePairsCore(array,copy,0,length-1);
        return count;
    }

    private int InversePairsCore(int[] array,int[] copy,int low,int high)
    {
        if(low==high)
        {
            return 0;
        }
        int mid = (low+high)>>1;
        int leftCount = InversePairsCore(array,copy,low,mid)%1000000007;
        int rightCount = InversePairsCore(array,copy,mid+1,high)%1000000007;
        int count = 0;
        int i=mid;
        int j=high;
        int locCopy = high;
        while(i>=low&&j>mid)
        {
            if(array[i]>array[j])
            {
                count += j-mid;
                copy[locCopy--] = array[i--];
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
            }
            else
            {
                copy[locCopy--] = array[j--];
            }
        }
        for(;i>=low;i--)
        {
            copy[locCopy--]=array[i];
        }
        for(;j>mid;j--)
        {
            copy[locCopy--]=array[j];
        }
        for(int s=low;s<=high;s++)
        {
            array[s] = copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;
    }
// 书上的，答案不太对，但是书上的思路会清晰一些
//    private int InversePairsCore(int[] array, int[] copy, int start, int end) {
//        if (start==end){
//            return 0;
//        }
//        int length=(end-start)>>1;
//        int left=InversePairsCore(copy,array,start,start+length)%1000000007;
//        int right=InversePairsCore(copy,array,start+length+1,end)%1000000007;
//
//        int i=start+length;
//        int j=end;
//        int indexCopy=end;
//        int count=0;
//        while(i>=start&&j>start+length+1){
//            if (array[i]>array[j]){
//                copy[indexCopy--]=array[i--];
//                count+=j-start-length;
//                if(count>=1000000007)//数值过大求余
//                {
//                    count%=1000000007;
//                }
//            }else{
//                copy[indexCopy--]=array[j--];
//            }
//        }
//        for (;i>=start;--i)
//            copy[indexCopy--]=array[j];
//        for (;j>=start+length+1;--j)
//            copy[indexCopy--]=array[j];
//        return (left+right+count)%1000000007;
//    }
}
