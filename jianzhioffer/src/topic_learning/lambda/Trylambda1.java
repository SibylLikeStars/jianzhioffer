package topic_learning.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 1、lambda表达式：针对对象列表，一些关于属性的操作
 * lambda表达式，可以看成三部分组成：源、中间操作、终结操作
 * （1）源：就是将列表、数组等等系列数据转换成“流”
 *      list.stream().
 *      map.
 *      数组：Arrays.asStream().
 *      直接生成：Stream.of().
 * （2）中间操作：例如filter过滤、映射maptoint、取部分值limit、自定义操作……
 * （3）终结操作：foreach、collect中有大量终结操作
 *
 */
public class Trylambda1 {
    public static void main(String [] args){
        List<Student> stuList= Arrays.asList(new Student(1,12,"AA"),new Student(2,12,"BB"),
                new Student(3,13,"CC"),new Student(4,14,"DD"),new Student(5,12,"EE"));

        //filter(条件)：中间操作，获得所有年龄12岁的学生ID的集合
        List<Student> IDsOf12=stuList.stream().filter(x->x.getAge()==12).collect(Collectors.toList());

        //统计12岁学生的人数
        int num12=(int)stuList.stream().filter(x->x.getAge()==12).count();

        //groupBy：将所有学生按年龄分组
        Map<Integer,List<Student>> ageMap=stuList.stream().collect(Collectors.groupingBy(Student::getAge));

        //Collectors.toMap：将所有学生按ID分组2
        Map<Integer,Student> IDstu=stuList.stream().collect(Collectors.toMap(Student::getID,student -> student));

        //提取其中的ID和name属性，输出成map，写成v->v.getID()也可以，编译器会提示可以优化
        Map<Integer,String> IDandName=stuList.stream().collect(Collectors.toMap(Student::getID, Student::getName));
        IDandName.forEach((k,v)->System.out.println(k+":"+v));

        //foreach遍历
        stuList.forEach(student -> System.out.println(student.toString()));
        IDstu.forEach((age,student)->System.out.println(age+student.toString()));

        //comparing集合排序：按年龄排序
        List<Student> sortedByAge=stuList.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());

        //统计城市名的出现次数
        List<String> cities=Arrays.asList("上海","南京","杭州","福州","上海","杭州");
        Map<String,Long> cityNum=cities.stream().collect(Collectors.groupingBy(city->city,Collectors.counting()));
        cityNum.forEach((city,num)->System.out.println(city+"："+num));
    }
}
