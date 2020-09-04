package demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by bear on 2020/9/4
 */
public class Test {

    @Hello("hello")
    public static void main(String[] args) throws NoSuchMethodException {
        Class cls = Test.class;
        Method method = cls.getMethod("main", String[].class);
        Hello hello = method.getAnnotation(Hello.class);
        Annotation
    }
}
