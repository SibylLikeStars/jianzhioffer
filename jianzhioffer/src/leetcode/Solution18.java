package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 18、4数之和
 */
public class Solution18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        if (nums==null || nums.length<4)
            return res;
        ArrayList<Integer> list=new ArrayList<>();
        findSumHelper(nums,target,res,list,0);
        return res;
    }

    private void findSumHelper(int[] nums, int target, List<List<Integer>> res, ArrayList<Integer> list,int index) {
        if (index>=nums.length){
            return;
        }
        list.add(nums[index]);
        target-=nums[index];
        if (target==0){
            res.add(new ArrayList<>(list));
        }else{
            findSumHelper(nums,target,res,list,index+1);
        }
        list.remove(list.size()-1);
    }
}
