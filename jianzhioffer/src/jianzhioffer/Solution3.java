package jianzhioffer;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 数组中重复的数字：对于长度为n，元素为int，范围在0~n-1之间的数组，求它是否有重复数字。
 * 方法1：常规做法，先排序，再找，但排序的复杂度O（nlogn）
 * 方法2**：哈希表，从投到尾扫描数组，如果哈希表中没有这个数，则加入, 时间O（n），空间O（n）
 * 方法3***：巧妙地排序，利用了0-n-1的特性，一边遍历，一边排序, 时间O（n），空间O（1）
 */
public class Solution3 {
    //方法2
    public static boolean  repeatNum2(int[] numbers, int length, int [] duplication){
        if (length<=0){
            return  false;
        }
        HashSet<Integer> set=new HashSet<>();
        for (int temp:numbers){
            if (set.isEmpty()||!set.contains(temp)){
                set.add(temp);
            }else{
                duplication[0]=temp;
                return true;
            }
        }
        return false;
    }

    // 方法3
    public static boolean  repeatNum3(int[] numbers,int length,int [] duplication){
        ArrayList<Integer> repeatList=new ArrayList<>();
        if (length<=0){
            return  false;
        }
        for (int i=0;i<length;i++){
            int m=numbers[i];
            if (m!=i){
                if (m!=numbers[m]){
                    numbers[i]=numbers[m];
                    numbers[m]=m;
                }else{
                    if (repeatList.indexOf(m)==-1){
                        repeatList.add(m);
                    }

                }
            }
        }
        if (repeatList.isEmpty()) {
            return false;
        }else{
            duplication[0]=repeatList.get(0);
            return true;
        }
    }

}
