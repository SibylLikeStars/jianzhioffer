package topic_learning.a_javabasis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName : MatchPattern
 * @Description : 正则表达式
 * 参考：https://www.cnblogs.com/lzq198754/p/5780340.html
 * @Date : 2019/4/24 15:47
 */
public class MatchPattern {
    public static void main(String [] args){
        //0、str.matches(pattern);
        System.out.println( "1".matches("\\d"));    //true，单个数字
        System.out.println( "123".matches("\\d*")); //true，多个数字
        System.out.println("abcdefg".matches("abcdefg"));     //true，全文匹配
        System.out.println("abcdefg".matches("^abc.*"));      //true，以abc为开头，后面可以为空
        System.out.println("abcdefg".matches("^abc[a-z]*"));  //以abc开头，以字母结束
        System.out.println("abcdefg".matches(".*abc$"));      //true，以abc结束

//        //1、匹配验证-验证Email是否正确
        String str = "service@xsoftlab.net";  // 要验证的字符串
        String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";  //邮箱验证规则，不适用QQ
        Pattern pattern = Pattern.compile(regEx);  // 编译正则表达式
        Matcher matcher = pattern.matcher(str);
        boolean rs = matcher.matches();   // 是否匹配
        boolean find = matcher.find();    // 是否含有
//
//        //1、匹配验证-输入是否为数字
        // 其实有很多种写法啦
        String str2="+123.34e-2";
        String regEx2="[+-]?\\d*(\\.\\d+)?([eE][-+]?\\d+)?";
        Pattern p2=Pattern.compile(regEx2);
        Boolean isNum=p2.matcher("-123.34e-5").matches();
        System.out.println(isNum);


        // 常用的一些匹配
        // "^[\u0391-\uFFE5]+$ ": 一个或多个汉字
        // "^[1-9]\d{5}$" :邮政编码
        // "^[1-9]\d{4,10}$ ":QQ号码
        // "^[a-zA-Z_0-9]{1,}@(([a-zA-z0-9]-*){1,}\.){1,3}[a-zA-z\-]{1,}$ " : 邮箱
        // "^[A-Za-z][A-Za-z1-9_-]+$" : 用户名（字母开头 + 数字/字母/下划线）
        // "^1[3|4|5|8][0-9]\d{8}$ " ：手机号
        // "^((http|https)://)?([\w-]+\.)+[\w-]+(/[\w-./?%&=]*)?$ "：url
        // "^(\d{6})(18|19|20)?(\d{2})([01]\d)([0123]\d)(\d{3})(\d|X|x)?$" ： 身份证号

        // 2、验证后提取
        // 提取纯数字:
        // 方式1：把非数字部分提取出来，然后删除replaceAll
        String string1="Amy:12345567";
        Pattern pattern2=Pattern.compile("[^0-9]");  //匹配非数字部分
        Matcher matcher2=pattern2.matcher(string1);
        String all1 = matcher2.replaceAll(""); //把匹配的部分全部删除
        System.out.println("phone:" + all1);

        // 方式2：匹配数字部分，然后输出匹配成功的部分group
        String string="Amy:12345567.23";
        Pattern pattern1=Pattern.compile("\\d+\\.\\d*");  //提取纯数字部分
        Matcher matcher1=pattern1.matcher(string);
        matcher1.find();  // 这一步一定要有
        String result=matcher1.group();  //！！！！！！
        System.out.println(result);  //提取匹配到的结果

        //方法3：字符串.replaceAll()
        String string2="Amy:12345567";
        System.out.println(string2.replaceAll("\\D",""));

    }
}

