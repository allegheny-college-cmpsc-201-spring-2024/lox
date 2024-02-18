# The Lox Programming Language: Grammar

This branch mirrors content from chapter `7` of _Crafting Interpreters_. To date, our interpreter
provides precedence and order of operations; we're aware of the ways that grammars tell a language
to process its expressions, but blissfully ignorant of how they do so. In so far as arithmetic
expressions are concerned, this chapter addresses one half of the parsing task: computation in `Lox`.

For a primer on the language's general syntax and usage, refer to 
[Crafting Interpreters, Chapter 3](https://www.craftinginterpreters.com/the-lox-language.html).

## Learning objectives

This assignment directly addresses the following course learning objectives:

* Correctly identify and describe the steps in the design and implementation of a programming language
* Interpret and use an existing programming language grammar
* Using knowledge of the general principles of programming languages, correctly implement a computer program in a heretofore unknown programming language

## Using this repository

While the repository's Maven configuration works from the command line, setup included contemplates
the content of the [Getting Started guide](wiki/Getting-Started), which outlines how to set
up the Java SDK and runtime in addition to helpful Maven tools for VSCode.

## Challenges

Unless tagged as optional, all challenges below are required by this week's work.

### Challenge 1

In many languages, arithmetic operators can perform _non-arithmetic_ tasks. For example, the following Python operations
allow string manipulation for non-numeric literals:
```python
# String concatenation
lox = "lox" + "lox"
lox = "lox" * 2
```
`Lox` doesn't possess these features..._yet_. Your task is two-fold: to implement both the `+` and `*` operators in the
context of computing `string`s in `Lox`. Each should function similar to their counterpart operators in `Python`. To
implement functionalty for these operators, work in the `visitBinaryExpr` method of `Interpreter.java`.


Given that we're not up to parsing multiple expressions yet, we need to work in distinct files to test these challenges:

|Operator |File |
|:--------|:----|
|`+` | [plus.lox](interpreter/src/test/resources/plus.lox) |
|`*` | [star.lox](interpreter/src/test/resources/star.lox) |

### Challenge 2

At present, if we divide by `0`, it appears that what happens...shouldn't. At all. Ever. It's practically universe-ending. However,
it shows that  different programming languages interpret the divide by zero operation in unique ways.

As policy in the `Lox` language, we should emit an error if this case ever occurs. 

This task is three-fold:

1. describe why Java interprets the operation the way it does, and
2. identify at least two unique ways that other programming languages handle the case
3. implement the above-defined behavior in the interpreter

Parts `1` and `2` should be completed in your [reflection.md](docs/reflection.md) file. Implement Part `3` in by editing the `visitBinaryExpr` 
method of `Interpreter.java` to throw an error.

Your program should correctly interpret the expression in [divide.lox](interpreter/src/test/resources/divide.lox).
