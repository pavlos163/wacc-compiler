parser grammar WaccParser;

options {
  tokenVocab=WaccLexer;
}

program: (IMPORT FILE SEMICOLON)*? BEGIN func* stat END EOF;

func: type IDENT L_PAR paramList R_PAR IS stat END;

paramList: (param (COMMA param)*)?;

param: type IDENT;

stat: 
  SKIP                       
| type IDENT ASSIGN assignRHS	
| assignLHS ASSIGN assignRHS      
| READ assignLHS                 
| FREE expr                     
| RETURN expr                   
| EXIT expr                      
| PRINT expr                    
| PRINTLN expr 
| IF expr THEN stat FI 
| IF expr THEN stat ELSE stat FI 
| WHILE expr DO stat DONE        
| BEGIN stat END                 
| stat SEMICOLON stat
;

assignLHS: 
  IDENT 
| arrayElem      
| pairElem       
;

assignRHS: 
  expr                                             
| arrayLiter                                                 
| NEWPAIR L_PAR expr COMMA expr R_PAR
| pairElem                                                   
| CALL IDENT L_PAR argList? R_PAR     
;

argList: expr (COMMA expr)*;

pairElem: 
  FIRST expr  
| SECOND expr         
;

type: 
  baseType                   
| type L_SQ R_SQ  
| pairType                       
;

baseType: 
  INT   
| BOOL          
| CHAR          
| STRING        
;

arrayType: type L_SQ R_SQ;

pairType: PAIR L_PAR pairElemType COMMA pairElemType R_PAR;

pairElemType: 
  baseType
| type L_SQ R_SQ
| PAIR
;

expr: 
  intLiter
| boolLiter
| CHAR_LITER
| STRING_LITER
| pairLiter
| IDENT
| arrayElem
| unaryOper expr
| expr binaryOper expr
| L_PAR expr R_PAR
;


unaryOper: NOT | NEGATIVE | LEN | ORD | CHR;

binaryOper : MUL | DIV | MOD | PLUS | MINUS | GREATER | GREATER_OR_EQUAL | LESS | LESS_OR_EQUAL | EQUAL | NOT_EQUAL | AND | OR;

arrayElem: IDENT (L_SQ expr R_SQ) PLUS;

intSign: PLUS | MINUS;

intLiter: INTEGER;

boolLiter: TRUE | FALSE;

arrayLiter: L_SQ (argList)? R_SQ;

pairLiter: NULL;


