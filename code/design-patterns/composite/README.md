---
layout: pattern
title: Composite
folder: composite
permalink: /patterns/composite/
categories: Structural
language: zh
tags:
 - Gang of Four
---

## 目的

将对象组合成树结构以表示部分整体层次结构, 组合可以使客户统一对待单个对象和组合对象. 

## 结构

* 抽象根节点(Component)：定义系统各层次对象的共有方法和属性, 可以预先定义一些默认行为和属性. 
* 树枝节点(Composite)：定义树枝节点的行为, 存储子节点, 组合树枝节点和叶子节点形成一个树形结构. 
* 叶子节点(Leaf)：叶子节点对象, 其下再无分支, 是系统层次遍历的最小单位. 

##  组合模式的分类
   在使用组合模式时, 根据抽象构件类的定义形式, 我们可将组合模式分为透明组合模式和安全组合模式两种形式. 
   
1. 透明组合模式   
> 透明组合模式中, 抽象根节点角色中声明了所有用于管理成员对象的方法, 比如在示例中MenuComponent 声明了 add 、 remove 、 getChild 方法, 这样做的好处是确保所有的构件类都有相同的接口. 透明组合模式也是组合模式的标准形式. 
> 透明组合模式的缺点是不够安全, 因为叶子对象和容器对象在本质上是有区别的, 叶子对象不可能有下一个层次的对象, 即不可能包含成员对象, 因此为其提供 add()、remove() 等方法是没有意义的, 这在编译阶段不会出错, 
> 但在运行阶段如果调用这些方法可能会出错(如果没有提供相应的错误处理代码)
   
2. 安全组合模式   
> 在安全组合模式中, 在抽象构件角色中没有声明任何用于管理成员对象的方法, 而是在树枝节点Menu 类中声明并实现这些方法. 安全组合模式的缺点是不够透明, 因为叶子构件和容器构件具有不同的方法, 
> 且容器构件中那些用于管理成员对象的方法没有在抽象构件类中定义, 因此客户端不能完全针对抽象编程, 必须有区别地对待叶子构件和容器构件. 

## 解释

真实世界例子

> 每个句子由单词组成, 单词又由字符组成. 这些对象中的每一个都是可打印的, 它们可以在它们之前或之后打印一些内容, 例如句子始终以句号结尾, 单词始终在其前面有空格. 

通俗的说

> 组合模式使客户能够以统一的方式对待各个对象. 

维基百科说

> 在软件工程中, 组合模式是一种分区设计模式. 组合模式中, 一组对象将像一个对象的单独实例一样被对待. 组合的目的是将对象“组成”树状结构, 以表示部分整体层次结构. 实现组合模式可使客户统一对待单个对象和组合对象. 

**程序示例**

使用上面的句子例子.  这里我们有基类`LetterComposite`和不同的可打印类型`Letter`, `Word`和`Sentence`. 

```java
public abstract class LetterComposite {

  private final List<LetterComposite> children = new ArrayList<>();

  public void add(LetterComposite letter) {
    children.add(letter);
  }

  public int count() {
    return children.size();
  }

  protected void printThisBefore() {
  }

  protected void printThisAfter() {
  }

  public void print() {
    printThisBefore();
    children.forEach(LetterComposite::print);
    printThisAfter();
  }
}

public class Letter extends LetterComposite {

  private final char character;

  public Letter(char c) {
    this.character = c;
  }

  @Override
  protected void printThisBefore() {
    System.out.print(character);
  }
}

public class Word extends LetterComposite {

  public Word(List<Letter> letters) {
    letters.forEach(this::add);
  }

  public Word(char... letters) {
    for (char letter : letters) {
      this.add(new Letter(letter));
    }
  }

  @Override
  protected void printThisBefore() {
    System.out.print(" ");
  }
}

public class Sentence extends LetterComposite {

  public Sentence(List<Word> words) {
    words.forEach(this::add);
  }

  @Override
  protected void printThisAfter() {
    System.out.print(".");
  }
}
```

