package parser.analyzer;

import ast.Nut;
import parser.type.NutType;

import java.util.HashMap;

/**
 * This class contains environment values of the nut parser.
 * @author Heijix
 */
public class ValueEnv {

    /**
     * Hashmap that contains all pair : name / data structure.
     */
    private HashMap<String, NutType> dataDefinitions;

    /**
     * Hashmap that contains all pair : name / objects.
     */
    private HashMap<String, Nut> objects;

    /**
     * Root Nut object.
     */
    private Nut root;

    /**
     * A general constructor of ValueEnv.
     */
    public ValueEnv() {
        this.dataDefinitions = new HashMap<>();
        this.objects = new HashMap<>();
        this.root = null;
    }

    /**
     * It adds a data structure in ValueEnv.
     * @param name name of the data structure.
     * @param definition structure of the data structure
     * @return true if it is added, false otherwise.
     */
    public boolean addDataDefinition(String name, NutType definition){
        return false;
    }

    /**
     * It adds an object in ValueEnv.
     * @param name name of the object.
     * @param object structure of the object
     * @return true if it is added, false otherwise.
     */
    public boolean addDataObject(String name, Nut object){
        return false;
    }

    /**
     * It changes the root Nut object in ValueEnv.
     * @param object new root Nut object
     * @return true if it is changed, false otherwise.
     */
    public boolean changeRoot(Nut object){
        return false;
    }

    /**
     * It is a getter to a Nut object corresponding to 'name'.
     * @param name name of the object
     * @return 'Nut' object corresponding to the name
     */
    public Nut getNutElement(String name){
        return objects.get(name);
    }

    /**
     * It is a getter to a Nut type corresponding to 'name'.
     * @param name name of the type
     * @return 'NutType' object corresponding to the name
     */
    public NutType getNutType(String name){
        return dataDefinitions.get(name);
    }

}
