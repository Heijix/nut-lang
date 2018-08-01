package exception;

public class NutException extends Exception
{
	protected int line, column;
	protected String message;

	public NutException(int line, int column, String message)
	{
		super("There is an exception at line " + line + " and at column " + column + " --> " + message);
		this.line    = line;
		this.column  = column;
		this.message = message;
	}
}
