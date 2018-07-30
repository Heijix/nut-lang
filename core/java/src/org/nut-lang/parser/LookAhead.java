package parser;

import jflex.Lexer;
import exception.L.L3Exception;
import parser.token.*;

/**
 * Class to manage and use Token class
 * during parsing.
 * @author Heijix
 */
public class LookAhead {


    private Token current;
    private Lexer lexer;



    /***************
     * Constructor *
     ****************/

    /**
     * General constructor
     * @param lexer lexer generate by JFlex
     * @throws Exception if the file is empty
     */
    protected LookAhead (Lexer lexer) throws Exception {
        this.lexer = lexer;
        this.current = lexer.yylex();
    }



    /**********
     * Reader *
     **********/

    /**
     * Verify if the token is good
     * @param symbol to compare with current
     * @return true if token and current are the same
     */
    public boolean check (Sym symbol) {
        return current.getSymbol() == symbol;
    }


    /**
     *  Eat the current token if it's the right symbol
     * @param symbol symbol send by the parser
     * @throws L3Exception if it's a wrong symbol
     */
    public void eat (Sym symbol) throws Exception {
        if (!check(symbol)) {
            throw new L3Exception(current.getLine(), current.getColumn(), current.getSymbol().toString());
        }
        this.current = lexer.yylex();
    }



    /***********
     * Getters *
     ***********/

    /** Get the token line */
    public int line () {
        return current.getLine();
    }

    /** Get the token column */
    public int column () {
        return current.getColumn();
    }

    /** Get the token column */
    public Sym symbol () {
        return current.getSymbol();
    }



    /******************
     * Tokens' intels *
     *****************/

    /**
     * Getter
     * @return BooleanToken value
     * @throws Exception if it's not the right token
     */
    public boolean getBoolean () throws Exception {
        if (current instanceof  BooleanToken ) {
            return  ((BooleanToken)current).getValue();
        }
        throw new Exception ("Type error");
    }

    /**
     * Getter
     * @return StringToken value
     * @throws Exception if it's not the right token
     */
    public String getString () throws Exception {
        if (current instanceof StringToken) {
            return ((StringToken) current).getValue();
        }
        throw new Exception("Type error");
    }

    /**
     * Getter
     * @return FloatToken value
     * @throws Exception if it's not the right token
     */
    public float getFloat () throws Exception {
        if (current instanceof FloatToken) {
            return ((FloatToken)current).getValue();
        }
        throw new Exception("Type error");
    }

    /**
     * Getter
     * @return NumberToken value
     * @throws Exception if it's not the right token
     */
    public long getLong () throws Exception {
        if (current instanceof FloatToken) {
            return ((NumberToken)current).getValue();
        }
        throw new Exception("Type error");
    }


}
