package classTest;

/*
https://www.zhihu.com/question/26954130 搞懂 JAVA 内部类
https://www.zhihu.com/question/26954130 java内部类有什么作用
*/
public class InnerClassTest {

    private Integer id;
    private String name;

    interface StudyJava{
        void study();
    }

    private void work(){
        // 1、局部内部类实现Java接口
        class StudyJavaImpl implements StudyJava {
            final String name = "javase";
            @Override
            public void study() {
                System.out.println("哪吒 study "+name);
            }
        }

        StudyJava studyJavaImpl = new StudyJavaImpl();
        studyJavaImpl.study();

        // 2、匿名内部类实现study方法, 不需要创建具体的实现类
        StudyJava studyJava = new StudyJava() {
            final String name = "spring";

            @Override
            public void study() {
                System.out.println("云韵 study " + name);
            }
        };

        studyJava.study();
    }

    public static void main(String[] args) {
        InnerClassTest student = new InnerClassTest();
        student.work();
    }
}
