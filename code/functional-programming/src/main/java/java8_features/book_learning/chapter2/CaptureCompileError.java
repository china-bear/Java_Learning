package java8_features.book_learning.chapter2;

import javax.swing.*;

/**
 * 例 2-5 匿名内部类中使用 final 局部变量
 */
public class CaptureCompileError {

    private JButton button;

    public void error() {
        String name = getUserName();    // 不加 final 则编译不通过
        name = formatUserName(name);
        // Uncommenting this line should cause a compile error:
//         button.addActionListener(event -> System.out.println("hi " + name));
    }

    private String formatUserName(String name) {
        return name.toLowerCase();
    }

    private String getUserName() {
        return "RICHARD";
    }
}
