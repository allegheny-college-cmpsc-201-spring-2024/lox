# CMPSC 201: Inheritance

1. Describe the process you developed for correcting the issue and successfully implementing multiple inheritance.

So far, the way I see to do this is to change the grammar to allow `List<Expr.Variable>` in place of the singular
`Expr.Variable` before, add them to independent scopes and resolve them that way. There's something missing here 
for students to resolve in that the first `fish` inheritance is OK, but `dinner` doesn't work out quite right.

2. Are there any pitfalls that implementing this feature creates? If so, what are they? If not, why does it make sense?

There's a really confusing hierarchy of `Expr.Super`. It's not clear at all how to implement or control superclasses,
and I don't see a way to do it that doesn't prefix the variables with some relevant string. Looking at `Expr.This` might
solve it, but there's still a really messy conflict between scopes. `Trait`s also share the problem of using classes
that have the same name. Technically, they're distinct. And, it makes sense to throw an error when there's poor design
at play. However, it doesn't help the resolution problem.
