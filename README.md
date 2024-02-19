# The Lox Programming Language: Grammar

This branch mirrors content from chapter `6` of _Crafting Interpreters_. In pursuit of implementing
our ability to parse expressions for content, these exercises consider _precedence_ and additional
implications of our productions rules, derivations, and grammar.

This week's work expands and complicates a software design pattern common to interpreters and
compilers: the `Visitor` pattern. Understanding this pattern constitutes a key concept in at
least this interpreter's implementation. 

For a primer on the language's general syntax and usage, refer to 
[Crafting Interpreters, Chapter 3](https://www.craftinginterpreters.com/the-lox-language.html).

## Learning objectives

This assignment directly addresses the following course learning objectives:

* Correctly identify and describe the steps in the design and implementation of a programming language
* Interpret and use an existing programming language grammar
* Design, implement, and evaluate a correct scanner and parser for a programming language.

## Using this repository

While the repository's Maven configuration works from the command line, setup included contemplates
the content of the [Getting Started guide](wiki/Getting-Started), which outlines how to set
up the Java SDK and runtime in addition to helpful Maven tools for VSCode.

## Challenges

Unless tagged as optional, all challenges below are required by this week's work.

### Challenge 1

Many languages implement the ability to parse multiple expressions as part of the assignment process. Before
we assign expressions as interpretable objects, we need to understand how to prioritize and separate expressions.
Here, Nystrom points out the [comma operator](https://en.wikipedia.org/wiki/Comma_operator) as the main mechanism
for this kind of multiple assignment.

Implementing this operator helps us learn about _precedence_. Your task is to work across a few files to implement
the comma operator. To complete this, you'll need to think back to our experience with tokens to full complete it.
Mostly, we'll be working in:

* [Parser.java](interpreter/src/main/java/com/interpreter/lox/Parser.java)
* [ASTPrinter.java](interpreter/src/main/java/com/interpreter/lox/ASTPrinter.java)

Your program should correctly interpret the expressions in [test.lox](interpreter/src/test/resources/test.lox).

### Challenge 2

To further explore concepts this week, implement _ternary_ expressions for `Lox`. The example from our `test.lox`:
```
a == 1 ? true : false
```
evaluates to "If `a` is `1`, return `true`, else `false`. For our ternary expressions, your parser should process
anything with two branches as `if-else` statements and anything only one as an `if` statement.

To complete this work, you'll need to _add_ tokens to our language, so you'll be working in `3` files:

* [Parser.java](interpreter/src/main/java/com/interpreter/lox/Parser.java)
* [TokenType.java](interpreter/src/main/java/com/interpreter/lox/TokenType.java)
* [ASTPrinter.java](interpreter/src/main/java/com/interpreter/lox/ASTPrinter.java)
