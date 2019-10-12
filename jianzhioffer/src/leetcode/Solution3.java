package leetcode;

import java.util.*;

/**
 * 3、无重复字符的最长子串
 * 方法3：滑动窗口的优化，使用hashmap，存储每个字符出现的位置，然后遍历，字符串长度通过下标相减得到，重复时不删除，而是直接替换。
 *        用逻辑来代替“物理”替换
 * 方法2：滑动窗口，官方标答中的滑动窗口和我的还不一样，自我感觉我的更简洁
 * 方法1：暴力遍历，两个for循环迭代，列举出所有可能的子串，然后判断是否重复
 */
public class Solution3 {
    public static int lengthOfLongestSubstringAuth(String s) {
        int i,j,ans=0;
        Map<Character,Integer> map=new HashMap<>();
        for (i=0,j=0;j<s.length();j++){
            if (map.containsKey(s.charAt(j))){
                i=Math.max(i,map.get(s.charAt(j)));
            }
            ans=Math.max(j-i+1,ans); //
            map.put(s.charAt(j),j+1);//一开始不太理解， map.put(s.charAt(j), j + 1); 后来理解了。Map中存储的是当前字符的下一索引位置，如果出现重复字符，那么当前子串长度应该是“【当前下标 j】 - 【旧j+1】 + 1”，如果在put的时候就把 j加了1，则计算时就直接用 j - map.get(c) + 1，和不重复时的计算保持一致
        }
        return ans;
    }


    public static int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0)
            return 0;
        int maxlen=1,curLen=1;
        List<Character> list=new ArrayList<>();
        list.add(s.charAt(0));
        for (int i=1;i<s.length();i++){
            char c=s.charAt(i);
            if (!list.contains(c)){
                list.add(c);
                curLen++;
                if (curLen>maxlen){
                    maxlen=curLen;
                }
            }else{
                if (curLen>maxlen){
                    maxlen=curLen;
                }
                Iterator<Character> it=list.iterator();
                while (it.hasNext()){
                    if (it.next()==c){
                        it.remove();
                        break;
                    }else{
                        it.remove();
                    }
                }
                list.add(c);
                curLen=list.size();
            }
        }
        return maxlen;
    }
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstringAuth("dvdf"));
    }
}
