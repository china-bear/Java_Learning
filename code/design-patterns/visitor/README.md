---
layout: pattern
title: Visitor
folder: visitor
permalink: /patterns/visitor/
categories: Behavioral
language: zh
tags:
 - Gang of Four
---

## 目的

表示要在对象结构的元素上执行的操作, 访问者可让你定义新操作, 而无需更改其所操作元素的类

## 结构

封装一些作用于某种数据结构中的各元素的操作，它可以在不改变这个数据结构的前提下定义作用于这些元素的新的操作
* 抽象访问者（Visitor）角色：定义了对每一个元素（Element） 访问的行为，它的参数就是可以访问的元素，它的方法个数理论上来讲与元素类个数（Element的实现类个数）是一样的，从 这点不难看出，访问者模式要求元素类的个数不能改变
* 具体访问者（ConcreteVisitor）角色：给出对每一个元素类访问时所产生的具体行为
* 抽象元素（Element）角色：定义了一个接受访问者的方法（ accept ），其意义是指，每一个元素都要可以被访问者访问。
* 具体元素（ConcreteElement）角色： 提供接受访问方法的具体实现，而这个具体的实现，通常情况下是使用访问者提供的访问该元素类的方法。
* 对象结构（Object Structure）角色：定义当中所提到的对象结构，对象结构是一个抽象表述，具体点可以理解为一个具有容器性质或者复合对象特性的类，它会含有一组元素（ Element ），并且可以迭代这些元素，供访问者访问。

## 解释

真实世界例子

> 考虑有一个带有军队单位的树形结构。指挥官下有两名中士，每名中士下有三名士兵。基于这个层级结构实现访问者模式，我们可以轻松创建与指挥官，中士，士兵或所有人员互动的新对象

通俗的说

> 访问者模式定义可以在数据结构的节点上执行的操作。

维基百科说

> 在面向对象的程序设计和软件工程中，访问者设计模式是一种将算法与操作对象的结构分离的方法。这种分离的实际结果是能够在不修改结构的情况下向现有对象结构添加新操作。

**程序示例**

使用上面的军队单元的例子，我们首先由单位和单位访问器类型。

```java
public abstract class Unit {

  private final Unit[] children;

  public Unit(Unit... children) {
    this.children = children;
  }

  public void accept(UnitVisitor visitor) {
    Arrays.stream(children).forEach(child -> child.accept(visitor));
  }
}

public interface UnitVisitor {

  void visitSoldier(Soldier soldier);

  void visitSergeant(Sergeant sergeant);

  void visitCommander(Commander commander);
}
```

然后我们有具体的单元。

```java
public class Commander extends Unit {

  public Commander(Unit... children) {
    super(children);
  }

  @Override
  public void accept(UnitVisitor visitor) {
    visitor.visitCommander(this);
    super.accept(visitor);
  }

  @Override
  public String toString() {
    return "commander";
  }
}

public class Sergeant extends Unit {

  public Sergeant(Unit... children) {
    super(children);
  }

  @Override
  public void accept(UnitVisitor visitor) {
    visitor.visitSergeant(this);
    super.accept(visitor);
  }

  @Override
  public String toString() {
    return "sergeant";
  }
}

public class Soldier extends Unit {

  public Soldier(Unit... children) {
    super(children);
  }

  @Override
  public void accept(UnitVisitor visitor) {
    visitor.visitSoldier(this);
    super.accept(visitor);
  }

  @Override
  public String toString() {
    return "soldier";
  }
}
```

然后有一些具体的访问者。

```java
public class CommanderVisitor implements UnitVisitor {

  private static final Logger LOGGER = LoggerFactory.getLogger(CommanderVisitor.class);

  @Override
  public void visitSoldier(Soldier soldier) {
    // Do nothing
  }

  @Override
  public void visitSergeant(Sergeant sergeant) {
    // Do nothing
  }

  @Override
  public void visitCommander(Commander commander) {
    LOGGER.info("Good to see you {}", commander);
  }
}

public class SergeantVisitor implements UnitVisitor {

  private static final Logger LOGGER = LoggerFactory.getLogger(SergeantVisitor.class);

  @Override
  public void visitSoldier(Soldier soldier) {
    // Do nothing
  }

  @Override
  public void visitSergeant(Sergeant sergeant) {
    LOGGER.info("Hello {}", sergeant);
  }

  @Override
  public void visitCommander(Commander commander) {
    // Do nothing
  }
}

public class SoldierVisitor implements UnitVisitor {

  private static final Logger LOGGER = LoggerFactory.getLogger(SoldierVisitor.class);

  @Override
  public void visitSoldier(Soldier soldier) {
    LOGGER.info("Greetings {}", soldier);
  }

  @Override
  public void visitSergeant(Sergeant sergeant) {
    // Do nothing
  }

  @Override
  public void visitCommander(Commander commander) {
    // Do nothing
  }
}
```

