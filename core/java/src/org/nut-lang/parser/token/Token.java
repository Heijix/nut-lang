package parser.token;

import parser.Sym;

/**
 * Class generate by lexer
 * @author Heijix
 */
public class Token {

    protected int line,column;
    protected Sym symbol;

    /**
     * Default constructor
     * @param  symbol Symbol of Token
     * @param  line   line of token
     * @param  column column of token
     */
    public Token(int line, int column, Sym symbol) {
        this.line = line;
        this.column = column;
        this.symbol = symbol;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public Sym getSymbol() {
        return symbol;
    }
}
