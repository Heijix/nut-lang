package parser.type;

import parser.Sym;

/**
 * Class for type known as a name.
 * @author Heijix
 */
public class NutNameType extends NutType
{
	/**
	 * Name of the type
	 */
	private String nameType;

	/**
	 * General constructor
	 * @param nameType Name of the type
	 */
	public NutNameType(String nameType)
	{
		super(Sym.NAME);
		this.nameType = nameType;
	}
}
