# The Lox Programming Language: Functions

This branch mirrors content from chapter `12` of _Crafting Interpreters_, in which we give our implementation of the `Lox` language
object-oriented programming (OOP) features. Here, we add:

* `class`es
* `getter` methods
* `import` statements

Plus, we get to go fishing.

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

## Challenges

Unless tagged as optional, all challenges below are required by this week's work.

### Challenge 1

Though not necessarily the province of OOP, `import` statements allow us to organize our programs by the kinds of objects or
operations comprising our programmatic task. In this instance, we'll `import` the `fish.lox` file (located at
[interpreter/src/test/resources/fish.lox](interpreter/src/test/resources/fish.lox). The code is already written for us and
the correct `Lox` statements implemented in our traditional `test.lox` file. To accomplish this task, we don't edit those
files but, instead, provide support for our defintion of a `Lox` import statement: `import → IDENTIFIER` which translates to
something very `print` statement -like: `import "fish"`<sup>†</sup>.

This task contemplates a range of skills that you've acquired across the semester, including lexical and syntactic analysis,
resolution, and interpretation. The range of files you'll need to work in is comprehensive of this task.

<sup>†</sup> This assumes that all valid `Lox` importables are `.lox` files

#### Reflecting on this challenge

As written, this challenge synthesizes much of what we've been up to this semester. The questions in our [docs/reflection.md](docs/reflection.md)
file represent this. Answer the questions in this document to finish this challenge.

### Challenge 2

In many languages, there exists a type of method known as a `getter`: a _read-only_ class-bound method that returns values or
calculations including values. For example, Nystrom uses circle area as one instance where this is useful:
```lox
class Circle {
  init(radius) {
    this.radius = radius;
  }

  // area is a "getter" method
  area {
    return 3.141592653 * this.radius * this.radius;
  }
}

var circle = Circle(4);
print circle.area;
```
These methods are _like_ other methods in that they have:

* a name
* their own local scopes

However, they are _different_ in that they _do not process a list of parameters_ partly because they _don't have_ parameters. This
challenge revolves around making this possible by altering the various levels of parsing, resolving, and interpreting function
statements.

Given that these bound methods are also _callables_ (or, as Nystrom calls them in program and text: "get expressions"), we need to 
force these `get`s to (if `function` calls) operate a lot like merely accessing a property -- not like calling a function.
