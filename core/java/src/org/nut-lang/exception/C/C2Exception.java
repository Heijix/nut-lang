package exception.C;

import exception.NutException;

public class C2Exception extends NutException {

    public C2Exception(int line, int column, String message) {
        super(line, column, "All Data Types created has to start with a uppercase character : " + message);
    }
}
