package jianzhioffer;

/**
 * @ClassName : S44_digitIndex
 * @Description : 数字序列中某一位的数字
 * 第一步：确定这个数字属于几位数
 * 第二步：确定该数字属于哪个数
 * 第三步：确定是该数中的哪一位

 * @Date : 2019/3/9 9:58
 */
public class Solution44 {
    public static  int digitAtIndex(int index){
        if (index<0)
            return -1;
        if (index<10)
            return index;
        int curIndex=10;  //当前位数的第一个数字的索引，相当于前面的数字的个数
        int length=2;     // 几位数
        int boundNum=10;
        while(curIndex+lengthSum(length)<index){
            curIndex+=lengthSum(length);
            boundNum*=10;
            length++;
        }
        int addNum=(index-curIndex)/length;  //当前位数下的第几个数
        int curNum=boundNum+addNum;
        return Integer.toString(curNum).charAt(index-curIndex-addNum*length)-'0'; //ASCII码-'0'就是数字的值啊
    }

    private static int lengthSum(int length) {
        int count=9;
        for (int i=1;i<length;i++){
            count*=10;
        }
        return count*length;
    }
    public static void main(String[] args){
        int v=digitAtIndex(1001);
        System.out.println(v);

    }
}
