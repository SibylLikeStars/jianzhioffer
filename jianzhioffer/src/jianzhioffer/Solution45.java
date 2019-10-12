package jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @ClassName : Solution45
 * @Description : 把数组排成最小的数
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * 思路：定义一个比较大小的规则
 * @Date : 2019/9/19 20:20
 */
public class Solution45 {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<String> list=new ArrayList<>();
        if (numbers==null|| numbers.length==0)
            return "";
        for (int x:numbers)
            list.add(String.valueOf(x));
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1=o1+o2;
                String s2=o2+o1;
                return s1.compareTo(s2);
            }
        });
        return list.stream().collect(Collectors.joining());
    }
}
