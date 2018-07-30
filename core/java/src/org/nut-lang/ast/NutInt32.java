package ast;

import exception.NutException;

/**
 * This class corresponds to an int of 'Nut' object.
 * @author Heijix
 */
public class NutInt32 extends Nut{

    /**
     * Value of the int
     */
    private int value;

    /**
     * General constructor for an int of 'Nut' object.
     * @param line line where the object is created
     * @param column column where the object is created
     * @param value value of then int
     */
    public NutInt32(int line, int column, int value) {
        super(line, column, "an int");
        this.value = value;
    }

    public int getNutInt32() throws NutException {
        return this.value;
    }
}
