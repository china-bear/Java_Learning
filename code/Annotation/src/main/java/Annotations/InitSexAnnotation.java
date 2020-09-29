package Annotations;

import java.lang.annotation.*;

/**
 * 性别赋值
 * Created by bear on 2020/9/7
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Inherited
public @interface InitSexAnnotation {

    enum SEX_TYPE {MAN, WOMAN}
    SEX_TYPE sex() default SEX_TYPE.MAN;
}
