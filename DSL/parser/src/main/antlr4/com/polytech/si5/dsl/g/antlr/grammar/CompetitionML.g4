grammar CompetitionML;


/******************
 ** Parser rules **
 ******************/

root           :   app discipline classement EOF;
app            :   'app' color=COLOR_HEXA (logo=LOGO)*;
discipline     :   'discipline' name=IDENTIFIER type=DISCIPLINE ;

classement : 'classement' name=IDENTIFIER titre? classement_options* tableau;
classement_options : (disposition | padding);
titre: 'titre' styles;
disposition : 'disposition' padding;
padding : 'padding' value=INTEGER 'px';

/* Tableau */
tableau: 'tableau' name=IDENTIFIER 'top' max=INTEGER sortable? tableau_def titre? filtres* champs*;
tableau_def: '[' columns ']';
sortable: SORTABLE;
columns:  column ('|' column)*  ;
column : name=WORD;

/* Filtre tableau*/
filtres : 'filtres' columns type=WORD;
champs: 'champs' columns styles;
styles: 'en' style (COMA style)*;
style: (style_text=STYLE_TEXT | color=COLOR_HEXA);


/*****************
 ** Lexer rules **
 *****************/

IDENTIFIER :  QUOTE WORD+ QUOTE ;
DISCIPLINE :   'championnat' | 'tournoi';
STYLE_TEXT: 'souligné' | 'gras' | 'masqué';
COLOR_HEXA: '#' ([0-9] | [A-F])*;
LOGO: 'with logo';
SORTABLE: 'triable';
/*************
 ** Helpers **
 *************/
INTEGER             : [0-9]+;
fragment LOWERCASE  : [a-z] | 'é';                                 // abstract rule, does not really exists
fragment UPPERCASE  : [A-Z];
WORD     : (LOWERCASE|UPPERCASE)+;
fragment QUOTE      : '"';
COMA       : ',';
NEWLINE             : ('\r'? '\n' | '\r')+      -> skip;
WS                  : ((' ' | '\t')+)           -> skip;     // who cares about whitespaces?
COMMENT             : '#' ~( '\r' | '\n' )*     -> skip;     // Single line comments, starting with a #