然后我们有一个消息携带者来携带消息. 

```java
public class Messenger {

  LetterComposite messageFromOrcs() {

    var words = List.of(
        new Word('W', 'h', 'e', 'r', 'e'),
        new Word('t', 'h', 'e', 'r', 'e'),
        new Word('i', 's'),
        new Word('a'),
        new Word('w', 'h', 'i', 'p'),
        new Word('t', 'h', 'e', 'r', 'e'),
        new Word('i', 's'),
        new Word('a'),
        new Word('w', 'a', 'y')
    );

    return new Sentence(words);

  }

  LetterComposite messageFromElves() {

    var words = List.of(
        new Word('M', 'u', 'c', 'h'),
        new Word('w', 'i', 'n', 'd'),
        new Word('p', 'o', 'u', 'r', 's'),
        new Word('f', 'r', 'o', 'm'),
        new Word('y', 'o', 'u', 'r'),
        new Word('m', 'o', 'u', 't', 'h')
    );

    return new Sentence(words);

  }

}
```

然后它可以这样使用:

```java
var orcMessage = new Messenger().messageFromOrcs();
orcMessage.print(); // Where there is a whip there is a way.
var elfMessage = new Messenger().messageFromElves();
elfMessage.print(); // Much wind pours from your mouth.
```

## 类图

![alt text](../composite/etc/composite.urm.png "Composite class diagram")

##  优点

* 组合模式可以清楚地定义分层次的复杂对象, 表示对象的全部或部分层次, 它让客户端忽略了层次的差异, 方便对整个层次结构进行控制. 
* 客户端可以一致地使用一个组合结构或其中单个对象, 不必关心处理的是单个对象还是整个组合结构, 简化了客户端代码. 
* 在组合模式中增加新的树枝节点和叶子节点都很方便, 无须对现有类库进行任何修改, 符合“开闭原则”. 
* 组合模式为树形结构的面向对象实现提供了一种灵活的解决方案, 通过叶子节点和树枝节点的递归组合, 可以形成复杂的树形结构, 但对树形结构的控制却非常简单. 

## 适用性

使用组合模式当
* 组合模式应树形结构而生, 组合模式的核心就是对系统中大同小异的类做抽象
* 你想要表示对象的整体层次结构 (比如：文件目录显示, 多级目录呈现等树形结构数据的操作, 软件菜单等)
* 你希望客户能够忽略组合对象和单个对象之间的差异, 客户将统一对待组合结构中的所有对象. 

## 真实世界例子

* [java.awt.Container](http://docs.oracle.com/javase/8/docs/api/java/awt/Container.html) and [java.awt.Component](http://docs.oracle.com/javase/8/docs/api/java/awt/Component.html)
* [Apache Wicket](https://github.com/apache/wicket) component tree, see [Component](https://github.com/apache/wicket/blob/91e154702ab1ff3481ef6cbb04c6044814b7e130/wicket-core/src/main/java/org/apache/wicket/Component.java) and [MarkupContainer](https://github.com/apache/wicket/blob/b60ec64d0b50a611a9549809c9ab216f0ffa3ae3/wicket-core/src/main/java/org/apache/wicket/MarkupContainer.java)

## 鸣谢

* [Design Patterns: Elements of Reusable Object-Oriented Software](https://www.amazon.com/gp/product/0201633612/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0201633612&linkCode=as2&tag=javadesignpat-20&linkId=675d49790ce11db99d90bde47f1aeb59)
* [Head First Design Patterns: A Brain-Friendly Guide](https://www.amazon.com/gp/product/0596007124/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0596007124&linkCode=as2&tag=javadesignpat-20&linkId=6b8b6eea86021af6c8e3cd3fc382cb5b)
* [Refactoring to Patterns](https://www.amazon.com/gp/product/0321213351/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0321213351&linkCode=as2&tag=javadesignpat-20&linkId=2a76fcb387234bc71b1c61150b3cc3a7)
