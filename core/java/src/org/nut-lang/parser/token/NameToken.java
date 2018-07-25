package parser.token;

import parser.Sym;

public class NameToken extends Token{

    private String value;

    public NameToken(int line, int column, Sym symbol, String value) {
        super(line, column, symbol);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
