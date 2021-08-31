#Java 9：List.of()与Arrays.asList()的区别

##1. Arrays.asList返回的是可变的列表，而List.of返回的是不可变的列表

```java
List<Integer> list = Arrays.asList(1, 2, null);
list.set(3, 3); // 允许
```

##2. Arrays.asList运行null元素，而List.of则不允许

```java
List<Integer> list = Arrays.asList(1, 2, null); // 允许
List<Integer> list = List.of(1, 2, null); // 这里会抛出NullPointException
```

##3. Arrays.asList返回的列表使用contains可以来检查null，而List.of不能检查null，会报NullPointException.

```java
List<Integer> list = Arrays.asList(1, 2, 3);
list.contains(null); // 返回false

List<Integer> list = List.of(1, 2, 3);
list.contains(null); // 这里会抛出NullPointException
```

##4. Arrays.asList返回的是原来数组的视图，对原来数组做修改会放映到列表中，而List.of不会

```java
Integer[] array = {1,2,3};
List<Integer> list = Arrays.asList(array);
array[1] = 10;
System.out.println(list); // 输出[1,10,3]，第二个元素已被修改为10

Integer[] array = {1,2,3};
List<Integer> list = List.of(array);
array[1] = 10;
System.out.println(list); // 输出 [1, 2, 3]
```

## Java 9 以上版本新增了List.of 集合工具方法, Java8 只有 Arrays.asList集合工具方法