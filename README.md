# The Lox Programming Language

This repository contains an implementation of the Lox programming language interpreter
taken directly from the book [_Crafting Interpreters_](https://www.craftinginterpreters.com/)
by Robert Nystrom. It uses [Apache Maven](https://maven.apache.org/), Apache's build automation
tool commonly used with Java. Instructions for using this repository exist in the
[repository wiki](../../wiki/).

## Programmatic content

Intended as the main educational tool for `CMPSC 201: Programming Languages` at Allegheny College,
this repository adopts a branched structureeach chapter, and the name and semantic versioning for each 
build represents the chapter from which the code was taken. Branches contain all code from preceding
chapters except where the current chapter modifies it to introduce new features or remedy issues 
created in previous exercises.

## Educational content

Given that this repository accompanies the pedagogical Lox language _and_ textbook introducing that 
language, each branch contains educational content to help learners demonstrate their understanding
and intuition about concepts and structures. This content comes in two flavors.

### Challenges

Each branch's `README` uses the `Challenges` section concluding each chapter of _Crafting Interpreters_ 
as a summative exploration of students' grasp of concepts introduced and reviewed in the chapter. Typically, 
at least once students finish the chapter on `parsing`, this takes the shape of requiring students to implement 
additional language features. These are included in the grader via Maven test cases. In some cases, additional
challenges have been added to create a deeper learning experience for students.

### Reflective writing

This repository caters to a course held in the 
[Department of Computer and Information Science (CIS)](https://www.cis.allegheny.edu/) at Allegheny College.
Department pedagogy includes student reflective writing which explores concepts qualitatively, often asking
students to engage in speculation, exercise their intuition, or write about their understandings or
experiences engaging with a topic. These documents are included in the `docs` folder in each branch and 
are also included in the grader's setup, namely by guaranteeing that questions are finished.

## Notes on software supporting this repository

### GatorGrade

[GatorGrade](https://github.com/GatorEducator/gatorgrade) is a command-line automated grading system (AGS) developed
by Allegheny College faculty and students. For more information on installing and using the system, visit
the link provided.

All build in this repository, however, automatically installs and configures GatorGrade in its GitHub Actions
workflows. Educators and their students are invited to install the software on their machines to gain the 
full range of benefits associated withe just-in-time (JIT) style of feedback it provides via specifications
grading practices.

### Wizard

[Wizard](https://github.com/term-world/wizard) provides actionable issues to students based on the outcome of 
their GatorGrader reports via the GitHub issue tracker. When students `push` content to their GitHub repo remotes,
the tool uses the results of GatorGrade to post an issue detailing all of the objectives they have completed and
those that they have not yet achieved in the form of issue-based tasks.

### Arborist

[Arborist](https://github.com/term-world/arborist) protects branches from accidental or haphazard `merge`s. Used
here to protect the `main` and `feedback` (created by GitHub Classroom) branches. Sometimes students merge these
with other branches and create very tangled webs. The Arborist prevents this.

## Notes on repository setup

The repository's Maven configuration works from the command line, setup included contemplates
the content of the [Getting Started guide](wiki/Getting-Started), which outlines how to set
up the Java SDK and runtime in addition to helpful Maven tools for VSCode. In addition, this
repository's Wiki outlines some of the common Apache Maven lifecycle commands used in compiling,
testing and executing the code for the book, outlined in the 
[Compiling and Testing Java Programs](wiki/Compiling-and-Testing-Java-Programs) entry.

## Completion log

|Unit |Unit name |Build status |Chapters in branch |Due Date |
|:----|:---------|:------------|:--------|:--------|
|1    |Introduction to `Lox` |[![Gatorgrader](../../actions/workflows/main.yml/badge.svg?branch=1-lox-introduction)](../../actions/workflows/main.yml) |[Chapters 1-3](../../tree/1-lox-introduction) | 29 January |
|2    |Scanning |[![Gatorgrader](../../actions/workflows/main.yml/badge.svg?branch=2-scanning)](../../actions/workflows/main.yml) |[Chapter 4](../../tree/2-scanning) | 5 February |
|3    |Representing Code |[![Gatorgrader](../../actions/workflows/main.yml/badge.svg?branch=3-representing-code)](../../actions/workflows/main.yml) |[Chapter 5](../../tree/3-representing-code) | 12 February |
|4    |Parsing Expressions |[![Gatorgrader](../../actions/workflows/main.yml/badge.svg?branch=4-parsing-expressions)](../../actions/workflows/main.yml) |[Chapter 6](../../tree/4-parsing-expressions) | 19 February |
|5    |Evaluating Expressions |[![Gatorgrader](../../actions/workflows/main.yml/badge.svg?branch=5-evaluating-expressions)](../../actions/workflows/main.yml) |[Chapter 7](../../tree/5-evaluating-expressions) | 19 February |
|6    |Statements and State |[![Gatorgrader](../../actions/workflows/main.yml/badge.svg?branch=6-statements-state)](../../actions/workflows/main.yml) |[Chapter 8](../../tree/6-statements-state) | 26 February |
|7    |Control Flow |[![Gatorgrader](../../actions/workflows/main.yml/badge.svg?branch=7-control-flow)](../../actions/workflows/main.yml) |[Chapter 9](../../tree/7-control-flow) | 11 March | 
|8    |Functions |[![Gatorgrader](../../actions/workflows/main.yml/badge.svg?branch=8-functions)](../../actions/workflows/main.yml) |[Chapter 10](../../tree/8-functions) | 18 March |
|9    |Resolving and Binding |[![Gatorgrader](../../actions/workflows/main.yml/badge.svg?branch=9-resolving-binding)](../../actions/workflows/main.yml) |[Chapter 11](../../tree/9-resolving-binding) | 25 March |
|10    |Classes |[![Gatorgrader](../../actions/workflows/main.yml/badge.svg?branch=10-representing-code)](../../actions/workflows/main.yml) |[Chapter 12](../../tree/10-classes) | 1 April (that's no joke) |
|11    |Inheritance |[![Gatorgrader](../../actions/workflows/main.yml/badge.svg?branch=11-inheritance)](../../actions/workflows/main.yml) |[Chapter 13](../../tree/13-inheritance) | 8 April |
