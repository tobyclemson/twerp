Twerp
=====

An experimental language to learn how to implement languages by hand. The language features we are aiming for are:
* Dynamic
* Interpreted
* REPL based


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

Ideas
=====

```
class Thing {
    val property;

    def method = {

    }
}
```

```
val thing = {
  property: "10",
  method: function(first) {

  }
}
```

```
thing.property

thing.method whatever
```
```
thing withAddress "10 Street" andPhoneNumber "312-813-2972"

withAddress_andPhoneNumber(address, phoneNumber) ->
```

```
`by id %id and name %name`
`of %`

workgroupFinder by id "123" and name "Whatever"

workgroupFinder.byIdAndName("123", "Whatever")
```

TODO
====

- Handle missing source file when reading