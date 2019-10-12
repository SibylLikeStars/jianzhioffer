package topic_learning.a_javabasis.annotation;

import java.lang.annotation.*;

/**
 * @ClassName : FruitName
 * @Description : TODO
 * @Date : 2019/9/2 21:35
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "xixixi";
}