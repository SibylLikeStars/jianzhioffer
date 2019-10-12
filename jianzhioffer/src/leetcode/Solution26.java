package leetcode;

/**
 * 原地删除数组中重复的元素，返回删除之后的长度
 */
public class Solution26 {
    //官方解法，也是双指针，但是会简洁很多
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {  //遇到不等的
                i++;   //巧妙之处在于i不着急+1
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    //自己写的：双指针法
    //i：慢指针，要填入的； j：快指针，寻找填入的
    public int removeDuplicates(int[] nums) {
        if (nums==null ||nums.length==0)
            return 0;
        int i=1,j=1;
        int n=nums.length;
        while (i<n && j<n){
            if (nums[i]<=nums[i-1]  ){
                while(j<n && nums[j]<=nums[i-1] ){
                    j++;
                }
                if (j==n){
                    break;
                }else{
                    nums[i]=nums[j];
                    i++;
                    j++;
                }

            }else{
                i++;
                j++;
            }
        }
        return i;
    }
    public static void main(String[] args){
        Solution26 s=new Solution26();
        int[] num={1,1,1,1,1,2,2,2,2,3,3};
        System.out.println(s.removeDuplicates2(num));

    }
}
