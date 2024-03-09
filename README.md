# The Lox Programming Language: Iteration and Flow Control

This branch mirrors content from chapter `9` of _Crafting Interpreters_. Our work on implementing
statements and declarations in last week's lab goes a step further as we explore how iteration 
and other control of flow operations occur in `Lox`. Here, we mean `if`, `for`, and `while`
statements. These structures embed logical statements such as those arbitrated by `and` and `or`
operators. 

Our challenges explore integrating previous functionality (`ternary` statements) into the new grammar 
and how to incorporate new functionality such as `break` and `continue`, which also affect the flow 
control of a program. To complete this work, you've been given a novel program written in the `Lox` language, 
located in [`interpreter/test/resources/test.lox`](interpreter/test/resources/test.lox).

You will need to remove comments marked by `TODO`s in order to expose some of the functionality to
write your solutions.

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

When iterating, there are times that we want to jump of out a loop when a certain combination of
conditions occurs that are _not_ the sentinel condition (e.g., breaking out of a forced infinite
loop). In other instances, we want to skip the product of an iteration and start with the next
iteration without bothering with the functionality in the `for` or `while` statement's body.

Implement the `break` keyword to bail on loops instantly, a functionality like that of Python's
`break`.

> Hint: you'll want to implement `break` first, as the solution shows you the various areas
> of the files to work in.

To complete this work, you'll largely be in:

* `Parser.java`
* `Scanner.java`
* `Interpreter.java`
* `TokenType.java`

There are some supporting functions already created for you. However, they are not necessarily
populated with helpful code.

#### Extra 

It's also possible to implement the `continue` keyword. For the chance to earn an entire complete branch,
implement the `continue` keyword. Discuss with the instructor so that you can get the additional test
to verify.

### Challenge 2

In a previous week, we implemented other pieces of an advanced grammar. Primarily, we're concerned with the
`conditional` (i.e. `ternary`) rule. However, it's not accounted for in the current grammar. Provide 
an implementation of the `conditional` structure such that it satisfies the `TODO`'d-out functionality in 
`test.lox`.

To complete this work, work in:

* `Parser.java`
* `Interpreter.java`

### Challenge 3

Here, we see iteration in its plainest form. As we prepare for next chapter's work on functions, there's yet
another way that we can integrate recursion into our programs using functions. You're probably aware of versions
of this method of looping (i.e. it has a special name, starting with the letter `r`). However, there's a key
difference between `for` loops and what is described above.

Versions of this method enable an optimization that allows for deep (i.e. long) loops. What is the name of this
specific type of iteration? What is an example of a language that implements this as its primary (or only) method
of iteration?

> Hint: we've golfed using this language.

Discuss this using the prompts in our [`docs/reflection.md`](docs/reflection.md) file.
