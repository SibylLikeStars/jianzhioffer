package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1、两数之和
 */
public class Solution1 {
    //方法2：哈希表，数-下标
    public int[] twoSum2(int[] nums, int target) {
        int [] ans=new int[2];
        if (nums==null || nums.length==0)
            return ans;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0; i<nums.length;i++){
            int left=target-nums[i];
            if (map.containsKey(left)){
                ans[0]=map.get(left);
                ans[1]=i;
                break;
            }else{
                map.put(nums[i],i);
            }
        }
        return ans;
    }


    //方法1：暴力遍历
    public int[] twoSum1(int[] nums, int target) {
        int [] ans=new int[2];
        if (nums==null || nums.length==0)
            return ans;
        int n=nums.length;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if (nums[i]+nums[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                    break;
                }
            }
        }
        return ans;
    }
    //有序数组，两数之和，用双指针
    public int[] twoSum(int[] nums, int target) {
        int [] ans=new int[2];
        if (nums==null || nums.length==0)
            return ans;
        int l=0,r=nums.length-1;
        while (l<r){
            if (nums[l]+nums[r]==target){
                ans[0]=l;
                ans[1]=r;
                break;
            }else if (nums[l]+nums[r]>target){
                r--;
            }else{
                l++;
            }
        }
        return ans;
    }
}
