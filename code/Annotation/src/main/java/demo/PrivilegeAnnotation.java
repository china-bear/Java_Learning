package demo;

import java.lang.annotation.*;

/**
 * 测试注解,能作用于类上面和成员变量上面，在运行期间生效
 * Created by bear on 2020/9/7
 */

/* 目标注解: 定了注解作用的目标范围，包括类、方法等等
@Target取值参数说明
ElementType.PACKAGE：可以给一个包进行注解
ElementType.ANNOTATION_TYPE：可以给一个注解进行注解
ElementType.TYPE：可以给一个类型进行注解，如类、接口、枚举
ElementType.CONSTRUCTOR：可以给构造方法进行注解
ElementType.METHOD：可以给方法进行注解
ElementType.PARAMETER 可以给一个方法内的参数进行注解
ElementType.FIELD：可以给属性进行注解
ElementType.LOCAL_VARIABLE：可以给局部变量进行注解*/
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD,ElementType.PARAMETER})

/* 保留注解: 说明注解的生命周期
@Retention参数说明
RetentionPolicy.RUNTIME：注解保留到程序运行时 & 会被加载进入到 JVM 中，所以在程序运行时可以获取到它们
RetentionPolicy.CLASS：注解只被保留到编译进行时 & 不会被加载到 JVM
RetentionPolicy.SOURCE：注解只在源码阶段保留 & 在编译器进行编译时将被丢弃忽视。*/
@Retention(RetentionPolicy.RUNTIME)

// 文档注解：将注解中的元素包含到 Javadoc文档中
@Documented
//继承注解： 被@Inherited注解的注解 作用的类的子类可以继承该类的注解
@Inherited

// 可重复注解：@Repeatable 作用的注解可以取多个值 Java 1.8后引进
public @interface PrivilegeAnnotation {
    // 注解@MyAnnotation有3个属性  ：role 、desc、privileges
    // 特别说明：若注解只有一个属性，则赋值时属性名称可以省略
    // 注解的属性以 “无形参的方法” 形式来声明
    // 方法名 = 属性名
    String  role() default "admin";
    Weather desc() default Weather.Sunny;
    String[] privileges() default "1,2,3";
}

enum Weather{
    Sunny,Rainy
}