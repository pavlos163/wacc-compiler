parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}

program: BEGIN func* stat END;

func: type IDENT OPEN_PARENTHESES paramList CLOSE_PARENTHESES IS funcStat END ;

paramList: (param (COMMA param)*)? ;

param: type IDENT ;

stat: SKIP                       
| type IDENT EQUAL assignRHS	
| assignLHS EQUAL assignRHS      
| READ assignLHS                 
| FREE expr                     
| RETURN expr                   
| EXIT expr                      
| PRINT expr                    
| PRINTLN expr                  
| IF expr THEN stat ELSE stat FI 
| WHILE expr DO stat DONE        
| BEGIN stat END                 
| stat SEMICOLON stat            
;

assignLHS: IDENT 
| arrayElem      
| pairElem       
;

assignRHS: expr                                             
| arrayLiter                                                 
| NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES 
| pairElem                                                   
| CALL IDENT OPEN_PARENTHESES argList? CLOSE_PARENTHESES     
;

argList: expr (COMMA expr)* ;

pairElem: FIRST expr  
| SECOND expr         
;

type: baseType                   
| type OPEN_SQUARE CLOSE_SQUARE  
| pairType                       
;

baseType: INT   
| BOOL          
| CHAR          
| STRING        
;

arrayType: type OPEN_SQUARE CLOSE_SQUARE;

pairType: PAIR OPEN_PARENTHESES pairElemType COMMA pairElemType CLOSE_PARENTHESES;

pairElemType: baseType
| type OPEN_SQUARE CLOSE_SQUARE
| PAIR
;

expr: intLiter
| boolLiter
| charLiter
| strLiter
| pairLiter
| IDENT
| arrayElem
| unaryOper expr
| expr binaryOper expr
| OPEN_PARENTHESES expr CLOSE_PARENTHESES
;


unaryOper: NOT | MINUS | LEN | ORD | CHR ;

binaryOper : MULT | DIV | MOD | PLUS | MINUS | MORETHAN | MOREEQUAL | LESSTHAN | LESSEQUAL | ISEQUAL | NOTEQUAL | AND | OR ;

arrayElem: IDENT (OPEN_SQUARE expr CLOSE_SQUARE) PLUS;

intLiter: intSign? INTEGER ;

digit: 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 ;

intSign: PLUS | MINUS ;

boolLiter: TRUE | FALSE ;

charLiter: OPEN_SINGLEQUOTE character CLOSE_SINGLEQUOTE ;

strLiter: OPEN_DOUBLEQUOTE character* CLOSE_DOUBLEQUOTE ;

character: ASCII | escapedChar ;

escapedChar: E_ZERO | E_B | E_TAB | E_LF | E_FF | E_CR | E_DOUBLEQUOTE | E_SINGLEQUOTE | ESC_BACKSLASH;

arrayLiter: OPEN_SQUARE (argList)? CLOSE_SQUARE ;

pairLiter: NULL ;

comment: HASH character* END;












