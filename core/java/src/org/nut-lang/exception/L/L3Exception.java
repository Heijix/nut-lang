package exception.L;

import exception.NutException;

public class L3Exception extends NutException
{
	public L3Exception(int line, int column, String message)
	{
		super(line, column, "Unexpected Character, match nothing in the grammar : " + message);
	}
}
