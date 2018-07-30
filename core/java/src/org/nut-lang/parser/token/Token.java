package parser.token;

import parser.Sym;

/**
 * Class generate by lexer
 * @author Heijix
 */
public class Token {


    /**
     * line where the object is created
     */
    protected int line;

    /**
     * column where the object is created
     */
    protected int column;

    /**
     * symbol of the token
     */
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

    /**
     * Getter
     * @return line of the token
     */
    public int getLine() {
        return line;
    }

    /**
     * Getter
     * @return column of the token
     */
    public int getColumn() {
        return column;
    }

    /**
     * Getter
     * @return symbol of the token
     */
    public Sym getSymbol() {
        return symbol;
    }
}
