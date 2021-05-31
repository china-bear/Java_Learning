package Samples.erase;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.*;
import java.util.*;

public class GetGenericParameterType<T> {

    //是ParameterizedType
    private HashMap<String, Object> map;
    private HashSet<String> set;
    private Class<?> clz;

    //不是ParameterizedType
    private Integer i;
    private String str;


    //泛型数组类型
    private T[] value;
    private List<String>[] list;

    //不是泛型数组类型
    private List<String> singleList;
    private T singleValue;


    public static void main(String[] args) throws NoSuchMethodException {
        // ParameterizedType：参数化类型
        printParameterizedType();

        // 黑马JVM 泛型优化
        Method test = GetGenericParameterType.class.getMethod("test", List.class, Map.class, Integer.class);
        Type[] types = test.getGenericParameterTypes();
        for (Type type : types) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                System.out.println("父类的类型" +  parameterizedType.getOwnerType());
                Type[] arguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < arguments.length; i++) {
                    System.out.printf("泛型参数[%d] - %s\n", i, arguments[i]);
                }
            } else {
                System.out.println("普通类型变量 - " + type.getTypeName());
            }
        }

        // GenericArrayType：泛型数组类型
        Field[] fields = GetGenericParameterType.class.getDeclaredFields();
        for (Field field: fields){
            field.setAccessible(true);
            //输出当前变量是否为GenericArrayType类型
            System.out.println("Field: "
                    + field.getName()
                    + "; instanceof GenericArrayType"
                    + ": "
                    + (field.getGenericType() instanceof GenericArrayType));
            if (field.getGenericType() instanceof GenericArrayType){
                //如果是GenericArrayType，则输出当前泛型类型
                System.out.println("Field: "
                        + field.getName()
                        + "; getGenericComponentType()"
                        + ": "
                        + (((GenericArrayType) field.getGenericType()).getGenericComponentType()));
            }
        }

        // WildcardType: 通配符类型

        //获取TestWildcardType类的所有方法(本例中即 testWildcardType 方法)
        Method[] methods = GetGenericParameterType.class.getDeclaredMethods();
        for (Method method: methods) {
            //获取方法的所有参数类型
            Type[] types2 = method.getGenericParameterTypes();
            for (Type paramsType : types2) {
                System.out.println("type: " + paramsType.toString());
                //如果不是参数化类型则直接continue，执行下一个循环条件
                if (!(paramsType instanceof ParameterizedType)) {
                    continue;
                }
                //将当前类型强转为参数化类型并获取其实际参数类型(即含有通配符的泛型类型)
                Type type = ((ParameterizedType) paramsType).getActualTypeArguments()[0];
                //输出其是否为通配符类型
                System.out.println("type instanceof WildcardType : " +
                        (type instanceof WildcardType));
                if (type instanceof WildcardType) {
                    int lowIndex = ((WildcardType) type).getLowerBounds().length - 1;
                    int upperIndex = ((WildcardType) type).getUpperBounds().length - 1;
                    //输出上边界与下边界
                    System.out.println("getLowerBounds(): "
                            +
                            (lowIndex >= 0 ? ((WildcardType) type).getLowerBounds()[lowIndex] : "String ")
                            + "; getUpperBounds(): "
                            +
                            (upperIndex >= 0 ? ((WildcardType) type).getUpperBounds()[upperIndex] : "Object"));
                }
            }
        }
    }


    public static Set<Integer> test (List<String> list, Map<Integer, Object> map, Integer num) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        return set;
    }

    /**
     *    https://juejin.cn/post/6844903597977632776   Java中的Type类型详解
     *    type是Java语言中所有类型的公共父接口
     *    Type四个子类——ParameterizedType、 TypeVariable、GenericArrayType、WildcardType
     */


    public void testWildcardType(List<? extends OutputStream> numberList,
                                 List<? super InputStream> upperList, List<Integer> list, InputStream inputStream){

    }

    private static void  printParameterizedType(){
        Field[] fields = GetGenericParameterType.class.getDeclaredFields();
        for (Field f : fields){
            //打印是否是ParameterizedType类型
            System.out.println("FieldName:  " + f.getName() + " instanceof ParameterizedType is : " +
                    (f.getGenericType() instanceof ParameterizedType));
        }
        //取map这个类型中的实际参数类型的数组
        getParameterizedTypeWithName("map");
        getParameterizedTypeWithName("str");
    }

    private static void getParameterizedTypeWithName(String name){
        Field f;
        try {
            //利用反射得到TestParameterizedTypeBean类中的所有变量
            f = GetGenericParameterType.class.getDeclaredField(name);
            f.setAccessible(true);
            Type type = f.getGenericType();
            if (type instanceof ParameterizedType){
                for(Type param : ((ParameterizedType)type).getActualTypeArguments()){
                    //打印实际参数类型
                    System.out.println("---type actualType---" + param.toString());
                }
                //打印所在的父类的类型
                System.out.println("---type ownerType0---"+ ((ParameterizedType) type).getOwnerType());
                //打印其本身的类型
                System.out.println("---type rawType---"+ ((ParameterizedType) type).getRawType());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
