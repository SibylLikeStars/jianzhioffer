package basic_algorithm.basicTools;

import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 常用的list和map操作
 */
public class TryListAndMap {
    public static void main(String[] args){

        //list初始化
        List<Integer> list= Arrays.asList(2,3,4,5,2,3,1,3);

        //遍历：3种方式
        for (int i=0;i<list.size();i++){
            //do something
        }
        for (Integer i:list){
            //do something
        }
        list.forEach(System.out::println);

        //排序
        Collections.sort(list);//默认是从小到大排序

        Comparator<Integer> cmp1=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        list.sort(cmp1); //从大到小排序，也可以写成Collections.sort(list, cmp1)


        //（2）统计出现次数
        Map<Object, Long> arrMap=list.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
        arrMap.forEach((k,v)->System.out.println(k+":"+v));

        //map初始化
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,2);
        map.put(2,4);
        map.put(3,3);
        map.put(5,2);


        //遍历
        //1、取得keyset，按set的方式遍历，结合get()来操作
        Set<Integer> keyset=map.keySet();
        //2、取得valueList，按list的方式遍历
        Collection<Integer> valueList=map.values();

        //3、取得entrySet，按set的方式遍历，结合entry.getKey() 和 entry.getValue()来操作
        Set<Map.Entry<Integer, Integer>> entrySet=map.entrySet();
        for (Map.Entry<Integer, Integer> entry:entrySet){
            Integer k=entry.getKey();
            Integer v=entry.getValue();
        }

        //4、foreach
        map.forEach((k,v)->System.out.println(k+": "+v));

        //按value排序
        ArrayList<Map.Entry<Integer,Integer>> entrylist= new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(entrylist, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());  //按升序
            }
        });

    }
}
