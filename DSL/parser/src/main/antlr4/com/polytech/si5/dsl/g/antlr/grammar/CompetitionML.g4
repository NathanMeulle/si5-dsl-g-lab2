grammar CompetitionML;


/******************
 ** Parser rules **
 ******************/

root            :   discipline EOF;
discipline     :   'discipline' name=IDENTIFIER type=DISCIPLINE_TYPE;

/*****************
 ** Lexer rules **
 *****************/

IDENTIFIER      :   (LETTER)+ | QUOTE (LETTER|' ')+ QUOTE;
DISCIPLINE_TYPE :   'championnat' | 'tournoi';

/*************
 ** Helpers **
 *************/

fragment LOWERCASE  : [a-z];                                 // abstract rule, does not really exists
fragment UPPERCASE  : [A-Z];
fragment LETTER     : LOWERCASE | UPPERCASE;
fragment QUOTE      : '"';
NEWLINE             : ('\r'? '\n' | '\r')+      -> skip;
WS                  : ((' ' | '\t')+)           -> skip;     // who cares about whitespaces?
COMMENT             : '#' ~( '\r' | '\n' )*     -> skip;     // Single line comments, starting with a #
