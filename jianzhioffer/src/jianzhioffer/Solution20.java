package jianzhioffer;

/**
 * @ClassName : S20_NumericStringMy
 * @Description : 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * 注意：本题没有考虑其他字符的出现!!!!!!
 * 数字的格式可以表示为A[.[B]][E|e]C], .B[[E|e]C]
 * @Date : 2019/4/25 15:09
 */
public class Solution20 {

    // 方法2：老实来判断
    private int index=0;  //这个相当于线索，不断后移，所以可以做到扫描某一段
    public  boolean isNumeric2(char[] str) {
        boolean flag=scanInteger(str);   //扫描整数部分，
        if (index<str.length&&str[index]=='.'){  //如果遇到小数点，index++，继续扫描是否有小数部分
            index++;
            flag=scanUnsignedInteger(str)||flag;  //小数点之前可以没有整数，flag原本就是false也没事。
        }
        if(index<str.length&& (str[index]=='e'||str[index]=='E')){  //遇到e/E,index++
            index++;
            flag=flag&&scanInteger(str);//要求必须之后必须存在整数
        }
        return flag&&index==str.length;

    }
    // 扫描是否有有符号整数
    private boolean scanInteger(char[] str){
        if (index<str.length &&( str[index]=='+'|| str[index]=='-'))  //如果当前扫到符号，index++
            index++;
        return scanUnsignedInteger(str);
    }
    // 扫描是否有无符号整数
    private boolean scanUnsignedInteger(char[] str){
        int start=index;
        while(index<str.length&&str[index]>='0'&& str[index]<='9')  //扫描到数字，继续扫描直到不是数字
            index++;
        return start<index; //有数字，此时的index是非数字
    }



    // 方法1：正则表达式
    public static  boolean isNumeric(char[] str) {
        if (str==null||str.length==0)
            return false;
        String string=String.valueOf(str);
        String regex="[+-]?\\d*(\\.\\d+)?([eE][-+]?\\d+)?";
        return string.matches(regex);
    }

    // 方法3：按剑指offer上改写，但是没有通过牛客网测试
//    private int index=0;
//    public  boolean isNumeric(char[] str) {
//        if (str==null)
//            return false;
//        boolean numeric=scanInteger(str);
//
//        if (index<str.length&&str[index]=='.'){
//            index++;
//            numeric=scanUnsignedInteger(str)||numeric;//??不是
//        }
//        if (index<str.length&&(str[index]=='e'||str[index]=='E')){
//            index++;
//            numeric=numeric&&scanInteger(str);//??不是
//        }
//        return numeric&&index==str.length;
//
//    }
//    // 扫描有符号整数
//    public  boolean scanInteger(char[] str){
//        if (str[0]=='+'|| str[0]=='-') {
//            char[] unsignStr = new char[str.length - 1];
//            for (int i=0;i<unsignStr.length;i++)
//                unsignStr[i]=str[i+1];
//            return scanUnsignedInteger(unsignStr);
//        }else{
//            return scanUnsignedInteger(str);
//        }
//    }
//    // 扫描无符号整数
//    public  boolean scanUnsignedInteger(char[] str){
//        boolean flag=true;  //假设这是一个数
//        int i=0;
//        while(flag&&(i<str.length)){
//            if (str[i]>='0'&&str[i]<='9') {
//                i++;
//            }else{
//                flag=false;
//            }
//        }
//        return flag;
//    }
//    public static void main(String [] args){
//        char[] str=new char[]{'-','5','.','2','E','+','3'};
//        char[] str2=new char[]{'-','5','.','A','E','+','3'};
//        char[] str3=new char[]{'-','5','3'};
//        System.out.println((str3));
//    }
    public static void main(String[] args){
        char[] ch=new char[]{'1','0','0'};
        System.out.println(isNumeric(ch));
    }
}
