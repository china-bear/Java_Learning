package Annotations;

/**
 * Created by bear on 2020/9/8
 */
public class AnnotationTest2 {

    public static void main(String[] args) throws ClassNotFoundException {

        //解析域的注解
        System.out.println("下面是解析域的注解信息：\n");
        ParseLoveStoryBookAnnotation.parseTypeAnnotation();
        //解析方法的注解
        System.out.println("下面是解析方法的注解信息：\n");
        ParseLoveStoryBookAnnotation.parseMethodAnnotation();
        //解析类的注解
        System.out.println("下面是解析类的注解信息: \n");
        ParseLoveStoryBookAnnotation.parseTypeAnnotation();
    }
}
