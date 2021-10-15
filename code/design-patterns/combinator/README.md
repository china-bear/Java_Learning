---
layout: pattern
title: Combinator
folder: combinator
permalink: /patterns/combinator/
categories: Idiom
language: en
tags:
 - Reactive
---

## Also known as
Composition pattern

## Intent
函数模式代表了一种以组合函数的思想为中心的组织库的风格, 简单地说, 有一些类型 T, 一些用于构造类型 T 的"原始"值的函数,  和一些"组合器", 它们可以以各种方式组合 T 类型的值以构建更复杂的 T 类型值
>> The functional pattern representing a style of organizing libraries centered around the idea of combining functions.  
>> Putting it simply, there is some type T, some functions for constructing "primitive" values of type T, 
>> and some "combinators" which can combine values of type T in various ways to build up more complex values of type T.

## Class diagram
![alt text](./etc/combinator.urm.png "Combinator class diagram")

## Applicability
Use the combinator pattern when:

- You are able to create a more complex value from more plain values but having the same type(a combination of them)

## Real world examples

- java.util.function.Function#compose
- java.util.function.Function#andThen

## Credits

- [Example for java](https://gtrefs.github.io/code/combinator-pattern/)
- [Combinator pattern](https://wiki.haskell.org/Combinator_pattern)
- [Combinatory logic](https://wiki.haskell.org/Combinatory_logic)
