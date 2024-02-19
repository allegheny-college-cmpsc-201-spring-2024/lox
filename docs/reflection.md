# CMPSC 201: Evaluating Expressions

1. Describe Lox's current implementation of the divide-by-zero operation. Why does this happen?

> Hint: This may require some looking-up/reading.

Java implements three special numbers for this case: `Double.POSITIVE_INFINITY`, `Double.NEGATIVE_INFINITY`,
`Double.NaN`. This is particular to scenarios which involve floating-point numbers. As programmed, `Lox`
promotes every number to a `double`, which means that we force the special case where Java's programmed
values produce the pre-exception'd `Infinity`.

2. Identify and describe at least two additional unique ways that other languages implement divide-by-zero.

**INTERCAL** (that old dinosaur) returns `#0`. ([This document on INTERCAL](https://www.muppetlabs.com/~breadbox/intercal-man/s01.html#1) is a fun read.)

**PHP** fully allows you to do it -- as it's interpreted -- and many a production enviroment has falled prey.

3. How do language design principles affect or influence the above `3` ways of implementing the calculation?

**INTERCAL**: Frankly, the language is a joke. As such, it was supposed to do things _opposite_ what other languages did. Others
throw an error or cause program failure? Not INTERCAL. 

**PHP**: As an interpreted language, it's really impossible to get in front of the error/exception when it pops up. 

4. Is there any reason to consider _not_ throwing an error if we encounter an instance of divide-by-zero? If so, what is it?

The case of `PHP` is probably the best example here. You get _warnings_, but not _errors_. Were we to throw an error instead
of a softer-edged warning, it's possible that pages on the internet would cease to function. While there's a clearly identifiable cause
(as always, see: logging), the always-uptime/availability idea of hte internet would probably break. Of course, your feature
might fail if you hit an integral `#DIV/0` error (word up to Excel), but the folks behind PHP will just let you look bad
in public.
