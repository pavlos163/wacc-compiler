lexer grammar WaccLexer;

// Unary Operators
NOT: '!';
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

// Brackets
OPEN_PARENTHESES : '(' ;
CLOSE_PARENTHESES : ')' ;

//numbers
fragment DIGIT : '0'..'9' ; 

INTEGER: DIGIT+ ;





