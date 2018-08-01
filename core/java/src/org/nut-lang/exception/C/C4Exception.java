package exception.C;

import exception.NutException;

public class C4Exception extends NutException
{
	public C4Exception(int line, int column, String message)
	{
		super(line, column, "Data Types cannot be defined recursively : " + message);
	}
}
