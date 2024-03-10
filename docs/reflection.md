# CMPSC 201: Functions

## Anonymous functions

1. Define the term "anonymous function".

Any function that isn't bound the programmatic environment by a name.

2. How do anonymous functions differ from native or native interface functions?

They:

* don't have names and aren't stored using `IDENTIFIER`s
* they're not callable for multiple uses unless embedded in a native interface function

3. Why are these functions useful? 

If we're not calling something more than once and want to make potentially more readble units of code,
they're pretty useful. The three generally-cited reasons:

* no name for a function necessary if not intended for reuse (no need to add objects to namespace)
* inlines can access variables in the parent scope
* code is self-contained and legible; no need to search the file for referents or mix up flow control

## Functional scope

4. Is this program legal? Why or why not?

Nah. We can't shadow like this. The scopes used for arguments/parameters and internal block statements
are the same.

5. What would Python do in this situation? Why do you think Python's designers adopted this approach?

> Some resources that might be helpful:
> * [Python Like You Mean It: Scope](https://www.pythonlikeyoumeanit.com/Module2_EssentialsOfPython/Scope.html)
> * [What are the pros and cons of allowing variable shadowing in the general case?](https://langdev.stackexchange.com/questions/289/what-are-the-pros-and-cons-of-allowing-variable-shadowing-in-the-general-case)

A python version would look like:
```python
def shadow_me(a):
  a = 2
  return a

a(3)
```
The above would print `2`, because the language allows redefinition after declaration due to language semantics.

This is probably due to the 4D chess game that Python's inheritance vehicle plays. Really, my thoughts center on the 
"ask forgiveness, not permission" build ethos of the language. You should be able to do things like this because, while 
they violate general legibility, there's a use case for them that would create too much of a workaround to satisfy making
the end result code much worse. Honestly, it's really just a choice that developer make. They accept all sorts
of trade-offs and if this one doesn't rate, it's simply not important.
