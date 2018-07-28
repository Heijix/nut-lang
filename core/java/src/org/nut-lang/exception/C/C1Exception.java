package exception.C;

import exception.NutException;

public class C1Exception extends NutException {

    public C1Exception(int line, int column, String message) {
        super(line, column, "Imported files, contains only imports and Data types definitions : " + message);
    }
}
