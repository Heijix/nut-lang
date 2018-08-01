package exception.B;

import exception.NutException;

public class B1Exception extends NutException
{
	public B1Exception(int line, int column, String message)
	{
		super(line, column, "Root Object has to be set explicitly with '@', and all objects that remains in the root scope need a alias id : " + message);
	}
}