最后，来看看实践中访问者模式的力量。

```java
commander.accept(new SoldierVisitor());
commander.accept(new SergeantVisitor());
commander.accept(new CommanderVisitor());
```

程序输出:

```
Greetings soldier
Greetings soldier
Greetings soldier
Greetings soldier
Greetings soldier
Greetings soldier
Hello sergeant
Hello sergeant
Good to see you commander
```

## Class diagram

![alt text](../visitor/etc/visitor_1.png "Visitor")

## 优缺点

1. 优点
* 扩展性好: 在不修改对象结构中的元素的情况下，为对象结构中的元素添加新的功能。
* 复用性好: 通过访问者来定义整个对象结构通用的功能，从而提高复用程度。
* 分离无关行为: 通过访问者来分离无关的行为，把相关的行为封装在一起，构成一个访问者，这样每一个访问者的功能都比较单一

2. 缺点
* 对象结构变化很困难在访问者模式中，每增加一个新的元素类，都要在每一个具体访问者类中增加相应的具体操作，这违背了“开闭原则”
* 违反了依赖倒置原则, 访问者模式依赖了具体类，而没有依赖抽象类

## 适用性

使用访问者模式当

* 对象结构包含许多具有不同接口的对象类，并且你希望根据这些对象的具体类对这些对象执行操作。
* 需要对对象结构中的对象执行许多不同且不相关的操作，并且你想避免使用这些操作“污染”它们的类。 访问者可以通过在一个类中定义相关操作来将它们保持在一起。当许多应用程序共享对象结构时，请使用访问者模式将操作仅放在需要它们的那些应用程序中
* 定义对象结构的类很少变化，但是你经常想在结构上定义新的操作, 更改对象结构类需要重新定义所有访问者的接口, 这可能会导致成本高昂。如果对象结构类经常更改，则最好在这些类中定义操作。

## 扩展

> 变量被声明时的类型叫做变量的静态类型, 而变量所引用的对象的真实类型又叫做变量的实际类型
> 比如 Map map = new HashMap() ，map变量的静态类型是 Map，实际类型是 HashMap     
   
> 根据对象的类型而对方法进行的选择，就是分派(Dispatch)，分派 (Dispatch)又分为两种，即静态分派和动态分派
* 静态分派(Static Dispatch) 发生在编译时期，分派根据静态类型信息发生，方法重载就是静态分派
* 动态分派(Dynamic Dispatch) 发生在运行时期，动态分派动态地置换掉某个方法, Java通过方法的重写支持动态分派

## 真实例子

* [Apache Wicket](https://github.com/apache/wicket) component tree, see [MarkupContainer](https://github.com/apache/wicket/blob/b60ec64d0b50a611a9549809c9ab216f0ffa3ae3/wicket-core/src/main/java/org/apache/wicket/MarkupContainer.java)
* [javax.lang.model.element.AnnotationValue](http://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/AnnotationValue.html) and [AnnotationValueVisitor](http://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/AnnotationValueVisitor.html)
* [javax.lang.model.element.Element](http://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/Element.html) and [Element Visitor](http://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/ElementVisitor.html)
* [java.nio.file.FileVisitor](http://docs.oracle.com/javase/8/docs/api/java/nio/file/FileVisitor.html)

## 鸣谢

* [Design Patterns: Elements of Reusable Object-Oriented Software](https://www.amazon.com/gp/product/0201633612/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0201633612&linkCode=as2&tag=javadesignpat-20&linkId=675d49790ce11db99d90bde47f1aeb59)
* [Head First Design Patterns: A Brain-Friendly Guide](https://www.amazon.com/gp/product/0596007124/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0596007124&linkCode=as2&tag=javadesignpat-20&linkId=6b8b6eea86021af6c8e3cd3fc382cb5b)
* [Refactoring to Patterns](https://www.amazon.com/gp/product/0321213351/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0321213351&linkCode=as2&tag=javadesignpat-20&linkId=2a76fcb387234bc71b1c61150b3cc3a7)
