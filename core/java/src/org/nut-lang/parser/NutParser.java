package parser;


import ast.Nut;
import jflex.Lexer;
import parser.analyzer.NutAnalyzer;
import parser.analyzer.ValueEnv;
import parser.grammar.IotaGrammar;
import parser.grammar.LambdaGrammar;
import parser.grammar.OmegaGrammar;

import java.io.FileReader;
import java.util.LinkedList;

/**
 * Parser for nut-lang.
 * This parser create an abstract syntax tree which
 * allows developer to use this language in java.
 * @author Heijix
 */

public class NutParser {

    private FileReader file;
    private LinkedList<Exception> listOfException;
    private LookAhead reader;
    private IotaGrammar imports;
    private LambdaGrammar dataDefinitions;
    private OmegaGrammar objects;
    private ValueEnv valueEnv;
    private NutAnalyzer analyzer;

    /**
     * This function initializes all variable in function of a file pathname.
     * @param pathName a file pathname
     * @throws Exception The file is not known
     */
    private void constructData(String pathName) throws Exception{
        this.file = new FileReader(pathName);
        this.listOfException = new LinkedList<>();
        Lexer lex = new Lexer(this.file);
        this.valueEnv = new ValueEnv();
        this.reader = new LookAhead(lex);
        this.imports = new IotaGrammar(this, reader, valueEnv);
        this.dataDefinitions = new LambdaGrammar(this, reader, objects, valueEnv);
        this.objects = new OmegaGrammar(this, reader, dataDefinitions, valueEnv);
        this.imports.fillValueEnv();
        this.dataDefinitions.fillValueEnv();
        this.objects.fillValueEnv();
        this.analyzer = new NutAnalyzer(valueEnv);
    }

    /**
     * It recovers the 'Nut' object describing by the file.
     * @param pathName path to the nut file
     * @return the root 'Nut' object describing by the file
     * @throws Exception The file is not known
     */
    public Nut parse(String pathName) throws Exception {
        constructData(pathName);
        Nut result = analyzer.getNutResult();
        if(this.listOfException.isEmpty()) return result;
        else throw this.constructGlobalException();
    }

    /**
     * It is a getter to the root Nut object of 'pathname' file in the format described in the 'wantedObjectModel' file.
     * @param pathName path to the nut file
     * @param wantedObjectModel file where only one data structure is described.
     * @return root Nut object in the format of the data structure given.
     */
    public Nut parse(String pathName, String wantedObjectModel) throws Exception{
        constructData(pathName);
        Nut result = analyzer.getNutResult(wantedObjectModel);
        if(this.listOfException.isEmpty()) return result;
        else throw this.constructGlobalException();
    }

    /**
     * It is a getter to the root Nut object of 'pathname' file in the 'objectName' format described in the 'wantedObjectModel' file.
     * @param pathName path to the nut file
     * @param wantedObjectModel file where a lot of data structure are described.
     * @param objectName name of data structure
     * @return root Nut object in the format of 'objectName' given.
     */
    public Nut parse(String pathName, String wantedObjectModel, String objectName) throws Exception {
        constructData(pathName);
        Nut result = analyzer.getNutResult(wantedObjectModel, objectName);
        if(this.listOfException.isEmpty()) return result;
        else throw this.constructGlobalException();
    }

    /**
     * It verifies if the root Nut object of 'pathname' file is in the format described in the 'wantedObjectModel' file.
     * @param pathName path to the nut file
     * @param wantedObjectModel file where only one data structure is described.
     * @return true if root Nut object is in the format of the data structure given, false otherwise.
     */
    public boolean validate(String pathName, String wantedObjectModel) throws Exception {
        constructData(pathName);
        boolean result = analyzer.validateNutResult(wantedObjectModel);
        if (this.listOfException.isEmpty()){
            return result;
        }
        else{
            throw this.constructGlobalException();
        }
    }

    /**
     * It verifies if the root Nut object of 'pathname' file is in the 'objectName' format described in the 'wantedObjectModel' file.
      @param pathName path to the nut file
     * @param wantedObjectModel file where a lot of data structure are described.
     * @param objectName name of data structure
     * @return true if root Nut object is in the format of 'objectName' given, false otherwise.
     */
    public boolean validate(String pathName, String wantedObjectModel, String objectName) throws Exception {
        constructData(pathName);
        boolean result = analyzer.validateNutResult(wantedObjectModel, objectName);
        if (this.listOfException.isEmpty()){
            return result;
        }
        else{
            throw this.constructGlobalException();
        }
    }

    /**
     * We store all Exception that are thrown by the parser.
     * @param exception Exception that we need to store.
     */
    public void stockException(Exception exception){
        this.listOfException.add(exception);
    }

    /**
     * It assembles all stored exceptions in an unique Exception.
     * @return Exception contains other exception's messages.
     */
    private Exception constructGlobalException(){
        String globalMessage = "";
        for (Exception exception : listOfException){
            globalMessage += "\n"+exception.getMessage()+"\n";
        }
        return new Exception(globalMessage);
    }
}
