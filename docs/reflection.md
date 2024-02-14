# CMPSC 201: Parsing Expressions

1. Write the `comma` production rule below.
```
comma      → conditional ( "," conditional )* ;
```

2. Write the `ternary` production rule.
```
conditional → equality ( "?" expression ":" conditional )? ;
```

3. Add the `comma` and `ternary` production rules to the correct spot in the processing hierarcy below:
```
expression     → assignment ;
assignment     → IDENTIFIER "=" assignment
               | comma ;
comma          → conditional ( "," conditional )* ;
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
