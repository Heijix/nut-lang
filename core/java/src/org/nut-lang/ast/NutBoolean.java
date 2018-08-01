package ast;

import exception.NutException;

/**
 * This class corresponds to a boolean of 'Nut' object.
 * @author Heijix
 */
public class NutBoolean extends Nut {

    /**
     * Value of the boolean
     */
    private boolean value;

    /**
     * General constructor for a boolean of 'Nut' object.
     * @param line line where the object is created
     * @param column column where the object is created
     * @param value value of the boolean
     */
    public NutBoolean(int line, int column, boolean value) {
        super(line, column, "a boolean");
        this.value = value;
    }

    @Override
    public boolean getNutBoolean() throws NutException {
        return this.value;
    }
}
