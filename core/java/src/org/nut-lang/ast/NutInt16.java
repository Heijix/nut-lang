package ast;

import exception.NutException;

/**
 * This class corresponds to a short of 'Nut' object.
 * @author Heijix
 */
public class NutInt16 extends Nut
{
	/**
	 * Value of the short
	 */
	private short value;

	/**
	 * General constructor for a short of 'Nut' object.
	 * @param line line where the object is created
	 * @param column column where the object is created
	 * @param value value of the short
	 */
	public NutInt16(int line, int column, short value)
	{
		super(line, column, "a short");
		this.value = value;
	}

	public short getNutInt16() throws NutException
	{
		return (this.value);
	}
}
