package jflex;

import parser.*;
import parser.Sym;
import parser.token.*;

%%
%public
%class Lexer
%line
%column
%unicode
%type Token



%yylexthrow{
  //Exception thrown
  Exception, L1Exception, L3Exception
%yylexthrow}



// Variable declaration
comment = "#"[^\n\r]*
blanc = [\n\ \t\r\v\f]
control_char = [\0-\x1F\x7F-\x9F]
hex = [0-9A-Fa-f]

char = "\\"[\\/bfnrt] | "\\u"{hex}{hex}{hex}{hex}

charsD = [^[\0-\x1F\x7F-\x9F]\"\\] | {char}
charsS = [^[\0-\x1F\x7F-\x9F]\'\\] | {char}

stringDQ = "\"" {charsD}* "\""
stringSQ = "'" {charsS}* "'"
name = [:letter:][:jletterdigit:]*
number = [+-]?[:digit:]+
floatNumber = [+-]? [:digit:]*.[:digit:]*



%%
//standard token
"true"					{return new BooleanToken(Sym.BOOLEAN_VALUE, yyline + 1, yycolumn +1, yytext());}
"false"					{return new BooleanToken(Sym.BOOLEAN_VALUE, yyline + 1, yycolumn +1, yytext());}
<<EOF>>                	{return new Token(Sym.EOF,yyline + 1,yycolumn +1 ) ;}


// Iota grammar
"import"				{return new Token(Sym.IMPORT, yyline + 1, yycolumn +1);}



// Lambda grammar
"null"					{return new Token(Sym.NULL, yyline + 1, yycolumn +1);}
"string"				{return new Token(Sym.STRING, yyline + 1, yycolumn +1);}
"boolean"				{return new Token(Sym.BOOLEAN, yyline + 1, yycolumn +1);}
"list"					{return new Token(Sym.LIST, yyline + 1, yycolumn +1);}
"int8"					{return new Token(Sym.INT8, yyline + 1, yycolumn +1);}
"int16"					{return new Token(Sym.INT16, yyline + 1, yycolumn +1);}
"int32"					{return new Token(Sym.INT32, yyline + 1, yycolumn +1);}
"int64"					{return new Token(Sym.INT64, yyline + 1, yycolumn +1);}
"uint8"					{return new Token(Sym.UINT8, yyline + 1, yycolumn +1);}
"uint16"				{return new Token(Sym.UINT16, yyline + 1, yycolumn +1);}
"uint32"				{return new Token(Sym.UINT32, yyline + 1, yycolumn +1);}
"uint64"				{return new Token(Sym.UINT64, yyline + 1, yycolumn +1);}
"float"					{return new Token(Sym.FLOAT, yyline + 1, yycolumn +1);}
"Alias"					{return new Token(Sym.ALIAS, yyline + 1, yycolumn +1);}
"Data"					{return new Token(Sym.DATA, yyline + 1, yycolumn +1);}
":="					{return new Token(Sym.COLON_EQUAL, yyline + 1, yycolumn +1);}
"<"						{return new Token(Sym.R_ANGLE_BRACE, yyline + 1, yycolumn +1);}
">"						{return new Token(Sym.L_ANGLE_BRACE, yyline + 1, yycolumn +1);}
","						{return new Token(Sym.COMMA, yyline + 1, yycolumn +1);}
":"						{return new Token(Sym.COLON, yyline + 1, yycolumn +1);}
"-"						{return new Token(Sym.DASH, yyline + 1, yycolumn +1);}
"="						{return new Token(Sym.EQUAL, yyline + 1, yycolumn +1);}



// Omega grammar 
"\*\["					{return new Token(Sym.REF_ACCESS, yyline + 1, yycolumn +1);}
"&\["					{return new Token(Sym.REF_DEFINE, yyline + 1, yycolumn +1);}
"\]"					{return new Token(Sym.R_SQ_BRACE, yyline + 1, yycolumn +1);}
"\{"					{return new Token(Sym.L_BRACE, yyline + 1, yycolumn +1);}
"\}"					{return new Token(Sym.R_BRACE, yyline + 1, yycolumn +1);}
"e"|"E"					{return new Token(Sym.EXP_MARKER, yyline + 1, yycolumn +1);}
"@"						{return new Token(Sym.ROOT, yyline + 1, yycolumn +1);}



// Standard tokens
{stringDQ} | {stringSQ} {return new StringToken(Sym.STRING_VALUE, yyline + 1, yycolumn + 1, yytext().substring(1,yytext().length() - 1));}
{name}					{return new NameToken(Sym.NAME, yyline + 1, yycolumn + 1, yytext());}
{number}				{return new NumberToken(Sym.NUMBER, yyline + 1, yycolumn + 1, yytext());}
{floatNumber}			{return new FloatToken(Sym.FLOAT_NUMBER, yyline + 1, yycolumn + 1, yytext());}

// Ignored sentence
{comment}       	{}
{blanc}		  		{}
{control_char}		{throw new L1Exception(yyline + 1,yycolumn +1);}

// Error
[^] { throw new L3Exception(yyline + 1,yycolumn +1 , yytext()) ;}