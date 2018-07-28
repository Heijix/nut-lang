package exception.B;

import exception.NutException;

public class B5Exception extends NutException {

    public B5Exception(int line, int column, String message) {
        super(line, column, "An alias already exist, choose another one : " + message);
    }
}
