package exception.B;

import exception.NutException;

public class B3Exception extends NutException {

    public B3Exception(int line, int column, String message) {
        super(line, column, "You cannot add fields in the object, because it doesn't exist in the Data Type Definition of the object you want to create : " + message);
    }
}
