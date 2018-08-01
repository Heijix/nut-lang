package exception.C;

import exception.NutException;

public class C5Exception extends NutException
{
	public C5Exception(int line, int column, String message)
	{
		super(line, column, "We cannot overwrite a Data Type already defined in imported file : " + message);
	}
}
