grammar GPoProp;

@header {   

}

@parser::members {

}

@lexer::members {   

}

file
:
	properties+
;

/*
// this can get order of parse , front formula first parse
properties
:
         stateFormulae
	| propertyWhetherTrue
        | propertyCalcValue
;
*/
properties
:
	stateFormulae propertyCondition?
;

/*
// not need
propertyCalcValue
:
	propertyType '[' pathFormulae ']'
;

propertyWhetherTrue
:
	propertyType '[' pathFormulae ']' propertyCondition?
;

propertyType
:
	PROP_PO
	| PROP_GPO
;
*/
pathFormulae
:
	nextChildProp
	| untilChildProp
	| eventuallyProp
	| alwaysProp
;

nextChildProp
:
	POCTL_NEXT stateFormulae
;

untilChildProp
:
	stateFormulae POCTL_UNTIL propertyCondition? stateFormulae
;

eventuallyProp
:
	POCTL_EVENTUALLY stateFormulae
;

alwaysProp
:
	POCTL_ALWAYS stateFormulae
;

stateFormulae
:
	poctl_true
	| expr
	| andProp
	| orProp
	| negationProp
	| poProp
;

poctl_true
:
	POCTL_TRUE
;

andProp
:
	PARENLEFT stateFormulae
	(
		POCTL_AND stateFormulae
	)+ PARENRIGHT
;

orProp
:
	PARENLEFT stateFormulae
	(
		POCTL_OR stateFormulae
	)+ PARENRIGHT
;

negationProp
:
	POCTL_NEGATON stateFormulae
;

poProp
:
	PROP_PO PARENLEFT pathFormulae PARENRIGHT
;

expr
:
	ID
;

propertyCondition
:
	conditionOperate conditionValue
;

conditionOperate
:
	GREATER
	| GREATEREQUAL
	| LESSER
	| LESSEREQUAL
	| EQUAL
;

conditionValue
:
	NUMBER
;

PROP_PO
:
	'Po'
;

PROP_GPO
:
	'GPo'
;

POCTL_NEXT
:
	'X'
; //neXt

POCTL_UNTIL
:
	'U'
; //Until

POCTL_EVENTUALLY
:
	'F'
; //Future

POCTL_ALWAYS
:
	'G'
; //Globally

POCTL_AND
:
	'&'
; //and 

POCTL_OR
:
	'|'
; //or

POCTL_NEGATON
:
	'N'
; //Negation

POCTL_TRUE
:
	'true'
;

K_INT
:
	'int'
;

K_DOUBLE
:
	'double'
;

K_FLOAT
:
	'float'
;

K_BOOLEAN
:
	'boolean'
;

K_VOID
:
	'void'
;

ID
:
	ID_LETTER
	(
		ID_LETTER
		| DIGIT
	)* '\''?
;

NUMBER
:
	'-'? INT '.' INT EXP? // 1.35, 1.35E-9, 0.3, -4.5

	| '-'? INT EXP // 1e10 -3e4

	| '-'? INT // -3, 45

;

FLOAT
:
	'-'? INT '.' INT
;

INT
:
	DIGIT+
; // no leading zeros

STRING
:
	'"'
	(
		ESC
		| ~["\\]
	)* '"'
;

BOOL
:
	'T'
	| 'F'
;

EQUAL
:
	'=='
;

GREATER
:
	'>'
;

GREATEREQUAL
:
	'>='
;

LESSER
:
	'<'
;

LESSEREQUAL
:
	'<='
;

BRACELEFT
:
	'{'
;

BRACERIGHT
:
	'}'
;

BRACKETLEFT
:
	'['
;

BRACKETRIGHT
:
	']'
;

PARENLEFT
:
	'('
;

PARENRIGHT
:
	')'
;

SEMICONLON
:
	';'
;

COLON
:
	':'
;

DOTDOT
:
	'..'
;

MUL
:
	'*'
;

DIV
:
	'/'
;

ADD
:
	'+'
;

SUB
:
	'-'
;

fragment
ESC
:
	'\\'
	(
		["\\/bfnrt]
		| UNICODE
	)
;

fragment
UNICODE
:
	'u' HEX HEX HEX HEX
;

fragment
HEX
:
	[0-9a-fA-F]
;

fragment
ID_LETTER
:
	[a-z]
	| [A-Z]
	| '_'
;

fragment
NOZERODIGIT
:
	[1-9]
;

fragment
DIGIT
:
	[0-9]
;

fragment
EXP
:
	[Ee] [+\-]? INT
; // \- since - means "range" inside [...]


//=====================================================
// comment
//=====================================================

WS
:
	[ \t\r\n]+ -> skip
;

COMMENT
:
	'/*' .*? '*/' -> skip
; // comment block

LINE_COMMENT
:
	'//' .*? '\r'? '\n' -> skip
; // line comment

JING_COMMENT
:
	'#' .*? '\r'? '\n' -> skip
; // line comment
// some specific symbol
