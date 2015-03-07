grammar GPoMv;

@header {   
import java.util.*;
}

@parser::members {
/**************************************************************/
// Add by dc, only hints
/** "memory" for our calculator; variable/value pairs go here */
Map<String, Integer> memory = new HashMap<String, Integer>();

int eval(int left, int op, int right) {
    switch ( op ) {
        case MUL : return left * right;
        case DIV : return left / right;
        case ADD : return left + right;
        case SUB : return left - right;
    }
    return 0;
}
// new block

/**************************************************************/
}

@lexer::members {   
/**************************************************************/
// Add by dc, only hints
public static final int WHITESPACE = 1;
public static final int COMMENTS   = 2;
// new block

/**************************************************************/
}

file
:
	moduleType
	(
		globalVarDecl* moudle
	)+
;

moduleType
:
	ID
;

moudle
:
	MODULE ID statement* ENDMODULE
;

MODULE
:
	'Moudle'
;

ENDMODULE
:
	'End Moudle'
;

statement
:
	block
	| varDecl
	| stateDefine
	| transferStat
	| labelSet
	| labelStat
	| ifStat
	| expr
;

block
:
	'{' statement* '}'
;

varDecl
:
	varType ID '=' expr ';'
	| ID '=' expr ';'
;

stateDefine
:
	varName ':' '[' expr '..' expr ']'
	(
		INIT expr
	)? ';'
;

INIT
:
	'init'
;

varName
:
	ID
;

varStart
:
	INT
;

varEnd
:
	INT
;

varInit
:
	INT
;

transferStat
:
	transLable transferChildStatLeft TRANS transferChildStatRight ';'
;

TRANS
:
	'->'
;

transLable
:
	'[' ID? ']'
;

transferChildStatLeft
:
	expr
;

transferChildStatRight
:
	NUMBER ':'? expr
	(
		'+' NUMBER ':' expr
	)*
;

labelSet
:
	LABELS ':' '[' exprList ']' ';'
;

LABELS
:
	'Label'
;

labelStat
:
	labelCondition exprList ';'
;

labelCondition
:
	'<' expr '=' expr '>'
;

ifStat
:
	'if' expr 'then' statement
	(
		'else' statement
	)?
;

globalVarDecl
:
	'global' varType? ID
	(
		'=' expr
	)? ';'
;

/* now var'type only has int,double,boolean */
varType
:
	K_INT
	| K_FLOAT
	| K_BOOLEAN
;

expr
:
	ID '(' exprList? ')'
	| expr '[' expr ']'
	| '-' expr
	| '!' expr
	| expr '*' expr
	| expr '+' expr
	| expr '-' expr
	| expr '==' expr
	| expr '!=' expr
	| expr '=' expr
	| expr '&' expr
	| expr '|' expr
	| '(' expr ')'
	| ID
	{/*System.out.println($ID.text);*/}

	| NUMBER
;

exprList
:
	expr
	(
		',' expr
	)*
; // arg list

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
	'='
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
