package ar.fiuba.tdd.template.tp0;

import java.util.Stack;


/**
 * Clase ExpresionCaracter
 * Implementa IExpresioin
 */
public class ExpresionCaracter implements IExpresion {

    //region Atributos
    private final Character caracter;
    //endregion

    //region Constructor

    /**
     * Instancia un nuevo objeto ExpresionCaracter
     *
     * @param caracter caracter
     */
    public ExpresionCaracter(Character caracter) {
        this.caracter = caracter;
    }

    //endregion

    //region Metodos

    /**
     * Metodo interpret
     *
     * @param pilaCadenas pila de elementos a parsear
     */
    public void interpret(Stack<Character> pilaCadenas) {
        pilaCadenas.push(caracter);
    }

    //endregion

}
