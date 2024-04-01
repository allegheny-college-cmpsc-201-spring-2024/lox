# The Lox Programming Language: Functions

This branch mirrors content from chapter `13` of _Crafting Interpreters_, featuring supplemental work that supports our OOP mechanic of classes --
an implementation of _inheritance_. With respect to this topic, we'll actually implement _multiple inheritance_: the ability for a class to 
inherit pieces from multiple sibling-level classes such that:
```
class catch < fish, dinner
```
means that our class, `catch`, now has all of the methods and properties of `fish` _and_ `dinner`. Plus, if we get this done, we'll cook some fish.

## Learning objectives

This assignment directly addresses the following course learning objectives:

* Correctly identify and describe the steps in the design and implementation of a programming language
* Effectively use programming language constructs to design correct, efficient, and well-tested programs in multiple programming languages, including but not limited to Java.
* Interpret and use an existing programming language grammar.
* Design, implement, and evaluate a correct scanner and parser for a programming language.
* Using knowledge of the general principles of programming languages, correctly implement a computer program in a heretofore unknown programming language.

## Notes on repository setup

While the repository's Maven configuration works from the command line, setup included contemplates
the content of the [Getting Started guide](wiki/Getting-Started), which outlines how to set
up the Java SDK and runtime in addition to helpful Maven tools for VSCode.

## Challenge

Our challenge is to implement _multiple inheritance_ as outlined above. However, there's a _catch_ (that's a good unanticipated joke): the implementation
is _partially_ done, but it doesn't work. There's a variable (the second inheritance, `dinner`) which is _apparently_ never called -- the product
of our work in a past week to throw an error when unused variables exist.

### Reflecting on this challenge

As written, this challenge synthesizes much of what we've been up to this semester. The questions in our [docs/reflection.md](docs/reflection.md)
file represent this. Answer the questions in this document to finish this challenge.

