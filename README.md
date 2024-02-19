# The Lox Programming Language: Statements

This branch mirrors content from chapter `8` of _Crafting Interpreters_. Finally, we'll be able
to fully parse statements. Here, we're looking to retread some of the ideas we covered in previous
chapters while considering expression grammar. Having moved from scanning (lexing) to parsing, the
last step in our journey toward code that executes in a recognizable way is _interpreting statements_.

This exercise will use the `Lox` programming language. For a primer on the language's general syntax and usage, 
refer to  [Crafting Interpreters, Chapter 3](https://www.craftinginterpreters.com/the-lox-language.html).

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

To this point, we've run files through the interpreter in order to test our various explorations and
improvements. But did you know that, like `Python`, `Lox` has an interactive mode? (This is commonly
referred to as a `REPL` -- a `R`ead `E`valuate `P`rint `L`oop.)

Our work this week has removed some of its previous flexibility; for example, we can't input single 
expressions and return results anymore! Our job is to restore that functionality so that expressions 
_and_ statements work.

This particular task has several possible paths for implementation:

* try to parse the input as a statement
  * if the parser encounters an error, then try to parse as an expression
  * if that didn't work, it's probably bad syntax

* Add a new object to our parser to control statements entered into the `REPL` (the interactive mode)
  * This might modify at least the following files:
    * `Parser.java`
    * `Interpreter.java`
    * `Main.java`

### Challenge 2

Traditionally, programming languages raise errors when accessing variables which have been _defined_,
but not _assigned_. `Lox`, at least as is designed now, _doesn't_ follow this rule. It's probably better
that it _does_. For example (taken from Nystrom's book):
```
// No initializers.
var a;
var b;

a = "assigned";
print a; // OK, was assigned first.

print b; // Error!
```
Force the interpreter to produce a `RuntimeError` in the above situation. This assignment partly bases its test
case for this challenge on the code above. You can find out more by looking at the code the test case runs:

* [interpreter/src/test/resources/init.lox](interpreter/src/test/resources/init.lox)

### Challenge 3

Consider the following program:
```
var a = 1;
{
  var a = a + 2;
  print a;
}
```
In the [docs/reflection.md](reflection.md) document, answer a few questions, namely:

* What do you think the code does?
* Is that in line with what you think it _should_ do?
* Code the same situation in another language. How does that one differ in form and function?
* What does it _actually_ do?
* Is that the best design approach? Why or why not?
