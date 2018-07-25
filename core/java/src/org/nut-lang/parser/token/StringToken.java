package parser.token;

import parser.Sym;

public class StringToken extends Token{

    private String value;

    public StringToken(int line, int column, Sym symbol, String value) {
        super(line, column, symbol);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
