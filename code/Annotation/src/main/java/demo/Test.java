package demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * https://juejin.im/post/6844903636733001741
 * https://www.jianshu.com/p/28edf5352b63
 * http://www.akathink.com/2016/08/11/%E5%BD%BB%E5%BA%95%E6%90%9E%E6%87%82Java%E6%B3%A8%E8%A7%A3Annotation/
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
