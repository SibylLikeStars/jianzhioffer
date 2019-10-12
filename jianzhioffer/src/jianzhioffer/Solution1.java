package jianzhioffer;

/**
 * 一、赋值运算符重载
 * 说明：赋值运算符重载，java中不能重载运算符，所以只能写个函数来完成这个功能了
 *
 * 思路：
 * （1）判断==，同则返回；
 * （2）给成员变量赋值，返回【this】
 */
class MyString{
    private String data;
    public MyString(String data){this.data=data;}
    public MyString assign(MyString another){
        if (this==another){
            return this;
        }else{
            this.data=another.data;
            return this;
        }
    }
}
public class Solution1 {
    public static void main(String[] args){

    }
}
