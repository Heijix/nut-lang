package parser.token;

import parser.Sym;

/**
 * Class generate by lexer corresponding to a boolean
 * @author Heijix
 */
public class BooleanToken extends Token{

    /**
     * boolean value of the token
     */
    private boolean value;

    /**
     * General constructor of a boolean token
     * @param line line of the token
     * @param column column of the token
     * @param symbol symbol of the token
     * @param value value of the token
     */
    public BooleanToken(int line, int column, Sym symbol, boolean value) {
        super(line, column, symbol);
        this.value = value;
    }

    /**
     * Getter
     * @return get the value of the token
     */
    public boolean getValue() {
        return value;
    }
}
