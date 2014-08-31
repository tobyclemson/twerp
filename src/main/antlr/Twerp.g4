grammar Twerp;

// parsing

expression: DIGIT BINARYOP DIGIT;

// lexing

DIGIT: [0-9]+;
BINARYOP: ('+'|'-');