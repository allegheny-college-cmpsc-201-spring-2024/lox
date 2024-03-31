# CMPSC 201: Implementing Classes

1. Describe the grammar of the `import` statement as implemented.
```
import "fish";
```

Here, we can break the statement down along the lines of the `print` statement: `import → "import" expression;`. This looks an awful lot like
`printStmt → "print" expression ";" ;`. The real difference is that the expression evaluates to a `LITERAL` and the `LITERAL` doesn't represent
a value for the program: it represents a file path from whcih to load the file.

One additional piece: we techncially _also_ elaborate `declaration`s to include a specific `import` declaration to handle what we expect from 
the declaration, namely that the token following the keyword has to be a `STRING`. While the grammar implies that it can be _any_ expression,
and this could lead to interesting "calculated `import`s", we're really looking for a string, and string only.

2. In the table below, add the files requiring changes and add a brief description of those changes.

(Professor's note: this is probably incomplete.)

|File |Change summary |
|:----|:--------------|
|`TokenType.java`|Add `IMPORT` token |
|`Scanner.java`|"Lex" the `IMPORT` token |
|`Parser.java`|Create the `import` declaration type |
|`Resolver.java`|Do nothing, really. We have to `@Override` the abstract class though |
|`Interpreter.java`|It has to work. Here we load the file and send it back through `Main.runFile()`, essentially |

3. Describe your overall approach to implementing the `import` functionality. What could you reuse? What did you have to write yourself?

In short, we leverage the `Visitor` pattern and established expressions, though we needed to include the `IMPORT` keyword and token in order
for the language to create the separate cases that the `Visitor` requires. Fun enough, sending the file back through `Main.runFile()` actually
works. I was surprised at that, but no need to rewrite the file load/parse/et al. when it already exists and works just fine.

4. As mentioned in the `README`, this isn't precisely OOP implementation, but it does something for our language. Why include this in `Lox`?

Separation of concerns, largely. It's not a functional difference, but allows us to organize in a sane(r) way, maybe. `Python`-style `import`s
(i.e., `from {x} import {y}`) would expose the file contents of the imported file more and make files easier to read (e.g., not needing to know
all of what `fish.lox` contains, for example). We also didn't go all the way to making more helpful error messages when something is called
from a file, but doesn't exist. We rely on the pre-written errors for that.

5. What is the purpose of a `getter` method? How are they useful or significant?

Organization is one answer, ease of use is another. Where needing to provision additional variables in a scoped environmet isn't needed, why do it
if the outcome of the function is calculated on set variables (i.e., is a read-only calculation)?
