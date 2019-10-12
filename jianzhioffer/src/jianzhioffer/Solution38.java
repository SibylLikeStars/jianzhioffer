package jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : Solution38
 * @Description :
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 也是深度遍历+回溯的变形
 * 思路：固定第一个字符，求剩余字符的排列，剩余字符的话，也是先固定第一个……迭代
 * @Date : 2019/9/19 19:18
 */
public class Solution38 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res=new ArrayList<>();
        if (str==null || str.length()==0)
            return res;
        permutationHelper(str.toCharArray(),0,res);
        Collections.sort(res);
        return res;
    }

    private void permutationHelper(char[] chars,int index,ArrayList<String> list) {
        if (index==chars.length-1) {
            list.add(String.valueOf(chars));
        }else{
            Set<Character> charSet=new HashSet<>();
            for (int i=index;i<chars.length;i++){
                if (i==index || !charSet.contains(chars[i])){
                    charSet.add(chars[i]);
                    swap(chars,i,index);
                    permutationHelper(chars,index+1,list);
                    swap(chars,index,i);
                }
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char c=chars[i];
        chars[i]=chars[j];
        chars[j]=c;
    }
}
