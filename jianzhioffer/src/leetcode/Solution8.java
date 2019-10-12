package leetcode;

/**
 * 8、字符串转换整数 (atoi)
 */
public class Solution8 {
    //方法2：用相乘
    public int myAtoi2(String str) {
        String s0=str.trim();
        if (s0.length()==0)
            return 0;
        int flag=1;
        long ans=0;
        int i=0;
        if (s0.charAt(0)=='-'){
            flag=-1;
            i++;
        }
        if (s0.charAt(0)=='+')
            i++;
        for (;i<s0.length();i++){
            char c=s0.charAt(i);
            if (c>='0' && c<='9'){
                ans=10*ans+c-'0';
                if (flag==1 && ans>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                if (flag==-1 && ans*flag<Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }else{
                break;
            }
        }
        return (int) ans*flag;
    }



    //方法1：用StringBuilder，效率低，而且容易出错
    public int myAtoi(String str) {
        String s0=str.trim();
        if (s0.length()==0)
            return 0;
        StringBuilder sb=new StringBuilder();
        if (s0.charAt(0)=='-'  ||s0.charAt(0)=='+' ){
            sb.append(s0.charAt(0));
            s0= str.substring(1,s0.length());
            if (s0.length()==0)
                return 0;
        }
        for (int i=0;i<s0.length();i++){
            if (s0.charAt(i)>='0'  && s0.charAt(i)<='9'){
                sb.append(s0.charAt(i));
            }else{
                return 0;  //这里不能这么写，错的
            }
        }
        Long num=Long.valueOf(sb.toString());
        if (num>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if (num<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else{
            return Integer.parseInt(sb.toString());
        }
    }
}
