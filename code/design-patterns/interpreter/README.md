---
layout: pattern
title: Interpreter
folder: interpreter
permalink: /patterns/interpreter/
categories: Behavioral
language: zh
tags:
 - Gang of Four
---

## 目的

给定一个语言, 定义它的(语法的形式)文法表示, 并定义一个解释器, 以及定义并使用该表示形式来解释该语言中的句子的解释器

## 结构

* 抽象表达式(Abstract Expression)角色: 定义解释器的接口, 约定解释器的解释操作, 主要包含解释方法 interpret(). 
* 终结符表达式(Terminal Expression)角色: 是抽象表达式的子类, 用来实现文法中与终结符相关的操作, 文法中的每一个终结符都有一个具体终结表达式与之相对应. 
* 非终结符表达式(Nonterminal Expression)角色: 也是抽象表达式的子类, 用来实现文法中与非终结符相关的操作, 文法中的每条规则都对应于一个非终结符表达式. 
* 环境(Context)角色: 通常包含各个解释器需要的数据或是公共的功能, 一般用来传递被所有解释器共享的数据, 后面的解释器可以从这里获取这些值. 
* 客户端(Client): 主要任务是将需要分析的句子或表达式转换成使用解释器对象描述的抽象语法树, 然后调用解释器的解释方法, 当然也可以通过环境角色间接访问解释器的解释方法. 

## 解析
文法是用于描述语言的语法结构的形式规则 
> expression ::= value | plus | minus
> plus ::= expression ‘+’ expression
> minus ::= expression ‘-’ expression
> value ::= integer

抽象语法树: 在计算机科学中, 抽象语法树(AbstractSyntaxTree, AST),或简称语法树(Syntax tree), 是源代码语法结构的一种抽象表示
> 以树状的形式表现编程语言的语法结构
> 树上的每个节点都表示源代码中的一种结构
> 用树形来表示符合文法规则的句子

## 类图
![alt text](../interpreter/etc/interpreter_1.png "Interpreter")

## 优缺点

1. 优点:
* 易于改变和扩展文法: 由于在解释器模式中使用类来表示语言的文法规则, 因此可以通过继承等机制来改变或扩展文法, 每一条文法规则都可以表示为一个类, 因此可以方便地实现一个简单的语言. 
* 实现文法较为容易: 在抽象语法树中每一个表达式节点类的实现方式都是相似的, 这些类的代码编写都不会特别复杂. 
* 增加新的解释表达式较为方便:  如果用户需要增加新的解释表达式只需要对应增加一个新的终结符表达式或非终结符表达式类, 原有表达式类代码无须修改, 符合 "开闭原则". 

2. 缺点: 
* 对于复杂文法难以维护: 在解释器模式中, 每一条规则至少需要定义一个类, 因此如果一个语言包含太多文法规则, 类的个数将会急剧增加, 导致系统难以管理和维护. 
* 执行效率较低: 由于在解释器模式中使用了大量的循环和递归调用, 因此在解释较为复杂的句子时其速度很慢, 而且代码的调试过程也比较麻烦. 

## 适用性

有一种要解释的语言时, 请使用解释器模式, 并且可以将语言中的语句表示为抽象语法树,解释器模式在以下情况下效果最佳
* 语法很简单, 对于复杂的语法的类层次结构变得庞大且难以管理, 在这种情况下解析器生成器之类的工具是更好的选择, 他们可以在不构建抽象语法树的情况下解释表达式, 这可以节省空间并可能节省时间
* 效率不是关键问题. 通常最有效的解释器不是通过直接解释解析树来实现的, 而是先将其转换为另一种形式.  例如 正则表达式通常会转换为状态机, 但是即使这样, 翻译器也可以通过解释器模式实现, 因此该模式仍然适用

## 真实世界例子

* [java.util.Pattern](http://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html)
* [java.text.Normalizer](http://docs.oracle.com/javase/8/docs/api/java/text/Normalizer.html)
* All subclasses of [java.text.Format](http://docs.oracle.com/javase/8/docs/api/java/text/Format.html)
* [javax.el.ELResolver](http://docs.oracle.com/javaee/7/api/javax/el/ELResolver.html)

## 鸣谢

* [Design Patterns: Elements of Reusable Object-Oriented Software](https://www.amazon.com/gp/product/0201633612/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0201633612&linkCode=as2&tag=javadesignpat-20&linkId=675d49790ce11db99d90bde47f1aeb59)
* [Head First Design Patterns: A Brain-Friendly Guide](https://www.amazon.com/gp/product/0596007124/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0596007124&linkCode=as2&tag=javadesignpat-20&linkId=6b8b6eea86021af6c8e3cd3fc382cb5b)
* [Refactoring to Patterns](https://www.amazon.com/gp/product/0321213351/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0321213351&linkCode=as2&tag=javadesignpat-20&linkId=2a76fcb387234bc71b1c61150b3cc3a7)
