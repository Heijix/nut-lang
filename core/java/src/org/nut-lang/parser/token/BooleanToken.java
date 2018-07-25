package parser.token;

import parser.Sym;

public class BooleanToken extends Token{

    private boolean value;

    public BooleanToken(int line, int column, Sym symbol, String value) {
        super(line, column, symbol);
        this.value = value.matches("true");
    }

    public boolean isValue() {
        return value;
    }
}
