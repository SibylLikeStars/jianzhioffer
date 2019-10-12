package leetcode;

/**
 * 盛水容器的最大体积
 */
public class Solution11 {

    //双指针法
    public int maxArea2(int[] height) {
        if(height==null || height.length<=1){
            return 0;
        }
        int max=0;
        int left=0,right=height.length-1;

        while (left<right){
            max=Math.max(max,Math.min(height[left],height[right])*(right-left));
            if (height[left]<height[right]){ //短的向内测移动有可能使面积增大
                left++;
            }else{
                right--;
            }
        }
        return max;
    }



    //暴力遍历法
    public int maxArea(int[] height) {
        if(height==null || height.length<=1){
            return 0;
        }
        int max=0;
        for (int i=0;i<height.length;i++){
            for (int j=i+1;j<height.length;j++){
                max=Math.max(max,(j-i)*Math.min(height[i],height[j]));

            }
        }
        return max;
    }
}
