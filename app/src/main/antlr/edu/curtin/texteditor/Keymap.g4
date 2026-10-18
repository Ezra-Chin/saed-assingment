grammar Keymap;


//rules 
keymap : shortcut*;
shortcut : modifier (PLUS modifier)* PLUS LETTER EQUALS action STRING caretPosition; 

modifier : ALT | CTRL | SHIFT;
action : INSERT | DELETE;
caretPosition : AT START OF LINE | AT CARET;




//lexer 

ALT : 'alt'; 
CTRL : 'ctrl';
SHIFT : 'shift';
INSERT : 'insert';
DELETE : 'delete';
AT : 'at';
START : 'start';
OF : 'of';
LINE : 'line';
CARET : 'caret';
PLUS : '+';
EQUALS : '=';



//i took this from lect slides 
LETTER : [a-z] ;
STRING     : '"' ~[""]* '"' ;  // You can write ~["], but it may confuse your editor.
NUMBER     : [0-9]+ ('.' [0-9]+)? ;
UNIT       : 'g' | 'kg' | 'mL' | 'L' ;

WHITESPACE : [ \t\n\r]+ -> skip ;
COMMENT    : '#' ~[\n]* -> skip ;

