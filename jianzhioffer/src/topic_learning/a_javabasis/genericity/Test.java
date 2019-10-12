package topic_learning.a_javabasis.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型的测试类
 */
public class Test {
    public static void main(String[] args){

        //类型擦除
        List<Integer> list1=new ArrayList<>();
        List<String> list2=new ArrayList<>();
        Class c1=list1.getClass();
        Class c2=list2.getClass();
        System.out.println(c1); //class java.util.ArrayList
        System.out.println(c1==c2); //true

        Holder<String> holder=new Holder<>("小丽");
        System.out.println(holder.getT());

        holder.printInfo("yoyoyo");
        System.out.println(holder.getHashCode(34));

        Holder<Integer> holder1=new Holder<>(23);
        System.out.println(holder1.getT());

        Holder<Boolean> holder2=new Holder<>(true);
        System.out.println(holder2.getT());

        Holder<?> holder3=holder;  //可以接收一个已经实例化好的对象，但是却无法赋值
//        holder3.setT(34);//报错，接收不了这个类型
//        holder3.setT(null); //这个倒是可以
        System.out.println(holder3.getT());
    }

}
