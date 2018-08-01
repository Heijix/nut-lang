package exception.C;

import exception.NutException;

public class C3Exception extends NutException
{
	public C3Exception(int line, int column, String message)
	{
		super(line, column, "You cannot define a Data Type, with a Data Type that is not defined yet : " + message);
	}
}
