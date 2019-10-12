package leetcode;

public class Solution268 {
    public int missingNumber(int[] nums) {
        int res=0;
        for (int i=1;i<=nums.length;i++){
            res=res^i;
        }
        for (int x:nums){
            res=res^x;
        }
        return res;
    }

    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

}
