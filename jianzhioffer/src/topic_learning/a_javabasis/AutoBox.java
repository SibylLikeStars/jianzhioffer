package topic_learning.a_javabasis;

/**
 * 自动装箱拆箱
 */
public class AutoBox {
    public static void main(String [] args){
        //Integer：-128~127，可以直接用==判断值，因为缓存机制。超过这个范围只能用equals判断
        Integer a=11;
        Integer b=11;
        System.out.println(a==b);//T

        Integer c=222;
        Integer d=222;
        System.out.println(c==d);//F

        Integer aa=new Integer(11);
        Integer bb=new Integer(11);
        System.out.println(aa==bb);//F，两个对象的地址不同
        System.out.println(a==aa);//F

        System.out.println(aa.equals(bb)); //T,比较的是值

        int cc=222;
        int dd=222;
        System.out.println(cc==dd);//T

        Integer e=100;
        Integer f=200;
        Integer g=300;
        System.out.println(g==(e+f)); // true
    }
}
