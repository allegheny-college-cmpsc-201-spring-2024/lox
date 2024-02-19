# CMPSC 201: Parsing Statements

Consider the following `Lox` program:
```
var a = 1;
{
  var a = a + 2;
  print a;
}
```

1. What do you think the code does?

This prints `3`.

2. Is that in line with what you think it _should_ do? Why or why not?

Despite the scoping braces, the variable doesn't double-initialize. It's shadowed by the first instantiation
and adds to itself.

3. Code the same situation in Python. How does that one differ in form and function?
```python
# Option 1
a = 1
def shadow():
    a = 2
    print(a)
# Option 2
a = 2
lambda a: a + 1
a
# Option 3
global a
a = 1
lambda a: a + 1
a
```

It actually strikes me as impossible to write the equivalent in Python as shadowing works differently.

4. What does the code at the top _actually_ do? How did it compare with your `Python` version?

It prints `3`; students probably won't stumble into the correct answer unless they run it.

5. What kind of behavior _should_ the code have?

As the book's author comments, this should probably be an error.
