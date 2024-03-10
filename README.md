# The Lox Programming Language: Functions

This branch mirrors content from chapter `10` of _Crafting Interpreters_. Here, we implement functions in the `Lox`
language, exploring their characteristics, similarities, and differences to other structures we've written into
our interpreter. Our challenges this week look at `native functions` and give users of the interpreter the ability
to use a `native interface` to write their own in the `Lox` programming language itself. As an added treat, we'll
look at anonymous functions (i.e., `lambda` functions) and implement them in the interpreter. 

Work for this week's challenges is split between two files, named in each challenge below.

This exercise will use the `Lox` programming language. For a primer on the language's general syntax and usage, 
refer to  [Crafting Interpreters, Chapter 3](https://www.craftinginterpreters.com/the-lox-language.html).

## Learning objectives

This assignment directly addresses the following course learning objectives:

* Correctly identify and describe the steps in the design and implementation of a programming language
* Using knowledge of the general principles of programming languages, correctly implement a computer program in a heretofore unknown programming language
* Effectively use programming language constructs to design correct, efficient, and well-tested programs in multiple programming languages, including but not limited to Java.

## Using this repository

While the repository's Maven configuration works from the command line, setup included contemplates
the content of the [Getting Started guide](wiki/Getting-Started), which outlines how to set
up the Java SDK and runtime in addition to helpful Maven tools for VSCode.

## Challenges

Unless tagged as optional, all challenges below are required by this week's work.

### Challenge 1

Right now, `Lox` has only 1 `native function`: `clock()` which will come in handy if we want to conduct
interpreter optimization or benchmarking. However, as Nystrom points out, these kinds of functions are
key "when it comes to making your language actually good at doing useful stuff." For example, `Python`
(often called a "batteries included" language) contains a wide variety of native functions to provide
basic user support.

This challenge comes in _two_ parts.

#### Part 1

In this challenge, you'll be asked to provide _two_ native functions that exist in most languages:

|Function |Description |Arity |
|:--------|:-----------|:-----|
|`abs()`  |Returns the absolute value of a number | `1` |
|`pow()`  |Raises a number to a power and returns the result | `2` |

#### Part 2

When operands appear that _aren't_ numbers, we should throw an error. (What is, for example, `abs("FISHY")`?)
Add a method to the interpreter called `checkNumberArgument` (which mimics `checkNumberOperand`) that `throw`s
a `RuntimeError` if _any_ of the arguments passed to built-ins _aren't_ numbers. 

This will take a bit of work in the built-ins themselves and in the correct `visit` function(s).

#### Implementation details and Testing

Implement both parts in:

* `Interpreter.java`

Our test case(s) run using the[`src/test/resources/builtins.lox`](src/test/resources/builtins.lox). You 
do not need to alter these files. They should run as-is.

### Challenge 2

Many languages support anonymous functions, but not `Lox`...yet. To use a familiar example of this from `Python`:
```python
mult = lambda m1, m2: m1 * m2
print(mult(2,2))
```
Given what we know about functions in `Lox`, how can we modify our interpreter to allow anonymous
functions? We need to support the functions written in [`src/test/resources/lambda.lox`](src/test/resources/lambda.lox).

To complete this, you'll need to revise:

* `LoxFunction.java`
* `Parser.java`
* `Interpreter.java`

> Note: When you're ready to tackle this challenge, you'll need to run `GenerateAST` (which lives
> the `tools` Maven project. This will make the correct changes to `Expr.java` and `Stmt.java`; it's
> worth a few moments to see how function expressions and statements change.

There're also questions about this challenge in our [`docs/reflection.md`](docs/reflection.md) file.

### Challenge 3

Nystron proposes the following program:
```
fun scope(a) {
  var a = "local";
}
scope("global");
```
Is this legal in `Lox`? Why or why not? Provide your answer in the [`docs/reflection.md`](docs/reflection.md) file,
keeping in mind the context the book provides us:

> In other words, are a function’s parameters in the same scope as its local variables, or in an outer scope? What does Lox do
> in this case?
