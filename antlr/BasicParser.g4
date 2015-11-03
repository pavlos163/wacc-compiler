parser grammar BasicParser;

options {
  tokenVocab=BasicLexer;
}

program: BEGIN func* stat END;

func: type IDENT LEFT_PAR paramList RIGHT_PAR IS funcStat END ;

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
| NEWPAIR LEFT_PAR expr COMMA expr RIGHT_PAR
| pairElem                                                   
| CALL IDENT LEFT_PAR argList? RIGHT_PAR     
;

argList: expr (COMMA expr)* ;

pairElem: FIRST expr  
| SECOND expr         
;

type: baseType                   
| type LEFT_SQ RIGHT_SQ  
| pairType                       
;

baseType: INT   
| BOOL          
| CHAR          
| STRING        
;

arrayType: type LEFT_SQ RIGHT_SQ;

pairType: PAIR LEFT_PAR pairElemType COMMA pairElemType RIGHT_PAR;

pairElemType: baseType
| type LEFT_SQ RIGHT_SQ
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
| LEFT_PAR expr RIGHT_PAR
;


unaryOper: NOT | NEGATIVE | LEN | ORD | CHR ;

binaryOper : TIMES | DIVIDED | MOD | PLUS | MINUS | GREATER | GREATER_OR_EQUAL | LESS | LESS_OR_EQUAL | EQUAL | NOTEQUAL | AND | OR ;

arrayElem: IDENT (LEFT_SQ expr RIGHT_SQ) PLUS;

intLiter: intSign? DIGIT+ ;

intSign: PLUS | MINUS ;

boolLiter: TRUE | FALSE ;

charLiter: OPEN_SINGLEQUOTE character CLOSE_SINGLEQUOTE ;

strLiter: OPEN_DOUBLEQUOTE character* CLOSE_DOUBLEQUOTE ;

character: ASCII | escapedChar ;

escapedChar: E_ZERO | E_B | E_TAB | E_LF | E_FF | E_CR | E_DOUBLEQUOTE | E_SINGLEQUOTE | ESC_BACKSLASH;

arrayLiter: LEFT_SQ (argList)? RIGHT_SQ ;

pairLiter: NULL ;













