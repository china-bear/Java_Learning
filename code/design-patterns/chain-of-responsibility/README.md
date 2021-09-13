---
layout: pattern
title: Chain of responsibility
folder: chain
permalink: /patterns/chain/
categories: Behavioral
language: zh
tags:
 - Gang of Four
---
## 概述
又名职责链模式， 为了避免请求发送者与多个请求处理者耦合在一起， 将所有请求的处理者通过前一对象记住其下一个对象的引用而连成一条链, 当有请求发生时, 可将请求沿着这条链传递, 直到有对象处理它为止

## 目的
通过给多个对象一个处理请求的机会, 避免请求的发送者和它的接收者耦合, 串联接收对象并在链条中传递请求直到一个对象处理它

## 解释

真实世界例子

> 兽王大声命令他的军队。最近响应的是指挥官，然后是军官，然后是士兵。指挥官，军官，士兵这里就形成了一个责任链。

通俗的说

> 它帮助构建一串对象。请求从一个对象中进入并结束然后进入到一个个对象中直到找到合适的处理器。

维基百科说

> 在面向对象设计中，责任链模式是一种由源命令对象和一系列处理对象组成的设计模式。每个处理对象包含了其定义的可处理的命令对象类型的逻辑。剩下的会传递给链条中的下一个处理对象。

**程序示例**

用上面的兽人来翻译我们的示例。首先我们有请求类

```java
public class Request {

  private final RequestType requestType;
  private final String requestDescription;
  private boolean handled;

  public Request(final RequestType requestType, final String requestDescription) {
    this.requestType = Objects.requireNonNull(requestType);
    this.requestDescription = Objects.requireNonNull(requestDescription);
  }

  public String getRequestDescription() { return requestDescription; }

  public RequestType getRequestType() { return requestType; }

  public void markHandled() { this.handled = true; }

  public boolean isHandled() { return this.handled; }

  @Override
  public String toString() { return getRequestDescription(); }
}

public enum RequestType {
  DEFEND_CASTLE, TORTURE_PRISONER, COLLECT_TAX
}
```

然后是请求处理器的层次结构

```java
@Slf4j
public abstract class RequestHandler {
  private final RequestHandler next;

  public RequestHandler(RequestHandler next) {
    this.next = next;
  }

  public void handleRequest(Request req) {
    if (next != null) {
      next.handleRequest(req);
    }
  }

  protected void printHandling(Request req) {
    LOGGER.info("{} handling request \"{}\"", this, req);
  }

  @Override
  public abstract String toString();
}

public class OrcCommander extends RequestHandler {
  public OrcCommander(RequestHandler handler) {
    super(handler);
  }

  @Override
  public void handleRequest(Request req) {
    if (req.getRequestType().equals(RequestType.DEFEND_CASTLE)) {
      printHandling(req);
      req.markHandled();
    } else {
      super.handleRequest(req);
    }
  }

  @Override
  public String toString() {
    return "Orc commander";
  }
}

// OrcOfficer和OrcSoldier的定义与OrcCommander类似

```

然后我们有兽王下达命令并形成链条

```java
public class OrcKing {
  RequestHandler chain;

  public OrcKing() {
    buildChain();
  }

  private void buildChain() {
    chain = new OrcCommander(new OrcOfficer(new OrcSoldier(null)));
  }

  public void makeRequest(Request req) {
    chain.handleRequest(req);
  }
}
```

然后这样使用它

```java
var king = new OrcKing();
king.makeRequest(new Request(RequestType.DEFEND_CASTLE, "defend castle")); // Orc commander handling request "defend castle"
king.makeRequest(new Request(RequestType.TORTURE_PRISONER, "torture prisoner")); // Orc officer handling request "torture prisoner"
king.makeRequest(new Request(RequestType.COLLECT_TAX, "collect tax")); // Orc soldier handling request "collect tax"
```

## 类图
![alt text](../chain/etc/chain.urm.png "Chain of Responsibility class diagram")

## 结构

* 抽象处理者(Handler)角色: 定义一个处理请求的接口, 包含抽象处理方法和一个后继连接。
* 具体处理者(Concrete Handler)角色: 实现抽象处理者的处理方法, 判断能否处理本次请求, 如果可以处理请求则处理, 否则将该请求转给它的后继者
* 客户类(Client)角色: 创建处理链, 并向链头的具体处理者对象提交请求，它不关心处理细节和请求的传递过程

## 优缺点

1. 优点:
* 降低了对象之间的耦合度, 该模式降低了请求发送者和接收者的耦合度
* 增强了系统的可扩展性, 可以根据需要增加新的请求处理类, 满足开闭原则
* 增强了给对象指派职责的灵活性, 当工作流程发生变化, 可以动态地改变链内的成员或者修改它们的次序, 也可动态地新增或者删除责任
* 责任链简化了对象之间的连接, 一个对象只需保持一个指向其后继者的引用, 不需保持其他所有处理者的引用, 这避免了使用众多的 if 或者 if···else 语句
* 责任分担,  每个类只需要处理自己该处理的工作, 不能处理的传递给下一个对象完成, 明确各类的责任范围, 符合类的单一职责原则

2. 缺点:

* 不能保证每个请求一定被处理, 由于一个请求没有明确的接收者, 所以不能保证它一定会被处理, 该请求可能一直传到链的末端都得不到处理
* 对比较长的职责链, 请求的处理可能涉及多个处理对象, 系统性能将受到一定影响
* 职责链建立的合理性要靠客户端来保证, 增加了客户端的复杂性, 可能会由于职责链的错误设置而导致系统出错, 如可能会造成循环调用

## 适用性
使用责任链模式当

审批流程, 工单流程等等, 这些业务场景都很鲜明, 一个事件触发需要多个对象来处理的, 并且存在处理层次顺序的场景尝试使用职责链


## Java世界例子

* [java.util.logging.Logger#log()](http://docs.oracle.com/javase/8/docs/api/java/util/logging/Logger.html#log%28java.util.logging.Level,%20java.lang.String%29)
* [Apache Commons Chain](https://commons.apache.org/proper/commons-chain/index.html)
* [javax.servlet.Filter#doFilter()](http://docs.oracle.com/javaee/7/api/javax/servlet/Filter.html#doFilter-javax.servlet.ServletRequest-javax.servlet.ServletResponse-javax.servlet.FilterChain-)

## 鸣谢

* [Design Patterns: Elements of Reusable Object-Oriented Software](https://www.amazon.com/gp/product/0201633612/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0201633612&linkCode=as2&tag=javadesignpat-20&linkId=675d49790ce11db99d90bde47f1aeb59)
* [Head First Design Patterns: A Brain-Friendly Guide](https://www.amazon.com/gp/product/0596007124/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0596007124&linkCode=as2&tag=javadesignpat-20&linkId=6b8b6eea86021af6c8e3cd3fc382cb5b)
