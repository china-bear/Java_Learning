---
layout: pattern
title: Mediator
folder: mediator
permalink: /patterns/mediator/
categories: Behavioral
language: en
tags:
 - Gang Of Four
 - Decoupling
---

## 定义

**中介者模式**：又叫调停模式, 使用一个中介对象来封装一系列对象之间的交互, 使得各个对象间不需要显式的互相引用, 从而减低耦合度. 中介者模式又叫调停者模式, 是一种对象行为型模式

## 解释

Real-world example  真实世界的例子

> Rogue, wizard, hobbit, and hunter have decided to join their forces and travel in the same
> party. To avoid coupling each member with each other, they use the party interface to communicate with each other.
>
> 盗贼、巫师、霍比特人和猎人决定加入他们的队伍, 一起旅行派对, 为了避免每个成员相互耦合，他们使用 派对接口 相互交流。

In plain words  用通俗的话说

> Mediator decouples a set of classes by forcing their communications flow through a mediating object.

> 中介者通过强制它们的通信流通过中介对象 来解耦一组类

Wikipedia says 维基百科说

> 系统中有大量的多对多等相互关系, 这些关系让系统的类或者组件之间的耦合度就很高，这时候就**运用迪米特法则, 引入一个中间的类**, 来维系这些关系,  者大大降低系统的耦合度， 这个引入的中间类就是中介者。
> 引入了中介者之后，可以让系统中对象的关系由网状结构转为星型结构, 系统中的对象交互都通过中介者对象来进行调度。

**Programmatic Example 程序示例**

In this example, the mediator encapsulates how a set of objects interact. Instead of referring to 
each other directly they use the mediator interface.

The party members `Rogue`, `Wizard`, `Hobbit`, and `Hunter` all inherit from the `PartyMemberBase`
implementing the `PartyMember` interface.

```java
public interface PartyMember {

  void joinedParty(Party party);

  void partyAction(Action action);

  void act(Action action);
}

@Slf4j
public abstract class PartyMemberBase implements PartyMember {

  protected Party party;

  @Override
  public void joinedParty(Party party) {
    LOGGER.info("{} joins the party", this);
    this.party = party;
  }

  @Override
  public void partyAction(Action action) {
    LOGGER.info("{} {}", this, action.getDescription());
  }

  @Override
  public void act(Action action) {
    if (party != null) {
      LOGGER.info("{} {}", this, action);
      party.act(this, action);
    }
  }

  @Override
  public abstract String toString();
}

public class Rogue extends PartyMemberBase {

  @Override
  public String toString() {
    return "Rogue";
  }
}

// Wizard, Hobbit, and Hunter are implemented similarly
```

Our mediator system consists of `Party` interface and its implementation.

```java
public interface Party {

  void addMember(PartyMember member);

  void act(PartyMember actor, Action action);
}

public class PartyImpl implements Party {

  private final List<PartyMember> members;

  public PartyImpl() {
    members = new ArrayList<>();
  }

  @Override
  public void act(PartyMember actor, Action action) {
    for (var member : members) {
      if (!member.equals(actor)) {
        member.partyAction(action);
      }
    }
  }

  @Override
  public void addMember(PartyMember member) {
    members.add(member);
    member.joinedParty(this);
  }
}
```

Here's a demo showing the mediator pattern in action.

```java
    // create party and members
    Party party = new PartyImpl();
    var hobbit = new Hobbit();
    var wizard = new Wizard();
    var rogue = new Rogue();
    var hunter = new Hunter();

    // add party members
    party.addMember(hobbit);
    party.addMember(wizard);
    party.addMember(rogue);
    party.addMember(hunter);

    // perform actions -> the other party members
    // are notified by the party
    hobbit.act(Action.ENEMY);
    wizard.act(Action.TALE);
    rogue.act(Action.GOLD);
    hunter.act(Action.HUNT);
```

Here's the console output from running the example.

