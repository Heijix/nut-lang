package parser.grammar;

import ast.*;
import parser.analyzer.ValueEnv;
import parser.LookAhead;
import parser.NutParser;
import parser.Sym;
import parser.type.NutType;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Class corresponding to the omega grammar
 * @author Heijix
 */
public class OmegaGrammar
{
	private NutParser parser;
	private LookAhead reader;
	private ValueEnv valueEnv;
	private LambdaGrammar dataDefinitions;

	/**
	 * General constructor
	 * @param parser parser called iota grammar
	 * @param reader lookAHead for parsing the grammar
	 * @param dataDefinitions class of Lambda Grammar for parsing lambda elements
	 * @param valueEnv environment value class
	 */
	public OmegaGrammar(NutParser parser, LookAhead reader, LambdaGrammar dataDefinitions, ValueEnv valueEnv)
	{
		this.parser          = parser;
		this.reader          = reader;
		this.dataDefinitions = dataDefinitions;
		this.valueEnv        = valueEnv;
	}

	/**
	 * It fills the environment value with object variable and root object.
	 * @throws Exception Exception is thrown because :
	 * <ul>
	 *     <li>We can't declare more than one root object in the file</li>
	 *     <li>The object can't be overwriting</li>
	 *     <li>The object has a wrong structure</li>
	 * </ul>
	 */
	public void fillValueEnv() throws Exception
	{
		while (!this.reader.check(Sym.EOF))
		{
			Nut object;
			switch (this.reader.symbol())
			{
			case REF_DEFINE:
				this.reader.eat(Sym.REF_DEFINE);
				String name = this.reader.getString();
				this.reader.eat(Sym.NAME);
				this.reader.eat(Sym.R_SQ_BRACE);
				object = this.getValueExtension();
				this.valueEnv.addDataObject(name, object);
				break;

			case ROOT:
				this.reader.eat(Sym.ROOT);
				object = this.getValueExtension();
				this.valueEnv.changeRoot(object);
				break;

			default:
				object = this.getValueExtension();
				this.valueEnv.changeRoot(object);
				break;
			}
		}
	}

	/**
	 * Getter of a 'Nut' object represented a value
	 * @return a 'Nut' value
	 * @throws Exception Parsing problem
	 */
	protected Nut getValue() throws Exception
	{
		Nut value;

		if (this.reader.check(Sym.STRING_VALUE))
		{
			value = new NutString(this.reader.line(), this.reader.column(), this.reader.getString());
			this.reader.eat(Sym.STRING_VALUE);
			return (value);
		}
		else if (this.reader.check(Sym.BOOLEAN_VALUE))
		{
			value = new NutBoolean(this.reader.line(), this.reader.column(), this.reader.getBoolean());
			this.reader.eat(Sym.BOOLEAN_VALUE);
			return (value);
		}
		else if (this.reader.check(Sym.NUMBER) ||
				 this.reader.check(Sym.FLOAT_NUMBER))
		{
			return (this.getNumber());
		}
		else
		{
			return (this.getValueExtension());
		}
	}

	/**
	 * Getter of a 'Nut' value, and it can be a root value
	 * @return a 'Nut' value
	 * @throws Exception Parsing problem
	 */
	private Nut getValueExtension() throws Exception
	{
		if (this.reader.check(Sym.REF_ACCESS))
		{
			this.reader.eat(Sym.REF_ACCESS);
			String name = this.reader.getString();
			this.reader.eat(Sym.NAME);
			Nut value = this.valueEnv.getNutElement(name);
			this.reader.eat(Sym.R_SQ_BRACE);
			return (value);
		}
		else if (this.reader.check(Sym.NULL))
		{
			this.reader.eat(Sym.NULL);
			return (null);
		}
		else if (this.reader.check(Sym.L_SQ_BRACE))
		{
			return (this.getArray());
		}
		else
		{
			return (this.getObject());
		}
	}

