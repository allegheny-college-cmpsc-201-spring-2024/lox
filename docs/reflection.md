# CMPSC 201: Parsing Statements

1. What is the name of the special optimization described in the `README`?

Tail call recursion. Essentially, this describes a function that is recusive, but
calls recursion at the end of the function body in order to prevent adding additional
unnecessary stack frames (i.e., it doesn't need information from a previous recursion
to perform the next one).

2. Given your knowledge of `Lox` functions, what would an implementation look like?

> HINT: an example of counting from `1` to `100` would be acceptable, using a `print`
> statement to display the outcome.

```lox
fun forStep(i) {
  print i;
  if (i < 99) forStep(i + 1);
}
```

3. What other languages use this type of function optimization? Why?

The best example of this is `scheme`.

4. Provide an example from the language cited above.

```scheme
(define (factorial n)
  (fact-iter 1 n))
(define (fact-iter product n)
  (if (= n 0)
      product
      (fact-iter (* product n)
                 (- n 1))))
```

5. Re-order the grammar below to reflect your revised grammar precedence.

```
expression     → assignment ;
assignment     → IDENTIFIER "=" assignment
               | conditional ;
comma          → logical_or ( "," logical_or )* ;
logical_or     → logic_and ( "or" logic_and )* ;
logical_and    → conditional ("and" conditional)*;
conditional    → equality ( "?" expression ":" conditional )? ;
equality       → comparison ( ( "!=" | "==" ) comparison )* ;
comparison     → term ( ( ">" | ">=" | "<" | "<=" ) term )* ;
term           → factor ( ( "-" | "+" ) factor )* ;
factor         → unary ( ( "/" | "*" ) unary )* ;
unary          → ( "!" | "-" ) unary
               | primary ;
primary        → NUMBER | STRING | "true" | "false" | "nil"
               | "(" expression ")" ;
```
