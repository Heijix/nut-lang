package parser.token;

import parser.Sym;

public class NumberToken extends Token {

    private long value;

    public NumberToken(int line, int column, Sym symbol, String value) {
        super(line, column, symbol);
        value = (value.charAt(0) == '+') ? value.substring(1) : value;
        this.value = Long.valueOf(value);
    }

    public long getValue() {
        return value;
    }
}
