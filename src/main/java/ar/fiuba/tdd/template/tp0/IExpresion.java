package ar.fiuba.tdd.template.tp0;

import java.util.Stack;


/**
 * Interface Expresion.
 */
interface IExpresion {

    //region Metodos

    /**
     * Metodo Interpres
     *
     * @param pilaCadenas pilaCadenas
     */
    void interpret(Stack<Character> pilaCadenas) throws Exception;

    //endregion
}
