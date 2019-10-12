package leetcode;

/**
 * 4、两个有序数组的中位数
 */
public class Solution4 {
    //方法2：官方解答，二分的思路
    public double findMedianSortedArrays2(int[] A, int[] B){
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }


    //方法1：按“合并排序列表”的思想，能通过，但是不符合题目的复杂度要求
    public double findMedianSortedArrays3(int[] A, int[] B){
        int m=A.length;
        int n=B.length;
        int halfLen=(m+n)/2;
        int [] helper=new int[halfLen+1];//辅助数组
        int i=0,j=0,index=0;
        while (index<halfLen+1 && (i<m||j<n )){
            if (i==m){ //i已经到末尾了
                helper[index]=B[j++];
            }else if (j==n){ //j已经到末尾了
                helper[index]=A[i++];
            }else{
                if (A[i]<B[j]){
                    helper[index]=A[i++];
                }else{
                    helper[index]=B[j++];
                }
            }
            index++;
        }
        if (((m+n)&1)==0){ //偶数个
            return (helper[halfLen]+helper[halfLen-1])/2.0;
        }else{
            return helper[halfLen];
        }
    }
}
