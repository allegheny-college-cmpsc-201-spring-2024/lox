# CMPSC 201: Resolving and Binding Scopes

1. Consider the following function:
```
fun l(o,x) {  
  if (o + x == 0) return;
  print o + x;
  l(o - 1, x - 1);
}

l(10, 10);
```
If we argue that we can't _use_ a variable before it's defined, why do this work?

Recursion is possible because by the time `fun l` is bound to the program (i.e. is in the environment), the `block` statement can refer
to it for that reason. The line `l(10,10)` demonstrates this because it can call the function by name.

2. We know that the following `Lox` code is OK:
```
var a = "outer";
{
  var a = 4;
  print a;
}
print a;
```
However, this is _not_:
```
var a = "outer";
{
  var a = a;
}
```
The answer to this question comes in `3` parts:

- Why is this illegal in `Lox`?
- Does `Java` support this? How does the language design enable or prohibit it?
- Likewise, does `Python` support this? In what ways does language design enable or prohibit it?

`Lox` relies on definite scopes. Here, there are global and local declarations -- which is fine, generally. However, because binding
the value relies on local scope, we can't use the word in the definition, so to speak; there's no value for `a` to refer to outside
of its scope because it has been replaced locally.

Java doesn't support this because everything is automatically scoped to _some_ structure. There's no way to instantiate anything
outside of a scope and this wheel-within-a-wheel approach prevents this behavior by design.

Python is largely consistent, though we can break the rules a bit. Consider:
```python
a = 4

def f():
  a = a

f()
```
For the same reason our `Lox` code fails, this one fails. But, let's punch a hole through the universe:
```python
a = 4

def f():
  global a
  a = a

f()
```
This works. It's nonsense, but that's OK because it proves our point: the `global` keyword allows us to _reach beyond_ the local
scope of `f()` to connect the two levels of the program. While I may dislike this, it has its uses though, in the hands of nearly
any programmer, absolute power corrupts absolutely.
