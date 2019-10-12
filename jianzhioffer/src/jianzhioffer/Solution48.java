package jianzhioffer;

import java.util.HashSet;

/**
 * @ClassName : S48_MaxSubString
 * @Description : 最长不含重复字符的子字符串
 * 思路：和42题很像，遍历，用set来保存出现过的不重复的字符，
 * 当前最大长度、历史最大长度，如果当前字符在之前没有出现过，就加入set，更新最大长度；如果存在，就清除set，重新设置当前最大长度
 * @Date : 2019/4/29 16:33
 */
public class Solution48 {
    public static String getMaxSubstring(String str){
        if (str==null)
            return null;
        if (str.length()==0)
            return "";
        int end=0;
        int maxLen=1;
        int curLen=1;
        HashSet<Character> set=new HashSet<>();
        set.add(str.charAt(0));
        for (int i=1;i<str.length();++i){
            char ch=str.charAt(i);
            if (!set.contains(ch)){
                curLen++;
                set.add(ch);
                if (curLen>maxLen){
                    maxLen=curLen;
                    end=i;
                }
            }else{
                set.clear();
                set.add(ch);
                curLen=1;
            }
        }
        System.out.println(maxLen);
        return str.substring(end-maxLen+1,end+1);
    }
    public static void main(String [] args){
        String res=getMaxSubstring("aaabcdeeeefg");
        System.out.print(res);
    }
}
