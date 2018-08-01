package ast;

import exception.NutException;
import parser.type.NutType;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * This class corresponds to a 'Nut' object.
 * @author Heijix
 */
public class NutObject extends Nut {

    /**
     * A hashmap corresponding to each pair of key / Nut object, it is the content of the object.
     */
    private HashMap<String,Nut> table;

    /**
     * type of the object. If it isn't null, this corresponds to a data structure.
     */
    private NutType type;

    /**
     * General constructor for a boolean of 'Nut' object.
     * @param line line where the object is created
     * @param column column where the object is created
     * @param table A hashmap corresponding to each pair of key / Nut object, it is the content of the object.
     * @param type type of the object. If it isn't null, this corresponds to a data structure.
     */
    public NutObject(int line, int column, HashMap<String, Nut> table, NutType type) {
        super(line, column, "an object");
        this.table = table;
        this.type = type;
    }

    /**
     * It is a getter to the type of the object (data structure).
     * @return type of the object.
     */
    public NutType getNutType(){
        return this.type;
    }

    @Override
    public Nut getNutObject(String attribute) throws NutException {
        if(this.table.containsKey(attribute)){
            Nut res = this.table.get(attribute);
            if(res == null) return null;
            else{
                if(res instanceof NutObject){
                    return res;
                }
                else{
                    super.getNutObject(attribute);
                }
            }
        }
        else{
            throw new NutException(line,column,"This object doesn't contain the followed attribute : "+ attribute);
        }
        return null;
    }

    @Override
    public LinkedList<Nut> getNutArray(String attribute) throws NutException {
        if(this.table.containsKey(attribute)){
            Nut res = this.table.get(attribute);
            if(res == null) return null;
            else{
                if(res instanceof NutArray){
                    res.getNutArray();
                }
                else{
                    super.getNutArray(attribute);
                }
            }
        }
        else{
            throw new NutException(line,column,"This object doesn't contain the followed attribute : "+ attribute);


        }
        return null;
    }

    @Override
    public String getNutString(String attribute) throws NutException {
        if(this.table.containsKey(attribute)){
            Nut res = this.table.get(attribute);
            if(res == null) return null;
            else{
                if(res instanceof NutString){
                    res.getNutString();
                }
                else{
                    super.getNutString(attribute);
                }
            }
        }
        else{
            throw new NutException(line,column,"This object doesn't contain the followed attribute : "+ attribute);


        }
        return null;
    }

    @Override
    public boolean getNutBoolean(String attribute) throws NutException {
        if(this.table.containsKey(attribute)){
            Nut res = this.table.get(attribute);
            if(res == null) throw new NutException(line,column,"This value is null.");
            else{
                if(res instanceof NutBoolean){
                    res.getNutBoolean();
                }
                else{
                    super.getNutBoolean(attribute);
                }
            }
        }
        else{
            throw new NutException(line,column,"This object doesn't contain the followed attribute : "+ attribute);


        }
        return false;
    }

    @Override
    public char getNutInt8(String attribute) throws NutException {
        if(this.table.containsKey(attribute)){
            Nut res = this.table.get(attribute);
            if(res == null) throw new NutException(line,column,"This value is null.");
            else{
                if(res instanceof NutInt8){
                    res.getNutInt8();
                }
                else{
                    super.getNutInt8(attribute);
                }
            }
        }
        else{
            throw new NutException(line,column,"This object doesn't contain the followed attribute : "+ attribute);


        }
        return 0;
    }

    @Override
    public short getNutInt16(String attribute) throws NutException {
        if(this.table.containsKey(attribute)){
            Nut res = this.table.get(attribute);
            if(res == null) throw new NutException(line,column,"This value is null.");
            else{
                if(res instanceof NutInt16){
                    res.getNutInt16();
                }
                else{
                    super.getNutInt16(attribute);
                }
            }
        }
        else{
            throw new NutException(line,column,"This object doesn't contain the followed attribute : "+ attribute);


        }
        return 0;
    }

    @Override
    public int getNutInt32(String attribute) throws NutException {
        if(this.table.containsKey(attribute)){
            Nut res = this.table.get(attribute);
            if(res == null) throw new NutException(line,column,"This value is null.");
            else{
                if(res instanceof NutInt32){
                    res.getNutInt32();
                }
                else{
                    super.getNutInt32(attribute);
                }
            }
        }
        else{
            throw new NutException(line,column,"This object doesn't contain the followed attribute : "+ attribute);


        }
        return 0;
    }

    @Override
    public long getNutInt64(String attribute) throws NutException {
        if(this.table.containsKey(attribute)){
            Nut res = this.table.get(attribute);
            if(res == null) throw new NutException(line,column,"This value is null.");
            else{
                if(res instanceof NutInt64){
                    res.getNutInt64();
                }
                else{
                    super.getNutInt64(attribute);
                }
            }
        }
        else{
            throw new NutException(line,column,"This object doesn't contain the followed attribute : "+ attribute);
        }
        return 0;
    }

    @Override
    public float getNutFloat(String attribute) throws NutException {
        if(this.table.containsKey(attribute)){
            Nut res = this.table.get(attribute);
            if(res == null) throw new NutException(line,column,"This value is null.");
            else{
                if(res instanceof NutFloat){
                    res.getNutFloat();
                }
                else{
                    super.getNutFloat(attribute);
                }
            }
        }
        else{
            throw new NutException(line,column,"This object doesn't contain the followed attribute : "+ attribute);
        }
        return 0;
    }
}
