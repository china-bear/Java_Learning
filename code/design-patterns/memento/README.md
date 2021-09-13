---
layout: pattern
title: Memento
folder: memento
permalink: /patterns/memento/
categories: Behavioral
language: en
tags:
 - Gang of Four
---

## 概述

> 又叫快照模式, 备忘录模式提供了一种状态恢复的实现机制, 使得用户可以方便地回到一个特定的历史步骤, 当新的状态无效或者存在问题时, 可以使用暂时存储起来的备忘录将状态复原,
> 很多软件都提供了撤销(Undo)操作, 如 Word、记事本、Photoshop、IDEA等软件在编辑时按 Ctrl+Z 组合键时能撤销当前操作，使文档恢复到之前的状态
> 还有在浏览器中的后退键、数据库事务管理中的回滚操作、玩游戏时的中间结果存档功能、数据库与操作系统的备份操作、棋类游戏中的悔棋功能等都属于这类

## 定义

Without violating encapsulation, capture and externalize an object's internal state so that the 
object can be restored to this state later.

在不破坏封装性的前提下, 捕获一个对象的内部状态, 并在该对象之外保存这个状态, 以便以后当需要时能将该对象恢复到原先保存的状态

## 结构

* 发起人(Originator)角色: 记录当前时刻的内部状态信息, 提供创建备忘录和恢复备忘录数据的功能, 实现其他业务功能, 它可以访问备忘录里的所有信息
* 备忘录(Memento)角色：负责存储发起人的内部状态, 在需要的时候提供这些内部状态给发起人
* 管理者(Caretaker)角色：对备忘录进行管理, 提供保存与获取备忘录的功能, 但其不能对备忘录的内容进行访问与修改

## Explanation

Real-world example

> We are working on an astrology application where we need to analyze star properties over time. We 
> are creating snapshots of star states using the Memento pattern.

In plain words

> Memento pattern captures object internal state making it easy to store and restore objects in any 
> point of time.

Wikipedia says

> The memento pattern is a software design pattern that provides the ability to restore an object to 
> its previous state (undo via rollback).

**Programmatic Example**

Let's first define the types of stars we are capable to handle.

```java
public enum StarType {
  SUN("sun"),
  RED_GIANT("red giant"),
  WHITE_DWARF("white dwarf"),
  SUPERNOVA("supernova"),
  DEAD("dead star");
  ...
}
```

Next, let's jump straight to the essentials. Here's the `Star` class along with the mementos that we 
need to manipulate. Especially pay attention to `getMemento` and `setMemento` methods.

```java
public interface StarMemento {
}

public class Star {

  private StarType type;
  private int ageYears;
  private int massTons;

  public Star(StarType startType, int startAge, int startMass) {
    this.type = startType;
    this.ageYears = startAge;
    this.massTons = startMass;
  }

  public void timePasses() {
    ageYears *= 2;
    massTons *= 8;
    switch (type) {
      case RED_GIANT:
        type = StarType.WHITE_DWARF;
        break;
      case SUN:
        type = StarType.RED_GIANT;
        break;
      case SUPERNOVA:
        type = StarType.DEAD;
        break;
      case WHITE_DWARF:
        type = StarType.SUPERNOVA;
        break;
      case DEAD:
        ageYears *= 2;
        massTons = 0;
        break;
      default:
        break;
    }
  }

  StarMemento getMemento() {
    var state = new StarMementoInternal();
    state.setAgeYears(ageYears);
    state.setMassTons(massTons);
    state.setType(type);
    return state;
  }

  void setMemento(StarMemento memento) {
    var state = (StarMementoInternal) memento;
    this.type = state.getType();
    this.ageYears = state.getAgeYears();
    this.massTons = state.getMassTons();
  }

  @Override
  public String toString() {
    return String.format("%s age: %d years mass: %d tons", type.toString(), ageYears, massTons);
  }

  private static class StarMementoInternal implements StarMemento {

    private StarType type;
    private int ageYears;
    private int massTons;

    // setters and getters ->
    ...
  }
}
```

And finally here's how we use the mementos to store and restore star states.

```java
    var states = new Stack<>();
    var star = new Star(StarType.SUN, 10000000, 500000);
    LOGGER.info(star.toString());
    states.add(star.getMemento());
    star.timePasses();
    LOGGER.info(star.toString());
    states.add(star.getMemento());
    star.timePasses();
    LOGGER.info(star.toString());
    states.add(star.getMemento());
    star.timePasses();
    LOGGER.info(star.toString());
    states.add(star.getMemento());
    star.timePasses();
    LOGGER.info(star.toString());
    while (states.size() > 0) {
      star.setMemento(states.pop());
      LOGGER.info(star.toString());
    }
```

Program output:

```
sun age: 10000000 years mass: 500000 tons
red giant age: 20000000 years mass: 4000000 tons
white dwarf age: 40000000 years mass: 32000000 tons
supernova age: 80000000 years mass: 256000000 tons
dead star age: 160000000 years mass: 2048000000 tons
supernova age: 80000000 years mass: 256000000 tons
white dwarf age: 40000000 years mass: 32000000 tons
red giant age: 20000000 years mass: 4000000 tons
sun age: 10000000 years mass: 500000 tons
```

## Class diagram

![alt text](./etc/memento.png "Memento")

## 优缺点

1. 优点：
* 提供了一种可以恢复状态的机制, 当用户需要时能够比较方便地将数据恢复到某个历史的状态
* 实现了内部状态的封装, 除了创建它的发起人之外, 其他对象都不能够访问这些状态信息
* 简化了发起人类, 发起人不需要管理和保存其内部状态的各个备份, 所有状态信息都保存在备忘录中, 并由管理者进行管理, 这符合单一职责原则
 
2.缺点：
* 资源消耗大, 如果要保存的内部状态信息过多或者特别频繁, 将会占用比较大的内存资源

## Applicability

Use the Memento pattern when

* A snapshot of an object's state must be saved so that it can be restored to that state later, and
* A direct interface to obtaining the state would expose implementation details and break the 
object's encapsulation

* 需要保存与恢复数据的场景, 如玩游戏时的中间结果的存档功能
* 需要提供一个可回滚操作的场景, 如 Word、记事本、Photoshop、idea等软件在编辑时按Ctrl+Z 组合键，还有数据库中事务操作

## Known uses

* [java.util.Date](http://docs.oracle.com/javase/8/docs/api/java/util/Date.html)

## Credits

* [Design Patterns: Elements of Reusable Object-Oriented Software](https://www.amazon.com/gp/product/0201633612/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0201633612&linkCode=as2&tag=javadesignpat-20&linkId=675d49790ce11db99d90bde47f1aeb59)
* [Head First Design Patterns: A Brain-Friendly Guide](https://www.amazon.com/gp/product/0596007124/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0596007124&linkCode=as2&tag=javadesignpat-20&linkId=6b8b6eea86021af6c8e3cd3fc382cb5b)
