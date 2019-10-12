package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution56
 * @Description : 数组中数字出现的次数
 * @Date : 2019/4/2 15:11
 */
public class Solution56 {

    // 方法1：剑指offer上的做法，有一点难：思路难，位运算的编程
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        //1-输入合法性检查
        //2-通过异或，找到分数组依据
        //3-将数组分成两部分，每部分包括1个只出现一次的数字，其余都是成对出现的（两个数组的长度可能不一致
        //4-用异或求出每个数组中只出现1次的那个数
        if (array==null||array.length<2)
            return;
        int resultOR=0;
        for (int i:array){
            resultOR^=i;
        }
        int indexOf1=findFirstBitIs1(resultOR);  //找到从右到左，第一个1所在的索引
        int n1=0;
        int n2=0;
        for (int i:array){
            if (IsBit1(i,indexOf1))
                n1^=i;
            else
                n2^=i;
        }
        num1[0]=n1;
        num2[0]=n2;
    }

    private boolean IsBit1(int i, int indexOf1) {
        i=i>>indexOf1;
        return (i&1)==1;
    }

    private int findFirstBitIs1(int resultOR) {
        int index=0;
        while((resultOR&1)==0&&(index<32)){
            resultOR=resultOR>>1;
            ++index;
        }
        return index;
    }

    // 方法2：牛客网上的java风格的做法，但是空间复杂度不是O(1)，贸然地remove是有风险的
// 啊啊 啊啊啊啊！！！！！！！！！！！数组长度固定的情况下，空间复杂度是O(1)
    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(!list.contains(String.valueOf(array[i]))){
                list.add(String.valueOf(array[i]));
            }else{
                list.remove(String.valueOf(array[i]));
            }
        }
        if(list.size()!=0){
            num1[0] = Integer.valueOf(list.get(0));
            num2[0] = Integer.valueOf(list.get(1));
        }
    }

}
