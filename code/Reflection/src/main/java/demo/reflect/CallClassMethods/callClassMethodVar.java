package demo.reflect.CallClassMethods;

import demo.reflect.Son;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by bear on 2020/9/4
 */
public class callClassMethodVar {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Son son = new Son("嘟嘟", 15, "10-13");

        // 第一步:获取类类型
        Class sonClass = son.getClass();
        System.out.println("未修改前名字为： " + son.getName());

        // 第二步:获取方法
        Method method;

        try {
            method = sonClass.getMethod("setName", String.class);
            // 第三步：调用setName, method.invoke(对象，参数列表)
            method.invoke(son, "呱呱");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("  修改后名字为： " + son.getName());

    }

}