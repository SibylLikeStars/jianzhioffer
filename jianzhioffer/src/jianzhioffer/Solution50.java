package jianzhioffer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @ClassName : S50_FirstRepeatingChar
 * @Description : 第一个只出现1次的字符
 * @Date : 2019/3/11 17:03
 */
public class Solution50 {
    public static void main(String [] args){
//        System.out.println(FirstNotRepeatingChar("ccaaabc"));
        System.out.print(FirstNotRepeatingChar2("ccaaabc"));
    }

    // 优秀大佬的做法，但是不正确
    public static  int FirstNotRepeatingChar(String str) {
        if (str==null||str.length()==0)
            return -1; //位置0有点奇怪
        ArrayList<Character> list=new ArrayList<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!list.contains(ch)){
                list.add(Character.valueOf(ch));
            }else{
                list.remove(Character.valueOf(ch));
            }
        }
        if(list.size() <=0) return -1;
        return str.indexOf(list.get(0));
    }



    // 按书上的做法写的，通过牛客网测试，52ms
    // 第一次遍历，统计各个字符出现的次数
    // 第二次遍历，获得第一个出现1次的字符所在位置
    public static int FirstNotRepeatingChar2(String str) {
        if (str==null||str.length()==0)
            return -1; //位置0有点奇怪
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i=0;i<str.length();++i){
            if (map.containsKey(str.charAt(i))) {
                int val = map.get(str.charAt(i));
                map.put(str.charAt(i),++val);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        for (int i=0;i<str.length();++i){
            if (map.get(str.charAt(i))==1)
                return i;
        }
        return -1;
    }

}
