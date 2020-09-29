package Annotations;

import java.lang.reflect.*;

/**
 *  https://zhuanlan.zhihu.com/p/60730622
 * Created by bear on 2020/9/7
 */
public class ParseUserAnnotation {

    public static void main(String[] args) throws IllegalAccessException {
        User user = new User();
        initUser(user);
        // 年龄为0，校验为通过情况
        boolean checkResult = checkUser(user);
        printResult(checkResult);
        // 重新设置年龄，校验通过情况
        user.setAge(22);
        checkResult = checkUser(user);
        printResult(checkResult);
    }

    static void initUser(User user) throws IllegalAccessException {
        // 获取User类中所有的属性(getFields无法获得private属性)
        Field[] fields = User.class.getDeclaredFields();
        // 遍历所有属性
        for (Field field : fields) {
            // 如果属性上有此注解，则进行赋值操作
            if (field.isAnnotationPresent(InitSexAnnotation.class)) {
                InitSexAnnotation init = field.getAnnotation(InitSexAnnotation.class);
                field.setAccessible(true);
                // 设置属性的性别值
                field.set(user, init.sex().toString());
                System.out.println("完成属性值的修改，修改值为:" + init.sex().toString());
            }
        }
    }
    static boolean checkUser(User user) throws IllegalAccessException {
        // 获取User类中所有的属性(getFields无法获得private属性)
        Field[] fields = User.class.getDeclaredFields();
        boolean result = true;
        // 遍历所有属性
        for (Field field : fields) {
            // 如果属性上有此注解，则进行赋值操作
            if (field.isAnnotationPresent(ValidateAgeAnnotation.class)) {
                ValidateAgeAnnotation validateAgeAnnotation = field.getAnnotation(ValidateAgeAnnotation.class);
                field.setAccessible(true);
                int age = (int) field.get(user);
                if (age < validateAgeAnnotation.min() || age > validateAgeAnnotation.max()) {
                    result = false;
                    System.out.println("年龄值不符合条件");
                }
            }
        }
        return result;
    }
    static void printResult(boolean checkResult) {
        if (checkResult) {
            System.out.println("校验通过");
        } else {
            System.out.println("校验未通过");
        }
    }
}

