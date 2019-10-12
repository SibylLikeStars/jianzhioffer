package leetcode;

/**
 * 33、搜索旋转排序数组
 */
public class Solution33 {
    public static void main(String[] args) {
        Solution33 s = new Solution33();
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2},3));
    }
    public int search(int[] nums, int target) {
        if (nums==null || nums.length==0){
            return -1;
        }
        int left=0,right=nums.length-1,mid;
        while (left<=right) {
            mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            //左侧是递增的
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //右侧是递增的
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
