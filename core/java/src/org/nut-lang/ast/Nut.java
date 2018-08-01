package ast;

import exception.NutException;

import java.util.LinkedList;

/**
 * This class is the main class that is used by user.
 * The parser return a 'Nut' object.
 * @author Heijix
 */
public abstract class Nut{

    /**
     * line where the object is created
     */
    protected int line;

    /**
     * column where the object is created
     */
    protected int column;

    /**
     * description of the object
     */
    private String description;

    /**
     * General constructor for all characteristics shared by all 'Nut' object.
     * These characteristic are shared by all type of 'Nut' object.
     * @param line line where the object is created
     * @param column column where the object is created
     * @param description description of the object
     */
    public Nut(int line, int column, String description) {
        this.line = line;
        this.column = column;
        this.description = description;
    }

    /**
     * It is a getter to have the 'Nut' object corresponding to the attribute.
     * @param attribute name of the attribute in the nut file
     * @return 'Nut' object corresponding to the attribute, if the attribute exists.
     * @throws NutException A NutException is thrown if :
     * <ul>
     *     <li>the attribute doesn't exist</li>
     *     <li>the attribute doesn't correspond to a 'Nut' object</li>
     * </ul>
     */
    public Nut getNutObject(String attribute) throws NutException{
        throw new NutException(line, column, "Wrong type is attempted. There is " + description + ".");
    }

    /**
     * It is a getter to have the content of an array corresponding to the attribute.
     * @param attribute name of the attribute in the nut file
     * @return LinkedList of 'Nut' object, content of the array, corresponding to the attribute, if the attribute exists.
     * @throws NutException A NutException is thrown if :
     * <ul>
     *     <li>the attribute doesn't exist</li>
     *     <li>the attribute doesn't correspond to an array</li>
     * </ul>
     */
    public LinkedList<Nut> getNutArray(String attribute) throws NutException{
        throw new NutException(line, column, "Wrong type is attempted. There is " + description + ".");
    }

    /**
     * It is a getter to have the content of the array if the object is an array
     * @return Content of the array
     * @throws NutException A NutException is thrown if the 'Nut' object isn't an array
     */
    public LinkedList<Nut> getNutArray() throws NutException{
        throw new NutException(line, column, "Wrong type is attempted. There is " + description + ".");
    }

    /**
     * It is a getter to have the string corresponding to the attribute.
     * @param attribute name of the attribute in the nut file
     * @return String corresponding to the attribute, if the attribute exists.
     * @throws NutException A NutException is thrown if :
     * <ul>
     *     <li>the attribute doesn't exist</li>
     *     <li>the attribute doesn't correspond to a string</li>
     * </ul>
     */
    public String getNutString(String attribute) throws NutException{
        throw new NutException(line, column, "Wrong type is attempted. There is " + description + ".");
    }

    /**
     * It is a getter to have the string if the object is a String
     * @return String corresponding to the object
     * @throws NutException A NutException is thrown if the 'Nut' object isn't a String
     */
    public String getNutString() throws NutException{
        throw new NutException(line, column, "Wrong type is attempted. There is " + description + ".");
    }

    /**
     * It is a getter to have the boolean corresponding to the attribute.
     * @param attribute name of the attribute in the nut file
     * @return Boolean corresponding to the attribute, if the attribute exists.
     * @throws NutException A NutException is thrown if :
     * <ul>
     *     <li>the attribute doesn't exist</li>
     *     <li>the attribute doesn't correspond to a boolean</li>
     * </ul>
     */
    public boolean getNutBoolean(String attribute) throws NutException{
        throw new NutException(line, column, "Wrong type is attempted. There is " + description + ".");
    }

    /**
     * It is a getter to have the boolean if the object is a Boolean
     * @return Boolean corresponding to the object
     * @throws NutException A NutException is thrown if the 'Nut' object isn't a Boolean
     */
    public boolean getNutBoolean() throws NutException{
        throw new NutException(line, column, "Wrong type is attempted. There is " + description + ".");
    }

