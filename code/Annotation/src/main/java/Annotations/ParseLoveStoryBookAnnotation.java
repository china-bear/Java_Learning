package Annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *  注解解析
 * http://www.akathink.com/2016/08/12/%E5%BD%BB%E5%BA%95%E6%90%9E%E6%87%82Java%E5%8F%8D%E5%B0%84Reflect/
 * Created by bear on 2020/9/8
 */
public class ParseLoveStoryBookAnnotation {

    /**
     *
     * 解析类注解
     * LoveStoryBook
     * @throws ClassNotFoundException
     */
    public static void parseTypeAnnotation() throws ClassNotFoundException{
        @SuppressWarnings("rawtypes")
        Class clazz = Class.forName("Annotations.LoveStoryBook");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            BookAnnotation bookAnnotation = (BookAnnotation) annotation;
            System.out.println("书名：" + bookAnnotation.bookName() + "\n" +
                    "女主人公：" + bookAnnotation.heroine() + "\n" +
                    "书的简介：" + bookAnnotation.briefOfBook() + "\n"+
                    "书的销量：" + bookAnnotation .sales() + "\n");
        }
    }
    /**
     * 解析方法注解
     * @throws ClassNotFoundException
     */
    public static void parseMethodAnnotation() throws ClassNotFoundException{
        Method[] methods = LoveStoryBook.class.getDeclaredMethods();
        for (Method method : methods) {
            /*
             * 判断方法中是否有指定注解类型的注解
             */
            boolean hasAnnotation = method.isAnnotationPresent(BookAnnotation.class);
            if(hasAnnotation){
                BookAnnotation bookAnnotation = (BookAnnotation) method.getAnnotation(BookAnnotation.class);
                System.out.println("书名：" + bookAnnotation.bookName() + "\n" +
                        "女主人公：" + bookAnnotation.heroine() + "\n" +
                        "书的简介：" + bookAnnotation.briefOfBook() + "\n"+
                        "书的销量：" + bookAnnotation .sales() + "\n");
            }
        }
    }
    /**
     * 解析域注解
     * @throws ClassNotFoundException
     */
    public static void parseFieldAnnotation() throws ClassNotFoundException{
        Field[] fields = LoveStoryBook.class.getDeclaredFields();
        for (Field field : fields) {
            boolean hasAnnotation = field.isAnnotationPresent(AuthorAnnotation.class);
            if(hasAnnotation){
                AuthorAnnotation authorAnnotation = field.getAnnotation(AuthorAnnotation.class);
                System.out.println("作者：" +authorAnnotation.name() + "\n" +
                        "年龄：" + authorAnnotation.age() + "\n" +
                        "性别：" + authorAnnotation.gender() + "\n");
            }
        }
    }

}
