package exception.L;

import exception.NutException;

public class L0Exception extends NutException {

    public L0Exception(int line, int column) {
        super(line, column, "EOF is encountered too early in the file");
    }
}
