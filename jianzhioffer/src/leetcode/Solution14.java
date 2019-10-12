package leetcode;

/**
 * 找最长公共前缀：二分、啥的啥的，还可以用二叉树。先看简单的吧
 */
public class Solution14 {
    //水平扫描法：
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
    //和我的一个做法，但是更加简洁
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)  //直接找停止条件，省去了中间的条件
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }


    //水平扫描，但将字符看成一列一列地来。
    public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0){
            return "";
        }
        StringBuilder prefix=new StringBuilder();
        int n=strs.length;
        String s1=strs[0];
        for (int i=0;i<s1.length();i++){
            char c=s1.charAt(i);
            boolean same=true;
            for (int j=0;j<n;j++){
                if (strs[j].length()<i+1 ||strs[j].charAt(i)!=c){
                    same=false;
                }
            }
            if (same){
                prefix.append(c);
            }else{
                break;
            }
        }
       return prefix.toString();
    }
    public static void main(String[] args){
        Solution14 s=new Solution14();
        String[] str={"aa","a"};
        System.out.println(s.longestCommonPrefix2(str));

    }
}
