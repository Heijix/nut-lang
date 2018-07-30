package jflex;

import parser.*;
import parser.Sym;
import parser.token.*;
import exception.L.*;
import exception.NutException;

%%
%public
%class Lexer
%line
%column
%unicode
%type Token



%yylexthrow{
  //exception thrown
  NutException
%yylexthrow}



// Variable declaration
comment = "#"[^\n\r]*
blanc = [\n\ \t\r\v\f]
control_char = [\0-\x1F\x7F-\x9F]
hex = [0-9A-Fa-f]
float = [:digit:]+.[:digit:]* | [:digit:]*.[:digit:]+

char = "\\"[\\/bfnrt] | "\\u"{hex}{hex}{hex}{hex}

charsD = [^[\0-\x1F\x7F-\x9F]\"\\] | {char}
charsS = [^[\0-\x1F\x7F-\x9F]\'\\] | {char}

stringDQ = "\"" {charsD}* "\""
stringSQ = "'" {charsS}* "'"
name = [:uppercase:][:jletterdigit:]*
number = [+-]?[:digit:]+
floatNumber = [+-]? {float}


%%
//standard token
"true"					{return new BooleanToken(yyline + 1, yycolumn +1, Sym.BOOLEAN_VALUE, true);}
"false"					{return new BooleanToken(yyline + 1, yycolumn +1, Sym.BOOLEAN_VALUE, false);}
<<EOF>>                	{return new Token(yyline + 1,yycolumn +1, Sym.EOF) ;}


// Iota grammar
"import"				{return new Token(yyline + 1, yycolumn +1, Sym.IMPORT);}



// Lambda grammar
"null"					{return new Token(yyline + 1, yycolumn +1, Sym.NULL);}
"string"				{return new Token(yyline + 1, yycolumn +1, Sym.STRING);}
"boolean"				{return new Token(yyline + 1, yycolumn +1, Sym.BOOLEAN);}
"list"					{return new Token(yyline + 1, yycolumn +1, Sym.LIST);}
"int8"					{return new Token(yyline + 1, yycolumn +1, Sym.INT8);}
"int16"					{return new Token(yyline + 1, yycolumn +1, Sym.INT16);}
"int32"					{return new Token(yyline + 1, yycolumn +1, Sym.INT32);}
"int64"					{return new Token(yyline + 1, yycolumn +1, Sym.INT64);}
"uint8"					{return new Token(yyline + 1, yycolumn +1, Sym.UINT8);}
"uint16"				{return new Token(yyline + 1, yycolumn +1, Sym.UINT16);}
"uint32"				{return new Token(yyline + 1, yycolumn +1, Sym.UINT32);}
"uint64"				{return new Token(yyline + 1, yycolumn +1, Sym.UINT64);}
"float"					{return new Token(yyline + 1, yycolumn +1, Sym.FLOAT);}
"Alias"					{return new Token(yyline + 1, yycolumn +1, Sym.ALIAS);}
"Data"					{return new Token(yyline + 1, yycolumn +1, Sym.DATA);}
":="					{return new Token(yyline + 1, yycolumn +1, Sym.COLON_EQUAL);}
"<"						{return new Token(yyline + 1, yycolumn +1, Sym.R_ANGLE_BRACE);}
">"						{return new Token(yyline + 1, yycolumn +1, Sym.L_ANGLE_BRACE);}
","						{return new Token(yyline + 1, yycolumn +1, Sym.COMMA);}
":"						{return new Token(yyline + 1, yycolumn +1, Sym.COLON);}
"-"						{return new Token(yyline + 1, yycolumn +1, Sym.DASH);}
"="						{return new Token(yyline + 1, yycolumn +1, Sym.EQUAL);}



// Omega grammar 
"\*\["					{return new Token(yyline + 1, yycolumn +1, Sym.REF_ACCESS);}
"&\["					{return new Token(yyline + 1, yycolumn +1, Sym.REF_DEFINE);}
"\]"					{return new Token(yyline + 1, yycolumn +1, Sym.R_SQ_BRACE);}
"\{"					{return new Token(yyline + 1, yycolumn +1, Sym.L_BRACE);}
"\}"					{return new Token(yyline + 1, yycolumn +1, Sym.R_BRACE);}
"e"|"E"					{return new Token(yyline + 1, yycolumn +1, Sym.EXP_MARKER);}
"@"						{return new Token(yyline + 1, yycolumn +1, Sym.ROOT);}



// Standard tokens
{stringDQ} | {stringSQ} {return new StringToken(yyline + 1, yycolumn + 1, Sym.STRING_VALUE, yytext().substring(1,yytext().length() - 1));}
{name}					{return new StringToken(yyline + 1, yycolumn + 1, Sym.NAME, yytext());}
{number}				{return new NumberToken(yyline + 1, yycolumn + 1, Sym.NUMBER, yytext());}
{floatNumber}			{return new FloatToken(yyline + 1, yycolumn + 1, Sym.FLOAT_NUMBER, yytext());}

// Ignored sentence
{comment}       	{}
{blanc}		  		{}
{control_char}		{throw new L1Exception(yyline + 1,yycolumn +1, yytext());}

// Error
[^] { throw new L3Exception(yyline + 1,yycolumn +1 , yytext()) ;}