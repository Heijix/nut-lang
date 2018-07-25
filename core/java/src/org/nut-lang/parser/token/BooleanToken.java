package parser.token;

import parser.Sym;

public class BooleanToken extends Token{

    private boolean value;

    public BooleanToken(int line, int column, Sym symbol, boolean value) {
        super(line, column, symbol);
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }
}
