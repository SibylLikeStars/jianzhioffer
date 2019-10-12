package leetcode;

/**
 * 7、整数反转
 */
public class Solution7 {
    public static int reverse(int x) {
        StringBuilder s=new StringBuilder(String.valueOf(x));
        boolean nagtive=s.charAt(0)=='-';
        long ans;
        if ( nagtive) {
            s = s.deleteCharAt(0);
            ans=Long.valueOf(s.reverse().insert(0,'-').toString());
        }else {
            ans = Long.valueOf(s.reverse().toString());
        }
        if (ans<(-1)<<31 || ans>((1<<31)-1)){
            return 0;
        }else {
            return (int) ans;
        }
    }
    public static void main(String[] args){
        String s=String.valueOf(-100);
        if (s.charAt(0)=='-')
            s=s.substring(1,s.length());
        StringBuilder vvv=new StringBuilder(100);
        System.out.println((1<<31)-1);
    }
}
