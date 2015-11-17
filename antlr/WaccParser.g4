parser grammar WaccParser;

options {
  tokenVocab=WaccLexer;
}

program: BEGIN func* stat END EOF;

func: type IDENT L_PAR paramList R_PAR IS stat END;

paramList: (param (COMMA param)*)?;

param: type IDENT;

stat: 
  SKIP                           # skipStat
| type IDENT ASSIGN assignRHS    # assignStat
| assignLHS ASSIGN assignRHS     # assignStat   
| READ assignLHS 			     # readStat	
| FREE expr 			         # freeStat         
| RETURN expr                    # returnStat
| EXIT expr					     # exitStat
| PRINT expr                     # printStat
| PRINTLN expr                   # printlnStat
| IF expr THEN stat ELSE stat FI #ifThenElseStat
| WHILE expr DO stat DONE        # WhileStat
| BEGIN stat END                 # BeginStat   
| stat SEMICOLON stat            # statList
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

pairElemType: 
  baseType
| arrayType
| PAIR
;

pairType: PAIR L_PAR pairElemType COMMA pairElemType R_PAR;

expr: 
  intLiter                     #intLiterExpr
| boolLiter                    #boolLiterExpr
| CHAR_LITER                   #charLiterExpr
| STRING_LITER                 #stringLiterExpr
| pairLiter                    #pairLiterExpr
| IDENT                        #identExpr
| arrayElem                    #arrayElemExpr
| unaryOper expr               #unaryOperExpr
| expr MUL expr                #binaryOperExpr
| expr DIV expr                #binaryOperExpr
| expr MOD expr                #binaryOperExpr
| expr PLUS expr               #binaryOperExpr
| expr MINUS expr              #binaryOperExpr
| expr GREATER expr            #binaryOperExpr
| expr GREATER_OR_EQUAL expr   #binaryOperExpr
| expr LESS expr               #binaryOperExpr
| expr LESS_OR_EQUAL expr      #binaryOperExpr
| expr EQUAL expr              #binaryOperExpr
| expr NOT_EQUAL expr          #binaryOperExpr
| expr AND expr                #binaryOperExpr
| expr OR expr                 #binaryOperExpr
| L_PAR expr R_PAR             #paranthesesExpr
;

intLiter: intSign? INTEGER;

intSign: PLUS | MINUS;

unaryOper: NOT | MINUS | LEN | ORD | CHR;

arrayElem: IDENT (L_SQ expr R_SQ)+;

boolLiter: TRUE | FALSE;

arrayLiter: L_SQ (argList)? R_SQ;

pairLiter: NULL;


