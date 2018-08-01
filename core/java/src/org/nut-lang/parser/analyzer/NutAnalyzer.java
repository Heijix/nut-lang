package parser.analyzer;

import ast.Nut;

/**
 * This class is the analyzer of NutParser.
 * It verifies all type.
 * @author Heijix
 */
public class NutAnalyzer
{
	/**
	 * Environment values provided by the parser.
	 */
	private ValueEnv valueEnv;

	/**
	 * General constructor for a NutAnalyzer.
	 * @param valueEnv Environment values provided by the parser.
	 */
	public NutAnalyzer(ValueEnv valueEnv)
	{
		this.valueEnv = valueEnv;
	}

	/**
	 * It is a getter to the root Nut object in the right format.
	 * @return root Nut object in the right format
	 */
	public Nut getNutResult()
	{
		return (null);
	}

	/**
	 * It is a getter to the root Nut object in the format described in the 'wantedObjectModel' file.
	 * @param wantedObjectModel file where only one data structure is described.
	 * @return root Nut object in the format of the data structure given.
	 */
	public Nut getNutResult(String wantedObjectModel)
	{
		return (null);
	}

	/**
	 * It is a getter to the root Nut object in the 'objectName' format described in the 'wantedObjectModel' file.
	 * @param wantedObjectModel file where a lot of data structure are described.
	 * @param objectName name of data structure
	 * @return root Nut object in the format of 'objectName' given.
	 */
	public Nut getNutResult(String wantedObjectModel, String objectName)
	{
		return (null);
	}

	/**
	 * It verifies if the root Nut object is in the format described in the 'wantedObjectModel' file.
	 * @param wantedObjectModel file where only one data structure is described.
	 * @return true if root Nut object is in the format of the data structure given, false otherwise.
	 */
	public boolean validateNutResult(String wantedObjectModel)
	{
		return (false);
	}

	/**
	 * It verifies if the root Nut object is in the 'objectName' format described in the 'wantedObjectModel' file.
	 * @param wantedObjectModel file where a lot of data structure are described.
	 * @param objectName name of data structure
	 * @return true if root Nut object is in the format of 'objectName' given, false otherwise.
	 */
	public boolean validateNutResult(String wantedObjectModel, String objectName)
	{
		return (false);
	}
}
