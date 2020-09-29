package Annotations;

/**
 * 自定义注解：故事书籍信息注解
 * Created by bear on 2020/9/8
 */
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface BookAnnotation {

    // 书名
    String bookName();
    // 女主人公
    String heroine();
    // 书的简介
    String briefOfBook();
    // 书的销量
    int sales() default 10000;
}
