package jianzhioffer;

/**
 * @ClassName : Solution21
 * @Description : 调整数组顺序使奇数位于偶数的前面
 * @Date : 2019/9/16 13:09
 */
public class Solution21 {
    //方法1：双指针法：这个无法保证相对顺序正确
    public void reOrderArray(int [] array) {
        if (array==null || array.length==0)
            return;
        int left=0;
        int right=array.length-1;
        while (left<right){
            while ((array[left]&1)==1 && left<right)
                left++;
            while ((array[right]&1)==0 && right>left)
                right--;
            if (left<right){
                int tmp=array[left];
                array[left]=array[right];
                array[right]=tmp;
            }
        }
    }
    //方法2：冒泡法：这个能保证相对顺序，这个能通过牛客网测试
    //从i=1开始遍历，如果是奇数，则向前找到偶数，找到一个换一个位置
    public void reOrderArray2(int [] array) {
        if (array==null || array.length==0)
            return;
        for (int i=1;i<array.length;i++){
            int tmp=array[i];
            int j=i-1;
            if ((tmp&1)==1){
                while (j>=0){
                    if ((array[j]&1)==1) {
                        break;
                    }else{
                        int t=array[j+1];
                        array[j+1]=array[j];
                        array[j]=t;
                        j--;
                    }

                }
            }
            array[j+1]=tmp;

        }
    }

}
