package demo;

/**
 * 自定义注解：作者信息注解
 * Created by bear on 2020/9/8
 */

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthorAnnotation {
    // 名字
    String name();
    // 年龄
    int age() default 19;
    // 性别
    String gender() default "男";
}
