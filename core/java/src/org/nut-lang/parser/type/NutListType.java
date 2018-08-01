package parser.type;

import parser.Sym;

import java.util.LinkedList;

/**
 * Class for a list type.
 * @author Heijix
 */
public class NutListType extends NutType
{
	/**
	 * all type contained in the list
	 */
	private LinkedList <NutType> allType;

	/**
	 * General constructor of a list type
	 */
	public NutListType()
	{
		super(Sym.LIST);
		this.allType = new LinkedList <>();
	}

	/**
	 * It adds a type in the list of type
	 * @param type type to be added
	 * @return true if it is added, false otherwise
	 * @throws Exception type already exists in the list
	 */
	public boolean addType(NutType type) throws Exception
	{
		if (allType.contains(type))
		{
			throw new Exception("Type already exists in the list.");
		}
		else
		{
			allType.addLast(type);
			return (true);
		}
	}
}
