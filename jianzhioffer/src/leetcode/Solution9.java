package leetcode;

/**
 * 9、判断整数是否回文数
 */
public class Solution9 {
    //方法3：数学。只翻转一半的数字

    //方法2：数学的方式，判断首尾是否相等

    //方法1：字符串全翻转，再比较，不准确
    public boolean isPalindrome(int x) {
        String re=new StringBuilder(String.valueOf(x)).reverse().toString();
        return String.valueOf(x).equals(re);
    }
    public static void main(String[] args) {
        Solution9 so=new Solution9();
        System.out.println(so.isPalindrome(-121));
    }
}
