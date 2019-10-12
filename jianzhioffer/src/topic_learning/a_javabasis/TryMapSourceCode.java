package topic_learning.a_javabasis;

import java.util.HashMap;
import java.util.Map;
class Mappp {
    private String name;
    public Mappp(String name){
        this.name=name;
    }
    public int hashCode(){
        return 420;
    }
}
public class TryMapSourceCode {
    public static void main(String[] args){
        Mappp a=new Mappp("tom");
        Mappp b=new Mappp("tom");
        Map<Mappp,Integer> map=new HashMap<>();
        map.put(a,8);
        System.out.println(map.get(b)); //null，map都是先匹配hashcode再匹配equals的

        //试试entry中的方法，可以用来排序：https://blog.csdn.net/wangmuming/article/details/78448263

        Map<Integer,String> myMap=new HashMap<>();
//        System.out.println(myMap.put(1,"aa"));
//        System.out.println(myMap.put(1,"aaa"));
        myMap.put(2,"bb");
        myMap.put(5,"b_Strategy");
        myMap.put(4,null);
        myMap.put(3,"ee");
        System.out.println(myMap.putIfAbsent(3,"ttttt"));
        myMap.computeIfPresent(2, (k,v)->k+v);  //如果存在就这么改value
        myMap.computeIfAbsent(4, String::valueOf);  //
//        myMap.computeIfAbsent((k,v)->{return String.valueOf(v.length();});
        myMap.forEach((k,v)->System.out.println(k+":"+v));
//        System.out.println(myMap.remove(6));  //此时返回的也是null
//        myMap.forEach((k,v)->System.out.println(k+":"+v));
//
//        Set<Integer> keys=myMap.keySet();
//        Set<Map.Entry<Integer,String>> kvs=myMap.entrySet();//Entry是Map的内部接口
//        for (Map.Entry<Integer,String> kv:kvs){
//            System.out.println(kv.getKey()+":"+kv.getValue());
//        }
//        myMap.replaceAll((k,v)-> String.valueOf(v.length()));  //也是一个函数式接口，但是有return
//        myMap.forEach((k,v)->System.out.println(k+":"+v));
    }

}
