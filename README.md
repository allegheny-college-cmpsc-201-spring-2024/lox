# The Lox Programming Language: Functions

This branch mirrors content from chapter `11` of _Crafting Interpreters_. This week's work may look a lot like last
week's -- at least in terms of the final outcome. This week we're concerned with functions, but not functions _qua_ functions.
Functions create inner scopes which our work allows, but _doesn't_ enforce. We a problem: scoping favors the global,
even if we have local declarations of variables meant to replace them. On its own, not a big deal. However, it points
out a problem with our implementation thus far: our environments aren't necessarily water-tight. As an ocean-going craft,
we'd sink pretty fast. As Nystrom writes in the chapter underlying this week's work: we're defintely taking on water.

## Learning objectives

This assignment directly addresses the following course learning objectives:

* Correctly identify and describe the steps in the design and implementation of a programming language
* Using knowledge of the general principles of programming languages, correctly implement a computer program in a heretofore unknown programming language
* Effectively use programming language constructs to design correct, efficient, and well-tested programs in multiple programming languages, including but not limited to Java.

## Notes on repository setup

While the repository's Maven configuration works from the command line, setup included contemplates
the content of the [Getting Started guide](wiki/Getting-Started), which outlines how to set
up the Java SDK and runtime in addition to helpful Maven tools for VSCode.

## Challenges

Unless tagged as optional, all challenges below are required by this week's work.

### Challenge 1

While Nystrom's work in the chapter fixes our seaworthiness, there's a feature that would help prove it: implementing 
error-throwing when variables are _declared_, or _assigned_, but _not_ used in a local scope. (For this challenge, you
do not need to consider global variables.) Here, this largely means in the closures made by functions. The `test.lox` file
uses both named functions and anonymous functions to demonstrate. Your program should, ultimately, render the following result:
```
[line 1] Error at 'c': Local variable is never used.
[line 13] Error at 'l': Local variable is never used.
```
As with all great challenges, though, there's a bit of adventure built in.

> Note: All parts of this challenge should be completed in `Resolver.java`, though referencing other files to account for
> changes is probably a _very good idea_. Here, I'd focus on `Expr.java` and `Stmt.java` as guides.

#### Part 1

> Note: It is expected that the program will produce errors at this stage. Your goal is to read them and _fix_ them using
> the considerations below.

Before we can get to the A-Ha! Moment<sup>R</sup> of seeing our local variable resolution work, we have to account for changes
we've made to the language. Namely:

* `break` and (possibly) `continue` statements<sup>`†`</sup>
* `conditional` expressions (i.e., ternary expressions)
* modifications we made to allow anonymous and named functions

These need accounting for in `Resolver.java`, and we've got to wire them in.

`†`: They're handled the same way, so if you completed the `continue` statement, you're not penalized for doing the extra work.
You'll need to write an extra function, but it's really just cooking copypasta.

#### Part 2

> Note: Once we get to this state, the program should run, even if it doesn't provide expected output. There shouldn't be any]
> `Java` or `Lox` errors at this stage.

Once all of our additions and corrections work again, you need to set about accounting for variables. Here, we need to think 
through what it means for a variable to be used. Considering this challenge, a variable can have one of `3` states:

1. Declared
2. Defined
3. Read/Used

At various points of the resolver, we can figure up which one of these we have. Two possible ways to solve them:

1. Using `boolean` values to track whether or not we've achieved a status
2. Using an `enum` (see `FunctionType` in `Resolver.java`) to track same

If we arrive at `endScope` and a variable's status doesn't reflect usage, we know we have an unused variable.

### Challenge 2

In our [`docs/reflection.md`](docs/reflection.md) file, answer the following question:

> Consider the following function:
> ```
> fun l(o,x) {  
>  if (o + x == 0) return;
>  print o + x;
>  l(o - 1, x - 1);
> }
>
> l(10, 10);
>```
>If we argue that we can't _use_ a variable before it's defined, why do this work?

### Challenge 3

In our [`docs/reflection.md`](docs/reflection.md) file, answer the following question:

> We know that the following `Lox` code is OK:
> ```
> var a = "outer";
> {
>   var a = 4;
>   print a;
> }
> print a;
> ```
>However, this is _not_:
>```
> var a = "outer";
> {
>  var a = a;
> }
> ```
> The answer to this question comes in `3` parts:
> 
> - Why is this illegal in `Lox`?
> - Does `Java` support this? How does the language design enable or prohibit it?
> - Likewise, does `Python` support this? In what ways does language design enable or prohibit it?
