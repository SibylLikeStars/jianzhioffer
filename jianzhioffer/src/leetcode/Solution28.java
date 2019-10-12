package leetcode;

/**
 * 字符串在另一个字符串中第一次出现位置的下标
 */
public class Solution28 {
    //简单粗暴法，通过了
    public int strStr2(String haystack, String needle){
        if (haystack==null && needle==null)
            return 0;
        if (haystack.length()==0 && needle.length()==0)
            return 0;
        if (haystack==null || haystack.length()==0 )
            return -1;
        if ( needle==null || needle.length()==0)
            return 0;
        for(int i = 0;i<haystack.length()&&i+needle.length()<=haystack.length();i++)
        {
            if(needle.equals(haystack.substring(i, i+needle.length())))
                return i;
        }
        return -1;
    }
}
