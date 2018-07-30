package parser.token;

import parser.Sym;

/**
 * Class generate by lexer corresponding to a number
 * @author Heijix
 */
public class NumberToken extends Token {

    /**
     * number value of the token
     */
    private long value;

    /**
     * General constructor of a number token
     * @param line line of the token
     * @param column column of the token
     * @param symbol symbol of the token
     * @param value value of the token
     */
    public NumberToken(int line, int column, Sym symbol, String value) {
        super(line, column, symbol);
        value = (value.charAt(0) == '+') ? value.substring(1) : value;
        this.value = Long.valueOf(value);
    }

    /**
     * Getter
     * @return get the value of the token
     */
    public long getValue() {
        return value;
    }
}
