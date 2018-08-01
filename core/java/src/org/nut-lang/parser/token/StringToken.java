package parser.token;

import parser.Sym;

/**
 * Class generate by lexer corresponding to a string
 * @author Heijix
 */
public class StringToken extends Token{

    /**
     * string value of the token
     */
    private String value;

    /**
     * General constructor of a string token
     * @param line line of the token
     * @param column column of the token
     * @param symbol symbol of the token
     * @param value value of the token
     */
    public StringToken(int line, int column, Sym symbol, String value) {
        super(line, column, symbol);
        this.value = value;
    }

    /**
     * Getter
     * @return get the value of the token
     */
    public String getValue() {
        return value;
    }
}
