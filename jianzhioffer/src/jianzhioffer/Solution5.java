package jianzhioffer;

/**
 * 替换字符串中的空格
 *  思路：遍历字符串，遇到空格，则替换为%20
 */
public class Solution5 {
    public static  String replaceSpace(StringBuffer str) {
        if (str==null){
            return null;
        }
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<str.length();i++){
            if (String.valueOf(str.charAt(i)).equals(" ")){
                builder.append("%20");
            }else{
                builder.append(str.charAt(i));
            }
        }
        return  builder.toString();
    }
}
