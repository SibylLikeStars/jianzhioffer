package jianzhioffer;

/**
 * @ClassName : Solution58
 * @Description : 翻转字符串
 * @Date : 2019/4/3 10:05
 */
public class Solution58 {
        public static void main(String [] args){
        System.out.println(ReverseSentence2("abc efgh"));
//        System.out.println(reverseCore(2,3,new char[]{'a','b','c','d'}));
            System.out.println(ReverseLeft("abcdefg",2));
    }

    // 左旋转字符串
    public static String ReverseLeft(String str,int k) {
        if (str==null)
            return null;
        int len=str.length();
        if (k>=len)
            return str;
        String str1=str.substring(0,k);
        String str2=str.substring(k,len);
        return str2+str1;

    }


    // 58.2 复杂情况：I am a hard-working student.》》.student working-hard a am I
    // java的做法，对各种情况进行列举
    public String ReverseSentence3(String str) {
        if (str==null)
            return null;
        String[] reverse = str.split(" ");
        StringBuilder builder=new StringBuilder();
        for (int i = reverse.length - 1; i >= 0; i--) {
            if ( reverse[i].contains(".")){
                int len=reverse[i].length();
                StringBuilder strBuilder = new StringBuilder(".");
                strBuilder.append(reverse[i]);
                strBuilder.deleteCharAt(len);
                reverse[i]=strBuilder.toString();
            }
            if ((reverse[i].contains("-"))&&(!reverse[i].contains("'"))){
                String[] split3 = reverse[i].split("-");
                StringBuilder strBuilder =new StringBuilder();
                for (int j=split3.length-1;j>=0;j--){
                    strBuilder.append(split3[j]);
                    if (j>0){
                        strBuilder.append("-");
                    }
                }
                reverse[i]=strBuilder.toString();
            }
            builder.append(reverse[i]);
        }
        return builder.toString();
    }




    // 58.1 剑指offer中的简单情况：I am a student.》》student. a am I
    // 做法1：字符串》字符串数组》从后往前遍历》输出
    // 注意：全空格的情况
    public String ReverseSentence(String str) {
     if (str==null)
         return null;
     if(str.trim().equals("")){  //全为空格的情况
            return str;
     }
     String [] reverse=str.split(" "); // 注意多个空格的情况的处理
     StringBuilder builder=new StringBuilder();
     for (int i=reverse.length-1;i>=0;i--){
         builder.append(reverse[i]);
         if (i > 0) {
             builder.append(" ");
         }
     }
     return builder.toString();
    }

   // 做法2：先旋转所有的字符，再旋转单词部分，也通过了牛客网的测试，时间缩短了

    // 模仿C语言的做法，将整个句子当成一个字符数组，优点是可以不用考虑空格的影响，缺点是代码比较长，数组下标容易算错。
    // 代码上还可以进一步简化
    public static String ReverseSentence2(String str) {
        if (str==null)
            return null;
        int len=str.length();
        int begin=0;
        int end=len-1;
        // 翻转整个句子中的字符
        char[] reverseCharArr=reverseCore(begin,end,str.toCharArray());

        // 以空格或数组末尾为标识，将每个单词提取出来，作翻转
        begin=0;
        end=0;
        while (begin<=len-1){
            if (reverseCharArr[begin]==' '){
                begin++;
                end++;
            }else if (reverseCharArr[end]==' '){  //遇到空格，但没有到句末
                char[] revWord=reverseCore(begin,end-1,reverseCharArr);
                for (int i=0;i<=revWord.length-1;i++){
                    reverseCharArr[begin+i]=revWord[i];
                }
                begin=++end;
            }else if(end==len-1){  //到达句末
                char[] revWord=reverseCore(begin,end,reverseCharArr);  // 这个地方和C语言不一样，所以不能和上一种情况写在一起
                for (int i=0;i<=revWord.length-1;i++){
                    reverseCharArr[begin+i]=revWord[i];
                }
                begin=++end;
            } else{
                end++;
            }
        }
        return String.copyValueOf(reverseCharArr);
    }
    // 翻转字符数组方法：起始下标、结束下标、待翻转字符数组
    private static char[] reverseCore(int begin, int end, char[] str2char) {
        if (begin==end)
            return "".toCharArray();
        char[] reverseChar =new char[end-begin+1];
        for (int i=begin;i<=end;i++){
            reverseChar[end-i]=str2char[i];
        }
        return reverseChar;
    }



}
