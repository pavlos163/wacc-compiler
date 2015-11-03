parser grammar WaccParser;

options {
  tokenVocab=WaccLexer;
}

program: BEGIN func* stat END;

func: type IDENT LEFT_PAR paramList RIGHT_PAR IS stat END ;

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

charLiter: SINGLE_QUOTE (ESC|.)*? SINGLE_QUOTE;

strLiter: DOUBLE_QUOTE (ESC|.)*? DOUBLE_QUOTE;

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

binaryOper : TIMES | DIVIDED | MOD | PLUS | MINUS | GREATER | GREATER_OR_EQUAL | LESS | LESS_OR_EQUAL | EQUAL | NOT_EQUAL | AND | OR ;

arrayElem: IDENT (LEFT_SQ expr RIGHT_SQ) PLUS;

intSign: PLUS | MINUS ;

intLiter: intSign? DIGIT+ ;

boolLiter: TRUE | FALSE ;

arrayLiter: LEFT_SQ (argList)? RIGHT_SQ ;

pairLiter: NULL ;













