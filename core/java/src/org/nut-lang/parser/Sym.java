package parser;

/**
 * This file enums all symbols.
 * @author Heijix
 */
public enum Sym
{
	/*******************
	* Standar symbols *
	*******************/

	/**
	 * value of a string in single quotes or double quotes.
	 */
	STRING_VALUE,

	/**
	 * name identifier
	 */
	NAME,

	/**
	 * all numbers
	 */
	NUMBER,

	/**
	 * a float number
	 */
	FLOAT_NUMBER,

	/**
	 * a boolean value
	 */
	BOOLEAN_VALUE,

	/**
	 * End of file
	 */
	EOF,


	/****************
	* Iota grammar *
	****************/

	/**
	 * 'import' symbol
	 */
	IMPORT,


	/******************
	* Lambda grammar *
	******************/

	/**
	 * 'null' symbol
	 */
	NULL,

	/**
	 * 'string' symbol
	 */
	STRING,

	/**
	 * 'boolean' symbol
	 */
	BOOLEAN,

	/**
	 * 'list' symbol
	 */
	LIST,

	/**
	 * 'int8' symbol
	 */
	INT8,

	/**
	 * 'int16' symbol
	 */
	INT16,

	/**
	 * 'int32' symbol
	 */
	INT32,

	/**
	 * 'int64' symbol
	 */
	INT64,

	/**
	 * 'uint8' symbol
	 */
	UINT8,

	/**
	 * 'uint16' symbol
	 */
	UINT16,

	/**
	 * 'uint32' symbol
	 */
	UINT32,

	/**
	 * 'uint64' symbol
	 */
	UINT64,

	/**
	 * 'float' symbol
	 */
	FLOAT,

	/**
	 * symbol characterizing an object
	 */
	OBJECT,

	/**
	 * 'Alias' symbol
	 */
	ALIAS,

	/**
	 * 'Data' symbol
	 */
	DATA,

	/**
	 * ':=' symbol
	 */
	COLON_EQUAL,

	/**
	 * '<' symbol
	 */
	L_ANGLE_BRACE,

	/**
	 * '>' symbol
	 */
	R_ANGLE_BRACE,

	/**
	 * ',' symbol
	 */
	COMMA,

	/**
	 * ':' symbol
	 */
	COLON,

	/**
	 * '-' symbol
	 */
	DASH,

	/**
	 * '=' symbol
	 */
	EQUAL,


	/*****************
	* Omega grammar *
	*****************/

	/**
	 * '*[' symbol
	 */
	REF_ACCESS,

	/**
	 * '&[' symbol
	 */
	REF_DEFINE,

	/**
	 * '[' symbol
	 */
	L_SQ_BRACE,

	/**
	 * ']' symbol
	 */
	R_SQ_BRACE,

	/**
	 * '{' symbol
	 */
	L_BRACE,

	/**
	 * '}' symbol
	 */
	R_BRACE,

	/**
	 * 'e' or 'E' symbol
	 */
	EXP_MARKER,

	/**
	 * '@' symbol
	 */
	ROOT;
}
