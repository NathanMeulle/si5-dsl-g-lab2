grammar CompetitionML;


/******************
 ** Parser rules **
 ******************/

root            :   discipline classement EOF;
discipline     :   'discipline' name=IDENTIFIER type=DISCIPLINE;

classement : 'classement' name=IDENTIFIER declaration;
declaration : (disposition | tableau) (disposition | tableau);
disposition : 'disposition' padding;
padding : 'padding' value=INTEGER 'px';
tableau: 'tableau' name=IDENTIFIER 'top' max=INTEGER tableau_def;
tableau_def:  columns;
columns: '[' champs ('|' champs)* ']' ;
champs : name=WORD;


/*****************
 ** Lexer rules **
 *****************/

IDENTIFIER :  QUOTE WORD+ QUOTE ;
DISCIPLINE :   'championnat' | 'tournoi';
/*************
 ** Helpers **
 *************/
INTEGER             : [0-9]+;
fragment LOWERCASE  : [a-z];                                 // abstract rule, does not really exists
fragment UPPERCASE  : [A-Z];
WORD     : LOWERCASE (LOWERCASE|UPPERCASE)+;
fragment QUOTE      : '"';
NEWLINE             : ('\r'? '\n' | '\r')+      -> skip;
WS                  : ((' ' | '\t')+)           -> skip;     // who cares about whitespaces?
COMMENT             : '#' ~( '\r' | '\n' )*     -> skip;     // Single line comments, starting with a #
