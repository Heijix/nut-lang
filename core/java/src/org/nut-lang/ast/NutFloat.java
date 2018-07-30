package ast;

import exception.NutException;

/**
 * This class corresponds to a float of 'Nut' object.
 * @author Heijix
 */
public class NutFloat extends Nut {

    /**
     * Value of the float
     */
    private float value;

    /**
     * General constructor for a float of 'Nut' object.
     * @param line line where the object is created
     * @param column column where the object is created
     * @param value value of the float
     */
    public NutFloat(int line, int column, float value) {
        super(line, column, "a float");
        this.value = value;
    }

    @Override
    public float getNutFloat() throws NutException {
        return this.value;
    }
}
