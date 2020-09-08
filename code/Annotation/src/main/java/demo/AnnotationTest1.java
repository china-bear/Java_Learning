package demo;


/**
 * Created by bear on 2020/9/7
 */

@PrivilegeAnnotation(role = "admin", desc = Weather.Sunny, privileges = {"D", "S"})
public class AnnotationTest1 {

    @PrivilegeAnnotation(role = "admin", desc = Weather.Sunny, privileges = {"D", "S"})
    public void showDescription(
            @PrivilegeAnnotation(role = "参数1") String param1,
            @PrivilegeAnnotation(desc = Weather.Rainy) String param2,
            @PrivilegeAnnotation(privileges = {"I"}) String param3
    ) {
        System.out.println("Author showDescription method invoked...");
    }

    @PrivilegeAnnotation(role = "admin", desc = Weather.Sunny, privileges = {"D", "S"})
    private String name;

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        AnnotationTest1 annotationTest1 = new AnnotationTest1();
        System.out.println(annotationTest1.getName());   // null ???
    }
}
