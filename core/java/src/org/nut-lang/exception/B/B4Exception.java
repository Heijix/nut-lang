package exception.B;

import exception.NutException;

public class B4Exception extends NutException {

    public B4Exception(int line, int column, String message) {
        super(line, column, "An alias is never used : " + message);
    }
}
