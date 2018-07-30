package ast;

import exception.NutException;

/**
 * This class corresponds to a string of 'Nut' object.
 * @author Heijix
 */
public class NutString extends Nut {

    /**
     * Value of the string
     */
    private String value;

    /**
     * General constructor for a string of 'Nut' object.
     * @param line line where the object is created
     * @param column column where the object is created
     * @param value value of the string
     */
    public NutString(int line, int column, String value) {
        super(line, column, "a string");
        this.value = value;
    }

    @Override
    public String getNutString() throws NutException {
        return this.value;
    }
}