    /**
     * It is a getter to have the char corresponding to the attribute.
     * @param attribute name of the attribute in the nut file
     * @return Char corresponding to the attribute, if the attribute exists.
     * @throws NutException A NutException is thrown if :
     * <ul>
     *     <li>the attribute doesn't exist</li>
     *     <li>the attribute doesn't correspond to a char</li>
     * </ul>
     */
    public char getNutInt8(String attribute) throws NutException{
        throw new NutException(line, column, "Wrong type is attempted. There is " + description + ".");
    }

    /**
     * It is a getter to have the char if the object is a Char
     * @return Char corresponding to the object
     * @throws NutException A NutException is thrown if the 'Nut' object isn't a Char
     */
    public char getNutInt8() throws NutException{
        throw new NutException(line, column, "Wrong type is attempted. There is " + description + ".");
    }

    /**
     * It is a getter to have the short corresponding to the attribute.
     * @param attribute name of the attribute in the nut file
     * @return Short corresponding to the attribute, if the attribute exists.
     * @throws NutException A NutException is thrown if :
     * <ul>
     *     <li>the attribute doesn't exist</li>
     *     <li>the attribute doesn't correspond to a short</li>
     * </ul>
     */
    public short getNutInt16(String attribute) throws NutException{
        throw new NutException(line, column, "Wrong type is attempted. There is " + description + ".");
    }

    /**
     * It is a getter to have the short if the object is a Short
     * @return Short corresponding to the object
     * @throws NutException A NutException is thrown if the 'Nut' object isn't a Short
     */
    public short getNutInt16() throws NutException{
        throw new NutException(line, column, "Wrong type is attempted. There is " + description + ".");
    }

    /**
     * It is a getter to have the int corresponding to the attribute.
     * @param attribute name of the attribute in the nut file
     * @return Int corresponding to the attribute, if the attribute exists.
     * @throws NutException A NutException is thrown if :
     * <ul>
     *     <li>the attribute doesn't exist</li>
     *     <li>the attribute doesn't correspond to an int</li>
     * </ul>
     */
    public int getNutInt32(String attribute) throws NutException{
        throw new NutException(line, column, "Wrong type is attempted. There is " + description + ".");
    }

    /**
     * It is a getter to have the int if the object is an Int
     * @return Int corresponding to the object
     * @throws NutException A NutException is thrown if the 'Nut' object isn't an Int
     */
    public int getNutInt32() throws NutException{
        throw new NutException(line, column, "Wrong type is attempted. There is " + description + ".");
    }

    /**
     * It is a getter to have the long corresponding to the attribute.
     * @param attribute name of the attribute in the nut file
     * @return long corresponding to the attribute, if the attribute exists.
     * @throws NutException A NutException is thrown if :
     * <ul>
     *     <li>the attribute doesn't exist</li>
     *     <li>the attribute doesn't correspond to a long</li>
     * </ul>
     */
    public long getNutInt64(String attribute) throws NutException {
        throw new NutException(line, column, "Wrong type is attempted. There is " + description + ".");
    }

    /**
     * It is a getter to have the long if the object is a Long
     * @return Long corresponding to the object
     * @throws NutException A NutException is thrown if the 'Nut' object isn't a Long
     */
    public long getNutInt64() throws NutException {
        throw new NutException(line, column, "Wrong type is attempted. There is " + description + ".");
    }

    /**
     * It is a getter to have the float corresponding to the attribute.
     * @param attribute name of the attribute in the nut file
     * @return Float corresponding to the attribute, if the attribute exists.
     * @throws NutException A NutException is thrown if :
     * <ul>
     *     <li>the attribute doesn't exist</li>
     *     <li>the attribute doesn't correspond to a float</li>
     * </ul>
     */
    public float getNutFloat(String attribute) throws NutException {
        throw new NutException(line, column, "Wrong type is attempted. There is " + description + ".");
    }

    /**
     * It is a getter to have the float if the object is a Float
     * @return Float corresponding to the object
     * @throws NutException A NutException is thrown if the 'Nut' object isn't a Float
     */
    public float getNutFloat() throws NutException {
        throw new NutException(line, column, "Wrong type is attempted. There is " + description + ".");
    }

}