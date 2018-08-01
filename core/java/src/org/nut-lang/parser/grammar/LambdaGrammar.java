package parser.grammar;

import parser.analyzer.ValueEnv;
import parser.LookAhead;
import parser.NutParser;
import parser.Sym;
import parser.type.NutListType;
import parser.type.NutNameType;
import parser.type.NutStructureType;
import parser.type.NutType;

/**
 * Class corresponding to the Lambda grammar
 * @author Heijix
 */
public class LambdaGrammar
{
	private NutParser parser;
	private LookAhead reader;
	private ValueEnv valueEnv;
	private OmegaGrammar objects;

	/**
	 * General constructor
	 * @param parser parser called iota grammar
	 * @param reader lookAHead for parsing the grammar
	 * @param objects class of Omega Grammar for parsing omega elements
	 * @param valueEnv environment value class
	 */
	public LambdaGrammar(NutParser parser, LookAhead reader, OmegaGrammar objects, ValueEnv valueEnv)
	{
		this.parser   = parser;
		this.reader   = reader;
		this.objects  = objects;
		this.valueEnv = valueEnv;
	}

	/**
	 * It fills the environment value with Alias type and Data type
	 * @throws Exception The data already exists or there is a parsing exception
	 */
	public void fillValueEnv() throws Exception
	{
		switch (this.reader.symbol())
		{
		case ALIAS:
			fillAlias();
			fillValueEnv();
			break;

		case DATA:
			fillData();
			fillValueEnv();
			break;

		default:
			break;
		}
	}

	/**
	 * It fills the environment value with Alias type
	 */
	private void fillAlias() throws Exception
	{
		this.reader.eat(Sym.ALIAS);
		String name = this.reader.getString();
		this.reader.eat(Sym.NAME);
		this.reader.eat(Sym.COLON_EQUAL);
		NutType type = getType();
		this.valueEnv.addDataDefinition(name, type);
	}

	/**
	 * parse and return a type element
	 * @return NutType element
	 * @throws Exception Unexpected type
	 */
	protected NutType getType() throws Exception
	{
		if (this.reader.check(Sym.NAME))
		{
			NutType type = new NutNameType(this.reader.getString());
			this.reader.eat(Sym.NAME);
			return (type);
		}
		else if (this.reader.check(Sym.LIST))
		{
			NutListType type = new NutListType();
			if (this.reader.check(Sym.L_ANGLE_BRACE))
			{
				fillGenericType(type);
			}
			return (type);
		}
		else if (this.reader.check(Sym.STRING) ||
				 this.reader.check(Sym.BOOLEAN) ||
				 this.reader.check(Sym.INT8) ||
				 this.reader.check(Sym.INT16) ||
				 this.reader.check(Sym.INT32) ||
				 this.reader.check(Sym.INT64) ||
				 this.reader.check(Sym.FLOAT))
		{
			NutType type = new NutType(this.reader.symbol());
			this.reader.eat(this.reader.symbol());
			return (type);
		}
		throw new Exception("Unexpected type.");
	}

	/**
	 * It fills the content of a list type
	 * @param type list type that will be filled
	 * @throws Exception The type already exists
	 */
	private void fillGenericType(NutListType type) throws Exception
	{
		this.reader.eat(Sym.L_ANGLE_BRACE);
		type.addType(this.getType());
		if (this.reader.check(Sym.COMMA))
		{
			do
			{
				this.reader.eat(Sym.COMMA);
				type.addType(this.getType());
			} while (this.reader.check(Sym.COMMA));
		}
		else
		{
			while (!this.reader.check(Sym.R_ANGLE_BRACE))
			{
				type.addType(this.getType());
			}
		}
		this.reader.eat(Sym.R_ANGLE_BRACE);
	}

	/**
	 * It fills the environment value with Data type
	 */
	private void fillData() throws Exception
	{
		this.reader.eat(Sym.DATA);
		NutStructureType data = new NutStructureType();
		String           name = this.reader.getString();
		this.reader.eat(Sym.NAME);
		this.reader.eat(Sym.COLON_EQUAL);
		fillDataStructure(data);
		this.valueEnv.addDataDefinition(name, data);
	}

	/**
	 * It fills the content of a data structure
	 * @param data data structure type that will be filled
	 * @throws Exception The type already exists
	 */
	private void fillDataStructure(NutStructureType data) throws Exception
	{
		do
		{
			this.reader.eat(Sym.DASH);
			NutType type = this.getType();
			this.reader.eat(Sym.COLON);
			String name = this.reader.getString();
			this.reader.eat(Sym.NAME);
			if (this.reader.check(Sym.EQUAL))
			{
				this.reader.eat(Sym.EQUAL);
				type.addDefaultValue(this.objects.getValue());
			}
			data.addVariable(name, type);
		} while (this.reader.check(Sym.DASH));
	}
}
