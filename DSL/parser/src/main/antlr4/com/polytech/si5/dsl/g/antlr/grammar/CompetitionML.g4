grammar CompetitionML;


/******************
 ** Parser rules **
 ******************/

root           :   app discipline classements EOF;
app            :   'app' logo 'et' styles;
logo           :    display=DISPLAY 'logo' ;
discipline     :   'discipline' name=TITLE type=DISCIPLINE ;

classements : classement*;
classement : 'classement' name=TITLE titre? classement_options* tableau+;
classement_options : (disposition | padding);
titre: 'titre' styles;
disposition : 'disposition' padding;
padding : 'padding' value=INTEGER 'px';

/* Tableau */
tableau: 'tableau' name=TITLE 'top' max=INTEGER pagination? tableau_def titre? sortables? filtres* champs* detailEvent?;
tableau_def: '[' columns ']';
columns:  column ('|' column )*  ;
column : name=WORD | '('detail=WORD')';
detailEvent : 'événement' name=WORD;

/* Filtre tableau*/
filtres : 'filtres' columns_refs FILTRE_TYPE FILTRE_CHECKBOX_TYPE?;
columns_refs: column_ref (',' column_ref)*;
column_ref : name=WORD;
/* Filtre tableau*/
sortables : 'triable' columns_refs;
/* Options tableau */
champs: 'champs' columns_refs styles;
styles: 'en' style (COMA style)*;
style: (style_text=STYLE_TEXT | color=COLOR_HEXA);
pagination: 'pagination' nbItems=INTEGER;


/*****************
 ** Lexer rules **
 *****************/
TITLE : QUOTE ([a-zA-Z0-9 ])+ QUOTE;
IDENTIFIER :  QUOTE WORD+ QUOTE ;
DISCIPLINE :   'championnat' | 'tournoi';
STYLE_TEXT: 'souligné' | 'gras' | 'masqué';
COLOR_HEXA: '#' ([0-9] | [A-F])*;
DISPLAY:  'avec' | 'sans';
SORTABLE: 'triable';
FILTRE_TYPE: 'unique';
FILTRE_CHECKBOX_TYPE: 'radio' | 'switch' | 'checkbox';
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
