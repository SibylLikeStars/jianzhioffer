package topic_learning.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 2、lambda表达式：针对数组和列表等，进行一些数学操作
 */
public class TryLambda2 {
    public static void main(String [] args){
        //1、对每个元素统一进行一个操作
           //1.1 每个字符，统一格式输出
        List<String> list= Arrays.asList("a","bb","ccc","dd","e","a","bb");
        String name="letter: ";
        list.forEach(x->System.out.println(name+x));

           //1.2 每个数字，加上1
        Stream.of(1,2,3).map(v->v+1).forEach(System.out::println);

        //2、在filter中写自定义方法
        list.stream().filter(TryLambda2::notEqual).forEach(System.out::println);

        //3、通过Stream.of()直接生成流
        Stream.of("a","b","c").map(v->v+"-map").forEach(System.out::println);

        //4、扩充流，将"a","b","c"变成："a","1","2","b","1","2","c","1","2"。。skip(n)可以跳过前面n个元素
        Stream.of("a","b","c").flatMap(v->Stream.of(v,1,2)).skip(0).forEach(x->System.out.print("\""+x+"\""+","));

    }
    private static boolean notEqual(String s){
        return !"ccc".equals(s);
    }

}
