# The Lox Programming Language

This repository contains an implementation of the Lox programming language interpreter
taken directly from the book [_Crafting Interpreters_](https://www.craftinginterpreters.com/)
by Robert Nystrom. It uses [Apache Maven](https://maven.apache.org/), Apache's build automation
tool commonly used with Java. Instructions for using this repository exist in the
[repository wiki](wiki/).

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

Each branch's `README` uses the `Challenges` section concluding each chapter as a summative exploration
of students' grasp of concepts introduced and reviewed in the chapter. Typically, at least once students
finish the chapter on `parsing`, this takes the shape of requiring students to implement additional 
language features. These are included in the grader via Maven test cases.

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
