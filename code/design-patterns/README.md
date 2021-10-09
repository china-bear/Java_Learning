# Java设计模式示例

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT) 

设计模式是软件设计中常见问题的典型解决方案, 它们就像能根据需求进行调整的预制蓝图, 可用于解决代码中反复出现的设计问题, 设计模式的一个重要原则就是: 别改代码, 只需要添代码

## 创建模式(Creational)

> 将对象的创建与使用分离, 这样可以降低系统的耦合度, 使用者不需要关注对象的创建细节

1. [单例(Singleton)模式](../design-patterns/singleton/README.md)
2. [工厂方法(Factory-Method)模式](../design-patterns/factory-method/README.md)
3. [抽象工厂(Factory-Abstract)模式](../design-patterns/factory-abstract/README.md)
4. [原型(Prototype)模式](../design-patterns/prototype/README.md)
5. [生成器模式(Builder)模式](../design-patterns/builder/README.md)

-- **模式扩展收集**
6. [工厂套件(Factory Kit)模式](../design-patterns/factory-kit/README.md)

-- **模式扩展收集**

## 结构模式(Structural)

> 结构型模式描述如何将类或对象按某种布局组成更大的结构, 它分为类结构型模式和对象结构型模式, 前者采用继承机制来组织接口和类, 后者釆用组合或聚合来组合对象
> 由于组合关系或聚合关系比继承关系耦合度低, 满足"合成复用原则", 所以对象结构型模式比类结构型模式具有更大的灵活性

1. [门面(Facade)模式 也叫外观模式](../design-patterns/facade/README.md)
2. [代理(Proxy)模式](../design-patterns/proxy/README.md)
3. [适配器(Adapter)模式](../design-patterns/adapter/README.md)
4. [组合(Composite)模式](../design-patterns/composite/README.md)
5. [装饰(Decorator)模式](../design-patterns/decorator/README.md)
6. [桥接(Bridge)模式](../design-patterns/bridge/README.md)
7. [享元(Flyweight)模式](../design-patterns/flyweight/README.md)

-- **模式扩展收集**

## 行为模式(Behavioral)

> 行为型模式用于描述程序在运行时复杂的流程控制, 即描述多个类或对象之间怎样相互协作共同完成单个对象都无法单独完成的任务, 它涉及算法与对象间职责的分配
> 行为型模式分为类行为模式和对象行为模式, 前者采用继承机制来在类间分派行为, 后者采用组合或聚合在对象间分配行为
> 由于组合关系或聚合关系比继承关系耦合度低, 满足"合成复用原则", 所以对象行为模式比类行为模式具有更大的灵活性
> 除了模板方法模式是类行为型模式, 以下10种模式其他的全部属于对象行为型模式

1. [状态(State)模式](../design-patterns/state/README.md)
2. [策略(Strategy)模式](../design-patterns/strategy/README.md)
3. [访问者(Visitor)模式](../design-patterns/visitor/README.md)
4. [命令(Command)模式](../design-patterns/command/README.md)
5. [责任链(CoR)模式](../design-patterns/chain-of-responsibility/README.md)
6. [迭代器(iterator)模式](../design-patterns/iterator/README.md)
7. [中介者(mediator)模式](../design-patterns/mediator/README.md)
8. [备忘录(memento)模式](../design-patterns/memento/README.md)
9. [观察者(observer)模式](../design-patterns/observer/README.md)
10.[模板方法(template-method)模式](../design-patterns/template-method/README.md)
11.[解释器模式(interpreter)](../design-patterns/interpreter/README.md)

-- **模式扩展收集**
12. [重试(retry)模式](../design-patterns/retry/README.md)
13. [双缓冲(Double Buffer)模式](../design-patterns/double-buffer/README.md)
14. [优先队列(Priority Queue)模式](../design-patterns/priority-queue/README.md)

## 并发模式(Concurrency)
1. [生产者-消费者(producer-consumer)模式](../design-patterns/producer-consumer/README.md)
2. [线程池(Thread Pool)模式](../design-patterns/state/README.md)
3. [止步模式(balking)模式](../design-patterns/balking/README.md)

## 软件架构模式(software architecture)

> 架构模式是一个通用的、可重用的解决方案, 用于在给定上下文中的软件体系结构中经常出现的问题. 架构模式与软件设计模式类似, 但具有更广泛的范围

1. [数据映射器(data-mapper)模式](../design-patterns/data-mapper/README.md)
2. [数据访问对象(dao)模式](../design-patterns/dao/README.md)
3. [数据总线(data-bus)](../design-patterns/data-bus/README.md)

10种常见的软件架构模式  https://zhuanlan.zhihu.com/p/266696645
分层模式
客户端-服务器模式
主从设备模式
管道-过滤器模式
代理模式
点对点模式
事件总线模式
模型-视图-控制器模式
黑板模式
解释器模式

微核架构（插件化架构）
微服务架构
云架构

## 惯用语法(Idiom)

1.[回调(callback)模式](../design-patterns/callback/README.md)
2.[双重检查锁(Double Checked Locking)模式](../design-patterns/double-checked-locking/README.md)


## 引用
[Design patterns implemented in Java](https://github.com/iluwatar/java-design-patterns)
[常用的设计模式](https://sourcemaking.com/design_patterns)
[常用的设计模式](https://refactoringguru.cn/design-patterns)
[Java patterns implemented](https://java-design-patterns.com/patterns/)
