package topic_learning.a_javabasis.annotation;

import java.lang.reflect.Field;

/**
 * @ClassName : TestMain
 * @Description : TODO
 * @Date : 2019/9/2 21:50
 */
public class TestMain {
    public static void main(String[] args) throws NoSuchFieldException {
        Apple apple1=new Apple();
        Class aClass= Apple.class;
        Field field = aClass.getDeclaredField("name");
        FruitName[] namee=field.getAnnotationsByType(FruitName.class);
        System.out.println(namee[0].value());
    }
}
