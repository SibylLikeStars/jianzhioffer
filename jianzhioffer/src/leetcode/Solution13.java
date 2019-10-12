package leetcode;

import java.util.HashMap;

/**
 * 罗马数字转整数
 */
public class Solution13 {
    public static void main(String[] args) {
        Solution13 s=new Solution13();
        System.out.println();
    }
    public int romanToInt(String s) {
        if (s==null || s.length()==0){
            return 0;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int index=s.length()-1;
        int ans=0;
        while (index>=0){
            if (index-1>=0 && map.get(s.charAt(index))>map.get(s.charAt(index-1))){
                ans+=(map.get(s.charAt(index))-map.get(s.charAt(index-1)));
                index-=2;
            }else{
                ans+=map.get(s.charAt(index));
                index--;
            }
        }
        return ans;
    }
}
