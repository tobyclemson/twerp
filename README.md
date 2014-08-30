Twerp
=====

An experimental language to learn how to implement languages by hand.

Example
=======

```
1+1
=> 2
```

Questions
=========

- Is it the visitor's responsibility to validate the semantic correctness of the abstract syntax tree provided by the
  parser or should the interpreter do that?
    - Probably the interpreter
- Is the visitor itself going to be the interpreter? Or should the visitor create an intermediate representation that
  the interpreter uses to generate the java code or byte code?
    - The benefit of separate visitor and interpreter is that if we choose to write our own lexer and parser, we will
      already be decoupled from ANTLR.