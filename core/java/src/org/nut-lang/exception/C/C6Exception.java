package exception.C;

import exception.NutException;

public class C6Exception extends NutException
{
	public C6Exception(int line, int column, String message)
	{
		super(line, column, "The default value has to respect the Type in Data Type Definition : " + message);
	}
}
