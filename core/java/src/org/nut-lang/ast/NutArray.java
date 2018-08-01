package ast;

import exception.NutException;

import java.util.LinkedList;

/**
 * This class corresponds to an array of 'Nut' object.
 * @author Heijix
 */
public class NutArray extends Nut
{
	/**
	 * Content of the array
	 */
	private LinkedList <Nut> content;

	/**
	 * General constructor for an array of 'Nut' object.
	 * @param line line where the object is created
	 * @param column column where the object is created
	 * @param content Content of the array
	 */
	public NutArray(int line, int column, LinkedList <Nut> content)
	{
		super(line, column, "an array");
		this.content = content;
	}

	@Override
	public LinkedList <Nut> getNutArray() throws NutException
	{
		return (this.content);
	}
}
