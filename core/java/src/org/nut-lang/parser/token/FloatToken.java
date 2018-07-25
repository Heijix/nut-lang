package parser.token;

import parser.Sym;

public class FloatToken extends Token {

    private float value;

    public FloatToken(int line, int column, Sym symbol, String value) {
        super(line, column, symbol);
        this.value = Float.valueOf(value);
    }

    public float getValue() {
        return value;
    }
}
