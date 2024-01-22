# The Lox Programming Language: Introduction

This branch mirrors content from chapter `4` of _Crafting Interpreters_, which introduces the tokens
of the Lox language. These are the building blocks of what the language's `Parser` will use; think
of them like words that have meaning or purpose in and of themselves which can make sentences, but
aren't really up for coherent paragraphs yet.

For a primer on the language's general syntax and usage, refer to 
[Crafting Interpreters, Chapter 3](https://www.craftinginterpreters.com/the-lox-language.html).

## Learning objectives

This assignment directly addresses the following course learning objectives:

* Correctly identify and describe the steps in the design and implementation of a programming language
* Interpret and use an existing programming language grammar
* Design, implement, and evaluate a correct scanner and parser for a programming language

## Using this repository

While the repository's Maven configuration works from the command line, setup included contemplates
the content of the [Getting Started guide](wiki/Getting-Started), which outlines how to set
up the Java SDK and runtime in addition to helpful Maven tools for VSCode.

## Challenges

Unless tagged as optional, all challenges below are required by this week's work.

1. Implement multi-line Lox comments such that your program can implement them and pass 
the test case in [interpreter/src/test/resources/test.lox](interpreter/src/test/resources/test.lox).

An example of a multi-line comment in the `C` tradition might look like any of the following:

```
/* This is a comment using multiline, but really isn't */

/*
  This is a comment
  that takes up more
  than one line
*/

/* This is a comment
   using more than one line
   but not using extra spaces
   to delimit the ends */
```

Complete this work in the [`interpreter/src/test/resources/test.lox`](interpreter/src/test/resources/test.lox) 
file. Like last challenge, the file must contain:

* fully functional code that achieves the objective outlined above
  * i.e. it must pass `mvn test`
* at least `1` multi-line comment in Lox multiline comment style

`Note`: you cannot _remove_ or _modify_ existing code; your submission should _add_ code to the file. 

2. Nystrom: "Aside from separating tokens—distinguishing `print foo` from `printfoo`—spaces aren’t used for much in most languages. 
However, in a couple of dark corners, a space does affect how code is parsed in CoffeeScript, Ruby, and the C preprocessor. Where 
and what effect does it have in each of those languages?"
s
For two of the languages above (`CoffeeScript`, `Ruby`): find an example where whitespace matters, and for each language:

* include that example in a Markdown `code fence`
* write a brief explananation of the effect of whitespace in the example

3. Nystrom: "Our scanner here, like most, discards comments and whitespace since those aren’t needed by the parser. Why might you 
want to write a scanner that does not discard those? What would it be useful for?"

Keeping mind the examples you found for the question above, consider the last two parts of `#3` and respond under the appropriate
headings in the reflection document.

Answer both of the above concept-based questions in the [reflection.md](docs/reflection.md) keeping the requirements and tips above
in mind.
