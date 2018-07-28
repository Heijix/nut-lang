package exception.L;

import exception.NutException;

public class L2Exception extends NutException {

    public L2Exception(int line, int column) {
        super(line, column, "Any explicit Unicode Character need to be followed by 4 hexadecimal characters in [0-9] or [a-f] or [A-F]");
    }
}
