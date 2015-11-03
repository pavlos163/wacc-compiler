lexer grammar WaccLexer;

IMPORT: 'import';
FILE: [_a-zA-z0-9]* '.wacc';

SEMICOLON: ';';

// Program
BEGIN: 'begin';
IS: 'is';
END: 'end';

// Statements
SKIP: 'skip';
READ: 'read';
FREE: 'free';
RETURN: 'return';
EXIT: 'exit';
PRINT: 'print';
PRINTLN: 'println';
IF: 'if';
THEN: 'then';
ELSE: 'else';
FI: 'fi';
WHILE: 'while';
DO: 'do';
DONE: 'done';

// Assign RHS
NEWPAIR: 'newpair';
CALL: 'call';

// Pair Element
FST: 'fst';
SND: 'snd';

// Base Types
INT: 'int';
BOOL: 'bool';
CHAR: 'char';
STRING: 'string';
PAIR: 'pair';

// Brackets
LEFT_PAR: '(';
RIGHT_PAR: ')';
LEFT_SQ: '[';
RIGHT_SQ: ']';
COMMA: ',';
ASSIGNMENT: '=';

// Unary Operators
NOT: '!';
NEGATIVE: '-';
LEN: 'len';
ORD: 'ord';
CHR: 'chr';

// Binary Operators
TIMES: '*';
DIVIDED: '/';
MOD: '%';
PLUS: '+';
MINUS: '-';
GREATER: '>';
GREATER_OR_EQUAL: '>=';
LESS: '<';
LESS_OR_EQUAL: '<=';
EQUAL: '==';
AND: '&&';
OR: '||';

IDENT: [_a-zA-Z][_a-zA-Z0-9]*;

// Numbers
fragment DIGIT: '0'..'9';

// Integer Literals
INTEGER: ('+' | '-')? DIGIT+;

// Escaped Characters
fragment ESC: '\\"' | '\\\\';

// String Literals
STRING_LITER: '"' (ESC|.)*? '"';

// Char Literals
CHAR_LITER: '\'' (ESC|.)*? '\'';

// Bool Values
TRUE: 'true';
FALSE: 'false';

// Null
NULL: 'null';

// Comment and whitespace
COMMENT: '#' .*? '\n' -> skip;
WHITESPACE: [ \n\t\r] -> skip;
