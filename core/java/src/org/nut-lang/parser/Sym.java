package parser;

public enum Sym{

	/* Standar symbols : */
	STRING_VALUE, NAME, NUMBER, FLOAT_NUMBER, BOOLEAN_VALUE, EOF,

	/* Iota grammar */
	IMPORT,
	
	/* Lambda grammar */
	NULL, STRING, BOOLEAN, LIST, INT8, INT16, INT32, INT64, UINT8, UINT16, UINT32, UINT64, FLOAT,
	
	ALIAS, DATA,
	
	COLON_EQUAL, L_ANGLE_BRACE, R_ANGLE_BRACE, COMMA, COLON, DASH, EQUAL,
	
	/* Omega grammar */
	REF_ACCESS, REF_DEFINE, L_SQ_BRACE, R_SQ_BRACE, L_BRACE, R_BRACE, EXP_MARKER, ROOT;

}