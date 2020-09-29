package reflect.CallClassMethods;

import reflect.Son;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by bear on 2020/9/4
 */
public class getPrivateMethod {

    public static void main(String[] args) {

        Son son = new Son();

        // 第一步:获取类类型
        Class sonClass = son.getClass();

        //2. 获取私有方法
        //第一个参数为要获取的私有方法的名称
        //第二个为要获取方法的参数的类型，参数为 Class...，没有参数就是null
        //方法参数也可这么写 ：new Class[]{String.class , int.class}

        Method privateMethod = null;

        try {
            privateMethod = sonClass.getDeclaredMethod("privateMethod", String.class, int.class);

            //3. 开始操作方法
            if (privateMethod != null) {
                //获取私有方法的访问权
                //只是获取访问权，并不是修改实际权限
                privateMethod.setAccessible(true);

                //使用 invoke 反射调用私有方法
                //privateMethod 是获取到的私有方法
                //testClass 要操作的对象
                //后面两个参数传实参
                privateMethod.invoke(son, "Java Reflect ", 666);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
