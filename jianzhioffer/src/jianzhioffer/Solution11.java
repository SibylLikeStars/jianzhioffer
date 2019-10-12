package jianzhioffer;

/**
 * @ClassName : Solution11
 * @Description : 从反转数组中找出最小的数字：要再看一下
 * 这题不够熟悉
 * 比较的是左右元素，而不是下标。
 * 特殊情况是左、中、右相等
 *
 * 其他变形：判断翻转数组是否存在某个数，存在则返回index，不存在则插入这个数，返回插入后的index
 * @Date : 2019/9/15 18:35
 */
public class Solution11 {
    public int minNumberInRotateArray(int [] array) {
        int left=0;
        int right=array.length-1;
        int mid=0;
        while(array[left]>=array[right]){
            if (right-left<=1){
                mid=right;
                break;
            }
            mid=(left+right)/2;
            if (array[left]==array[mid] && array[right]==array[mid]){
                if (array[left+1]!=array[right-1]){
                    mid=array[left+1]<array[right-1]?left+1:right-1;
                }else{
                    left++;
                    right--;
                }
            }else{
                if (array[left]<=array[mid]){
                    left=mid;
                }else{
                    right=mid;
                }
            }
        }
        return array[mid];
    }
}
