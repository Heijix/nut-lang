package exception.B;

import exception.NutException;

public class B2Exception extends NutException {

    public B2Exception(int line, int column, String message) {
        super(line, column, "You need to implement all members of the object you want to create : " + message);
    }
}
