package ast;

import exception.NutException;

/**
 * This class corresponds to a char of 'Nut' object.
 * @author Heijix
 */
public class NutInt8 extends Nut
{
	/**
	 * Value of the char
	 */
	private char value;

	/**
	 * General constructor for a char of 'Nut' object.
	 * @param line line where the object is created
	 * @param column column where the object is created
	 * @param value value of the char
	 */
	public NutInt8(int line, int column, char value)
	{
		super(line, column, "a char");
		this.value = value;
	}

	public char getNutInt8() throws NutException
	{
		return (this.value);
	}
}
