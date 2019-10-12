package leetcode;

/**
 * 三数之和最接近目标值
 */
public class Solution16 {

    //双指针法：排序，固定一个数，另外两个指针



    //暴力遍历：倒是没有报这个错误，反而是一个测试用例没过去
    public int threeSumClosest(int[] nums, int target) {
        if (nums==null || nums.length==0){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        int len=nums.length;
        for (int i=0;i<len;i++){
            for (int j=i+1;j<len;j++){
                for (int k=j+1;k<len;k++){
                    if (Math.abs(min-target)>Math.abs(nums[i]+nums[j]+nums[k]-target)){
                        min=nums[i]+nums[j]+nums[k]-target;
                    }
                }
            }
        }
        return min;
    }
}
