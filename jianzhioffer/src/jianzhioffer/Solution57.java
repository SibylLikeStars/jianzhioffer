package jianzhioffer;

import java.util.ArrayList;

/**
 * @ClassName : Solution57
 * @Description : 数组中和为S的两个数字
 * @Date : 2019/4/2 15:33
 */
public class Solution57 {
    public static void main(String [] args){
        int [] test=new int[]{1,2,4,7,11,15};
        ArrayList<Integer> res=FindNumbersWithSum2(test,15);
        System.out.print(res.get(0)+"  "+res.get(1));
    }
    // 57.1 数组中和为S的两个数字===============================================
    public static ArrayList<Integer> FindNumbersWithSum1(int [] array, int sum) {
        // 1-合法性检查：数组为空、数组长度小于2
        // 2-设置两个指针
        // 3-输出找到的第一对
        ArrayList<Integer> res=new ArrayList<>(2);
        if (array==null||array.length<2)
            return res;

        int len=array.length;
        int low=0;
        int high=len-1;
        while(low<high){
            int temp=array[low]+array[high];
            if (temp==sum){
                res.add(array[low]);
                res.add(array[high]);
                break;
            }
            else if (temp<sum){
                low++;
            }else{
                high--;
            }
        }
        return res;
    }

    // 乘积最小的情况
    public static ArrayList<Integer> FindNumbersWithSum2(int [] array, int sum) {
        // 1-合法性检查：数组为空、数组长度小于2
        // 2-设置两个指针
        // 3-将找到的两个数存储到list中，计算他们的乘积
        // 4-继续遍历，如果找到乘积更小的，则替换>>>>>>>>>>其实没必要这么麻烦。因为两个数相差越大，则他们的乘积越小
        ArrayList<Integer> res=new ArrayList<>(2);
        if (array==null||array.length<2)
            return res;
        int len=array.length;
        int low=0;
        int high=len-1;
        int [] tempArr=new int[2];
        int multi=Integer.MAX_VALUE;
        while(low<high){
            int temp=array[low]+array[high];
            if (temp==sum){
                if (array[low]*array[high]<multi){
                    if (res.isEmpty()){
                        res.add(array[low]);
                        res.add(array[high]);
                    }else{
                        res.set(0,array[low]);
                        res.set(1,array[high]);
                    }
                    multi=array[low]*array[high];
                    low++;
                    high--;
                }
            }
            else if (temp<sum){
                low++;
            }else{
                high--;
            }
        }
        return res;
    }


    // 57.2 和为S的连续正数序列===========================
    // 检查输入合法性
    // 2-
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if (sum<=0)
            return res;
        int low=1;
        int high=2;
        while(low<(sum+1)>>1){
            int sum1=sumOfSeriese(low,high);
//            int sum1=(low+high)*(high-low+1)>>1;   //这个地方可以用求和公式：(a0+an)*n/2,但不见得快多少
            if (sum1==sum){
                ArrayList<Integer> temp =new ArrayList<>();
                for (int i=low;i<=high;++i){
                    temp.add(i);
                }
                res.add(temp);
                high++;
            }else if (sum1>sum){
                low++;
            }else{
                high++;
            }

        }
        return res;
    }

    // 写成辅助方法的形式，省时间耶
    private int sumOfSeriese(int low, int high) {
        int sum=0;
        for (int i=low;i<=high;++i){
            sum+=i;
        }
        return sum;
    }
}