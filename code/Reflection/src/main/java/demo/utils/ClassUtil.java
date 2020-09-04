package demo.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * Class 类对象将一个类的方法、变量等信息告诉运行的程序
 * Created by bear on 2020/9/4
 */
public class ClassUtil {

    /**
     *  通过反射获取类的所有变量
     *
     * @param object
     */
    public static void printFieldMsg(Object object) {
        System.out.println("\n\n下面打印的是对象的    字段    信息：\n");
        Class clazz = object.getClass();
        /**
         * 成员变量也是对象
         *
         * java.lang.reflect.Field
         *
         * Field类封装了关于成员变量的操作
         *
         * getFields()获取的是所有的Public的成员变量的信息
         *
         * getDeclaredFields()获取的是该类自己声明的变量的信息
         *
         */
        // Field[] fields = clazz.getFields();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //获取访问权限并输出
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");
            // 得到成员变量的类型的类类型
            Class fieldType = field.getType();
            String typeName = fieldType.getName();
            // 得到成员变量的名称
            String fieldName = field.getName();
            System.out.println(typeName + " " + fieldName);
        }
    }
    /**
     * 打印对象的构造函数的信息
     *
     * @param object
     */
    public static void printConstructorMsg(Object object) {
        System.out.println("\n下面打印的是对象的    构造方法    信息：\n");
        Class clazz = object.getClass();
        /**
         * 构造函数也是对象
         *
         * java.lang.reflect.Constructor
         *
         * getConstructors()获取的是该类的所有public方法
         *
         * getDeclaredConstructors()获取的是该对象自己声明的构造方法
         */
        // Constructor[] constructors = clazz.getConstructors();
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.print(constructor.getName() + "(");
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramClazz : paramTypes) {
                System.out.print(paramClazz.getName()+ " , " );
            }
            System.out.println(")");
        }
    }
    /**
     * 通过反射获取类的所有方法
     *
     * @param object
     */
    public static void printMethodMsg(Object object) {
        System.out.println("\n下面打印的是对象的    方法    信息：\n");
        // 获取该对象的类类型
        Class clazz = object.getClass();
        System.out.println("类的名称是：" + clazz.getName());
        /**
         * Method类，方法对象
         *
         * java.lang.reflect.Method
         *
         * 一个成员方法就是一个Method对象
         *
         * getMethods()方法获取的就是该class or interface 的所有的public的方法，包括父类继承的方法。
         *
         * getDeclaredMethods()获取的是该class or interface 自己声明的方法，不问访问权限。
         */
//		Method[] methods = clazz.getMethods();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            //获取并输出方法的访问权限（Modifiers：修饰符）
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");

            // 得到方法的返回值类型的类类型
            Class returnType = method.getReturnType();
            System.out.print(returnType.getName() + " ");

            // 得到方法的名称
            System.out.print(method.getName() + "(");
            // 获取参数类型--> 得到的是参数列表的类类型
            Class[] paramTypes = method.getParameterTypes();
            for (Class paramClazz : paramTypes) {
                System.out.print(paramClazz.getName() + " , ");
            }
            System.out.println(")");

            //获取并输出方法的所有参数
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter:
                    parameters) {
                System.out.print(parameter.getType().getName()
                        + " " + parameter.getName() + ",");
            }

            //获取并输出方法抛出的异常
            Class[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length == 0){
                System.out.println(" )");
            }
            else {
                for (Class c : exceptionTypes) {
                    System.out.println(" ) throws "
                            + c.getName());
                }
            }
        }
    }
}
