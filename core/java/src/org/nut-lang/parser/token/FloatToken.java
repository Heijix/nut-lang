package parser.token;

import parser.Sym;

/**
 * Class generate by lexer corresponding to a float
 * @author Heijix
 */
public class FloatToken extends Token {

    /**
     * float value of the token
     */
    private float value;

    /**
     * General constructor of a float token
     * @param line line of the token
     * @param column column of the token
     * @param symbol symbol of the token
     * @param value value of the token
     */
    public FloatToken(int line, int column, Sym symbol, String value) {
        super(line, column, symbol);
        value = (value.charAt(0) == '+') ? value.substring(1) : value;
        this.value = Float.valueOf(value);
    }

    /**
     * Getter
     * @return get the value of the token
     */
    public float getValue() {
        return value;
    }
}
