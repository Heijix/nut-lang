package exception.L;

import exception.NutException;

public class L1Exception extends NutException {

    public L1Exception(int line, int column, String message) {
        super(line, column, "Control Command Character is not allowed in a Nut File : " +message);
    }
}
