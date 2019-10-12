package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 6、Z形变换
 */
public class Solution6 {
    public static void main(String[] args){
        String str=convert("PAYPALISHIRING",3);
        System.out.println(str);
        System.out.println("PAHNAPLSIIGYIR".equals(str));
    }
    //方法2：高赞解答，本题特色做法，牛逼了牛逼了
    public static String convert2(String s, int numRows) {
        if (s==null || s.length()==0)
            return "";
        if (numRows==1)
            return s;
        List<StringBuilder> rows=new ArrayList<>();
        for (int i=0;i<Math.min(s.length(),numRows);i++)
            rows.add(new StringBuilder());
        int curRow=0;
        boolean goingDown=false;
        for (char c:s.toCharArray()){
            rows.get(curRow).append(c);
            if (curRow==0|| curRow==numRows-1)
                goingDown=!goingDown;
            curRow+=goingDown?1:-1;
        }
        StringBuilder ans=new StringBuilder();
        for (StringBuilder sb:rows)
            ans.append(sb);
        return ans.toString();
    }


    //方法1：每行读取，根据字符分布的下标规律，获知z的每个位置将会出现什么字符
    public static String convert(String s, int numRows) {
        if (s==null || s.length()==0)
            return "";
        if (numRows==1)
            return s;
        int len=s.length();
        int groupNum=2*numRows-2;
        int groups=len/groupNum+1;
        StringBuilder ans=new StringBuilder();
        for (int i=0;i<numRows;i++){  //对行数遍历
            for (int j=0;j<groups;j++){  //根据每组的数来遍历
                int index=j*groupNum+i;
                if (index<len){
                    ans.append(s.charAt(index));
                    int index2=groupNum*(j+1)-i;
                    if (i>0 && i<numRows-1 && index2<len){
                        ans.append(s.charAt(index2));
                    }
                }

            }
        }
        return ans.toString();
    }
}
