package leetcode;

/**
 * 5、最长回文串
 * （1）暴力法
 * （2）动态规划法
 * （3）中心扩展法
 */
public class Solution5 {

    //方法3：中心扩展法
    public static  String longestPalindrome3(String s) {
        int start=0,end=0;
        for (int i=0;i<s.length();i++){
            int len1=expandAroundCenter(s,i,i);
            int len2=expandAroundCenter(s,i,i+1);
            int len=Math.max(len1,len2);
            if (len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L=left,R=right;
        while (L>=0 && R<s.length() && s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }

    //方法2：动态规划法
    public static  String longestPalindrome2(String s) {
        if(s==null || s.length()==0)
            return "";
        int length=s.length();
        boolean[][] p=new boolean[length][length];
        int maxLen=0;
        String maxPal="";
        for (int len=1;len<=length;len++){
            for (int start=0;start<length-1;start++){
                int end=start+len-1;
                if (end>length-1)
                    break;
                p[start][end]=(len==1||len==2 ||p[start+1][end-1]) && s.charAt(start)==s.charAt(end);
                if (p[start][end] && len>maxLen){
                    maxLen=len;
                    maxPal=s.substring(start,end+1);
                }
            }
        }

        return maxPal;
    }

    //方法1：暴力法
    public static  String longestPalindrome(String s) {
        if(s==null || s.length()==0)
            return "";
        if (s.length()==1)
            return s;
        int maxLen=1;
        String ans=s.substring(0,1);
        for (int i=0;i<s.length();i++){
            for (int j=i+1;j<=s.length();j++){
                String str=s.substring(i,j);
                if (getRoundLen(str)){
                    if (maxLen<str.length()) {
                        maxLen = str.length();
                        ans = str;
                    }
                }
            }
        }
        return ans;
    }

    private static boolean getRoundLen(String str) {
        boolean isRound=true;
        int le=str.length();
        for (int i=0;i<le/2;i++){
            if (str.charAt(i)!=str.charAt(le-i-1)) {
                isRound = false;
                break;
            }
        }
        return isRound;
    }


    public static void main(String[] args){
        String s="bb";
        System.out.println(getRoundLen("bab"));
        System.out.println(getRoundLen("baab"));

    }
}
