package leetcode;

import java.util.Arrays;

/**
 * 最长上升子序列
 */
public class Solution300 {
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        Arrays.stream(dp).forEach(System.out::println);
        return len;
    }
    public int LIS(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int n=nums.length;
        int [] dp=new int[n];
        for (int i=0;i<n;i++){
            dp[i]=1;
        }
        int lis=1;
        for (int i=1;i<n;i++){
            int max=1;
            for (int j=0;j<i;j++){
                if (nums[j]<nums[i]){
                    max=dp[j]+1>max?dp[j]+1:max;
                }
            }
            dp[i]=max;
            lis=Math.max(lis,max);
        }
        return lis;
    }
    public static void main(String[] args){
        Solution300 a=new Solution300();
        int[] arr={1,7,3,5,9,8,4};
        a.lengthOfLIS2(arr);
    }
}
