parser grammar WaccParser;

options {
  tokenVocab=WaccLexer;
}

program: BEGIN func* stat END EOF;

func: type IDENT L_PAR paramList R_PAR IS stat END;

paramList: (param (COMMA param)*)?;

param: type IDENT;

stat: 
  SKIP                        # skipStat
| type IDENT ASSIGN assignRHS # assignStat
| assignLHS ASSIGN assignRHS  # assignStat   
| READ assignLHS 			  # readStat	
| FREE expr 			      # freeStat         
| RETURN expr                 # returnStat
| EXIT expr					  # exitStat
| PRINT expr                  # printStat
| PRINTLN expr                # printlnStat
| IF expr THEN stat FI        # ifThenStat 
| IF expr THEN stat ELSE stat FI #ifThenElseStat
| WHILE expr DO stat DONE     # WhileStat
| BEGIN stat END              # BeginStat   
| stat SEMICOLON stat         # statList
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
| arrayType 
| pairType                       
;

baseType: 
  INT   
| BOOL          
| CHAR          
| STRING        
;

arrayType: 
  baseType L_SQ R_SQ
| pairType L_SQ R_SQ
| arrayType L_SQ R_SQ
;

pairType: PAIR L_PAR pairElemType COMMA pairElemType R_PAR;

pairElemType: 
  baseType
| arrayType
| pairType
;

expr: 
  intLiter              #intLiterExpr
| boolLiter             #boolLiterExpr
| CHAR_LITER            #charLiterExpr
| STRING_LITER          #stringLiterExpr
| pairLiter             #pairLiterExpr
| IDENT                 #identExpr
| arrayElem             #arrayElemExpr
| unaryOper expr        #unaryOperExpr
| expr binaryOper expr  #binaryOperExpr
| L_PAR expr R_PAR      #paranthesesExpr
;


unaryOper: NOT | NEGATIVE | LEN | ORD | CHR;

binaryOper : MUL | DIV | MOD | PLUS | MINUS | GREATER | GREATER_OR_EQUAL | LESS | LESS_OR_EQUAL | EQUAL | NOT_EQUAL | AND | OR;

arrayElem: IDENT (L_SQ expr R_SQ) PLUS;

intSign: PLUS | MINUS;

intLiter: intSign? INTEGER;

boolLiter: TRUE | FALSE;

arrayLiter: L_SQ (argList)? R_SQ;

pairLiter: NULL;