	/**
	 * Getter of a 'Nut' value with a structure, it starts with '{' and finishes with '}'
	 * @return a 'Nut' object with a structure
	 * @throws Exception Parsing problem
	 */
	private Nut getObject() throws Exception
	{
		NutType type = null;

		if (!this.reader.check(Sym.L_BRACE))
		{
			type = this.dataDefinitions.getType();
		}
		int line   = this.reader.line();
		int column = this.reader.column();
		this.reader.eat(Sym.L_BRACE);
		HashMap <String, Nut> content = new HashMap <>();
		fillObjectContent(content);
		this.reader.eat(Sym.R_BRACE);
		return (new NutObject(line, column, content, type));
	}

	/**
	 * It fills the content of a 'Nut' object with a structure
	 * @param content content of the 'Nut' object
	 * @throws Exception Parsing problem
	 */
	private void fillObjectContent(HashMap <String, Nut> content) throws Exception
	{
		if (this.reader.check(Sym.STRING_VALUE) ||
			this.reader.check(Sym.NAME))
		{
			String name = this.reader.getString();
			this.reader.eat(this.reader.symbol());
			this.reader.eat(Sym.COLON);
			Nut value = this.getValue();
			content.put(name, value);
			if (this.reader.check(Sym.COMMA))
			{
				do
				{
					this.reader.eat(Sym.COMMA);
					name = this.reader.getString();
					this.reader.eat(this.reader.symbol());
					this.reader.eat(Sym.COLON);
					value = this.getValue();
					content.put(name, value);
				} while (this.reader.check(Sym.COMMA));
			}
			else
			{
				while (!this.reader.check(Sym.R_BRACE))
				{
					name = this.reader.getString();
					this.reader.eat(this.reader.symbol());
					this.reader.eat(Sym.COLON);
					value = this.getValue();
					content.put(name, value);
				}
			}
		}
	}

	/**
	 * Getter of a 'Nut' value corresponding to an array
	 * @return a 'Nut' object as an array
	 * @throws Exception Parsing problem
	 */
	private Nut getArray() throws Exception
	{
		int line   = this.reader.line();
		int column = this.reader.column();

		this.reader.eat(Sym.L_SQ_BRACE);
		LinkedList <Nut> content = new LinkedList <>();
		fillArrayContent(content);
		this.reader.eat(Sym.R_SQ_BRACE);
		return (new NutArray(line, column, content));
	}

	/**
	 * It fills the content of a 'Nut' object with a structure
	 * @param content content of the array
	 * @throws Exception Parsing problem
	 */
	private void fillArrayContent(LinkedList <Nut> content) throws Exception
	{
		content.add(this.getValue());
		if (this.reader.check(Sym.COMMA))
		{
			do
			{
				this.reader.eat(Sym.COMMA);
				content.add(this.getValue());
			} while (this.reader.check(Sym.COMMA));
		}
		else
		{
			while (!this.reader.check(Sym.R_SQ_BRACE))
			{
				content.add(this.getValue());
			}
		}
	}

	/**
	 * Getter of a 'Nut' value corresponding to a number
	 * @return a 'Nut' object as a number
	 * @throws Exception Parsing problem
	 */
	private Nut getNumber() throws Exception
	{
		if (this.reader.check(Sym.NUMBER))
		{
			Nut value = new NutInt64(this.reader.line(), this.reader.column(), this.reader.getLong());
			this.reader.eat(Sym.NUMBER);
			return (value);
		}
		else
		{
			int   line   = this.reader.line();
			int   column = this.reader.column();
			float value  = this.reader.getFloat();
			this.reader.eat(Sym.FLOAT_NUMBER);
			if (this.reader.check(Sym.EXP_MARKER))
			{
				this.reader.eat(Sym.EXP_MARKER);
				long exp = this.reader.getLong();
				if (exp > 255 || exp < -255)
				{
					throw new Exception("Wrong exponent.");
				}
				this.reader.eat(Sym.NUMBER);
				value = (float)(value * Math.pow(10, exp));
			}
			return (new NutFloat(line, column, value));
		}
	}
}
