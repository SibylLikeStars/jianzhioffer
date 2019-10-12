package topic_learning.a_javabasis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TryListSourceCode {
    public static void main(String[] args){
        //用final修饰集合类，表达的含义是list指向不改变，向其中put或add相当于往里面增加值，指向没有受影响。
        // 如果让list指向其他的集合，就会报错
        final List<String> list=new ArrayList<>(3);
        list.add("a");
        list.add("b");
        list.add("c");
//        list.addAll(Arrays.asList("e",null));
//        list.forEach(System.out::println);
//        list=Arrays.asList("1","2");  //报错：无法为final变量赋值。final修饰的集合类，指向不能改变
//        System.out.println(list.contains(null));
//        System.out.println(list.containsAll(Arrays.asList("c","a")));//是否包含集合中的所有元素，不是按顺序的
//        System.out.println(list.removeAll(Arrays.asList("aa","bb","ee")));  //传入的集合和原list至少要有一个相同的，只要结果中没有一样的，就可以
//        list.forEach(System.out::println);

        List<String> list2=new ArrayList<>();
        list2.add("aa");
        list2.add("bb");
        list2.add("b_Strategy");
        list2.add("dd");
//        System.out.println(list2.removeIf(v->v.length()<2));  //removeIf接收的这个接口是一个函数式接口！！
//        // 根据collection的默认实现，如果没有一个元素被删除，则没有进入到循环体，返回false
//        list2.forEach(System.out::println);
//        Map<String,Integer> map=list.stream().collect(Collectors.toMap(v->v, String::length));
//        map.forEach((k,v)->System.out.println(k+":"+v));

        System.out.println(list2.retainAll(Arrays.asList("aa","bb","b_Strategy","ff")));  //true
        list2.forEach(System.out::println);
    }
}
