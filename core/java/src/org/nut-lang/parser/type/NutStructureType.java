package parser.type;

import parser.Sym;

import java.util.HashMap;

/**
 * Class for a data structure type.
 * @author Heijix
 */
public class NutStructureType extends NutType
{
	/**
	 * Content of the data structure
	 */
	private HashMap <String, NutType> typeModel;

	/**
	 * General constructor
	 */
	public NutStructureType()
	{
		super(Sym.OBJECT);
		this.typeModel = new HashMap <>();
	}

	/**
	 * It adds a pair : name / type in the data structure
	 * @param nameOfVariable name of the variable
	 * @param type type of the variable
	 * @return true if it is added, false otherwise
	 * @throws Exception if the variable already exists
	 */
	public boolean addVariable(String nameOfVariable, NutType type) throws Exception
	{
		if (typeModel.containsKey(nameOfVariable))
		{
			throw new Exception("Variable " + nameOfVariable + " already exists.");
		}
		else
		{
			typeModel.put(nameOfVariable, type);
			return (true);
		}
	}
}
