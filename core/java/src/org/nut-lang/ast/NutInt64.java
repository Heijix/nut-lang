package ast;

import exception.NutException;

/**
 * This class corresponds to a long of 'Nut' object.
 * @author Heijix
 */
public class NutInt64 extends Nut{

    /**
     * Value of the long
     */
    private long value;

    /**
     * General constructor for a long of 'Nut' object.
     * @param line line where the object is created
     * @param column column where the object is created
     * @param value value of the long
     */
    public NutInt64(int line, int column, long value) {
        super(line, column, "a long");
        this.value = value;
    }

    public long getNutInt64() throws NutException {
        return this.value;
    }
}