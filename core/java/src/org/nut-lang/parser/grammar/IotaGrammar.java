package parser.grammar;

import parser.analyzer.ValueEnv;
import parser.LookAhead;
import parser.NutParser;
import parser.Sym;

import java.util.LinkedList;

/**
 * Class corresponding to the Iota grammar
 * @author Heijix
 */
public class IotaGrammar
{
	private NutParser parser;
	private LookAhead reader;
	private ValueEnv valueEnv;
	private LinkedList <String> importPaths;

	/**
	 * General constructor
	 * @param parser parser called iota grammar
	 * @param reader lookAHead for parsing the grammar
	 * @param valueEnv environment value class
	 */
	public IotaGrammar(NutParser parser, LookAhead reader, ValueEnv valueEnv)
	{
		this.parser      = parser;
		this.reader      = reader;
		this.valueEnv    = valueEnv;
		this.importPaths = new LinkedList <>();
	}

	/**
	 * It fills the environment value with import's contents
	 */
	public void fillValueEnv()
	{
		while (this.reader.check(Sym.IMPORT))
		{
			try {
				this.reader.eat(Sym.IMPORT);
				if (this.reader.check(Sym.STRING))
				{
					String imp = this.reader.getString();
					importPaths.add(getAbsolutePathImport(imp));
				}
				else
				{
					parser.stockException(new Exception("Unexpected token."));
				}
			}
			catch (Exception exception) {
				parser.stockException(exception);
			}
		}
	}

	/**
	 * Transform a relative path to an absolute path
	 * @param importPath relative path
	 * @return absolute path
	 */
	private String getAbsolutePathImport(String importPath)
	{
		return (null);
	}
}
