package demo;


/**
 * Created by bear on 2020/9/7
 */

@MyAnnotation(role = "admin", desc = Weather.Sunny, privileges = {"D", "S"})
public class AnnotationTest {

    @MyAnnotation(role = "admin", desc = Weather.Sunny, privileges = {"D", "S"})
    public void showDescription(
            @MyAnnotation(role = "参数1") String param1,
            @MyAnnotation(desc = Weather.Rainy) String param2,
            @MyAnnotation(privileges = {"I"}) String param3
    ) {
        System.out.println("Author showDescription method invoked...");
    }

    @MyAnnotation(role = "admin", desc = Weather.Sunny, privileges = {"D", "S"})
    private String name;

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        AnnotationTest annotationTest = new AnnotationTest();
        System.out.println(annotationTest.getName());   // null ???
    }
}
