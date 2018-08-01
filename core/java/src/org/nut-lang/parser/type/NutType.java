package parser.type;

import ast.Nut;
import parser.Sym;

/**
 * Class for all nut type.
 * @author Heijix
 */
public class NutType
{
	/**
	 * type symbol
	 */
	protected Sym type;

	/**
	 * show is the type has a default value
	 */
	protected boolean hasDefaultValue;

	/**
	 * content of the default value
	 */
	protected Nut defaultValue;

	/**
	 * General constructor of a NutType
	 * @param type symbol of the type
	 */
	public NutType(Sym type)
	{
		this.type            = type;
		this.hasDefaultValue = false;
		this.defaultValue    = null;
	}

	/**
	 * Getter
	 * @return type of the NutType
	 */
	public Sym getType()
	{
		return (this.type);
	}

	/**
	 * Getter
	 * @return content of the default value
	 */
	public Nut getDefaultValue()
	{
		return (defaultValue);
	}

	/**
	 * It adds a default value in the NutType
	 * @param defaultValue content of the default value
	 * @return true if the default value is added, false otherwise.
	 */
	public boolean addDefaultValue(Nut defaultValue)
	{
		if (this.defaultValue == null)
		{
			this.defaultValue    = defaultValue;
			this.hasDefaultValue = true;
			return (true);
		}
		return (false);
	}
}
