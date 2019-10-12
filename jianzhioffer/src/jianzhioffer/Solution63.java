package jianzhioffer;

/**
 * @ClassName : Solution63
 * @Description : 最大利润
 * 和和42、48题很像：遍历+当前最大+历史最大
 * @Date : 2019/4/30 14:34
 */
public class Solution63 {
    public static int getMaxDiff(int[] nums){
        if (nums==null||nums.length==0)
            return 0;
        int min=nums[0];
        int max=0;
        int cur=0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]<min)   //过去的最小值
                min=nums[i];
            cur=nums[i]-min;
            if (cur>max)    //差值最大值
                max=cur;
        }
        return max;
    }
    public static void main(String[] args){
        System.out.print(getMaxDiff(new int[]{9,11,8,5,7,12,16,14}));
    }
}