```
Hobbit joins the party
Wizard joins the party
Rogue joins the party
Hunter joins the party
Hobbit spotted enemies
Wizard runs for cover
Rogue runs for cover
Hunter runs for cover
Wizard tells a tale
Hobbit comes to listen
Rogue comes to listen
Hunter comes to listen
Rogue found gold
Hobbit takes his share of the gold
Wizard takes his share of the gold
Hunter takes his share of the gold
Hunter hunted a rabbit
Hobbit arrives for dinner
Wizard arrives for dinner
Rogue arrives for dinner
```

## Class diagram

![alt text](./etc/mediator_1.png "Mediator")

## 结构 (主要角色)
* 抽象中介者(Mediator)角色: 它是中介者的接口, 提供了同事对象注册与转发同事对象信息的抽象方法
* 具体中介者(ConcreteMediator)角色: 实现中介者接口, 定义一个 List 来管理同事对象, 协调各个同事角色之间的交互关系, 因此它依赖于同事角色
* 抽象同事类(Colleague)角色: 定义同事类的接口, 保存中介者对象, 提供同事对象交互的抽象方法, 实现所有相互影响的同事类的公共功能
* 具体同事类(Concrete Colleague)角色：是抽象同事类的实现者, 当需要与其他同事对象交互时, 由中介者对象负责后续的交互

## 优缺点
1.优点：
* 松散耦合
中介者模式通过把多个同事对象之间的交互封装到中介者对象里面，从而使得同事对象之间松散耦
合，基本上可以做到互补依赖。这样一来，同事对象就可以独立地变化和复用，而不再像以前那样
“牵一处而动全身”了。
* 集中控制交互
多个同事对象的交互，被封装在中介者对象里面集中管理，使得这些交互行为发生变化的时候，只
需要修改中介者对象就可以了，当然如果是已经做好的系统，那么就扩展中介者对象，而各个同事
类不需要做修改。
* 一对多关联转变为一对一的关联
没有使用中介者模式的时候，同事对象之间的关系通常是一对多的，引入中介者对象以后，中介者
对象和同事对象的关系通常变成双向的一对一，这会让对象的关系更容易理解和实现

2.缺点:   
* 当同事类太多时，中介者的职责将很大，它会变得复杂而庞大，以至于系统难以维护

## Applicability

Use the Mediator pattern when

* A set of objects communicate in well-defined but complex ways. The resulting interdependencies are unstructured and difficult to understand
* Reusing an object is difficult because it refers to and communicates with many other objects
* A behavior that's distributed between several classes should be customizable without a lot of subclassing

## 外观模式、代理模式和中介者模式的区别 
1 外观模式（Facade Pattern）：外观类隐藏子系统的复杂性, 为客户端提供简化的方法和对现有系统类方法的委托调用
2 代理模式（Proxy Pattern）：用一个代理类代表另一个类的功能, 但不改变被代理类的功能, 目的是控制对被代理类的访问
3 中介者模式（Mediator Pattern）：用一个中介对象来封装一系列的对象交互, 中介者使各对象不需要显式地相互引用, 从而使其耦合松散, 而且可以独立地改变它们之间的交互, 将各对象之间的网状结构分离为星型结构
4 外观模式属于结构型; 代理模式式属于结构型; 中介者模式属于行为型; 

## Known uses

* All scheduleXXX() methods of [java.util.Timer](http://docs.oracle.com/javase/8/docs/api/java/util/Timer.html)
* [java.util.concurrent.Executor#execute()](http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Executor.html#execute-java.lang.Runnable-)
* submit() and invokeXXX() methods of [java.util.concurrent.ExecutorService](http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html)
* scheduleXXX() methods of [java.util.concurrent.ScheduledExecutorService](http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ScheduledExecutorService.html)
* [java.lang.reflect.Method#invoke()](http://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html#invoke-java.lang.Object-java.lang.Object...-)

## Credits

* [Design Patterns: Elements of Reusable Object-Oriented Software](https://www.amazon.com/gp/product/0201633612/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0201633612&linkCode=as2&tag=javadesignpat-20&linkId=675d49790ce11db99d90bde47f1aeb59)
* [Head First Design Patterns: A Brain-Friendly Guide](https://www.amazon.com/gp/product/0596007124/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0596007124&linkCode=as2&tag=javadesignpat-20&linkId=6b8b6eea86021af6c8e3cd3fc382cb5b)
