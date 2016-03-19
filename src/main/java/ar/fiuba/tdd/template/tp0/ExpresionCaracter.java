package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

/**
 * Created by CLAUDIO on 15/3/2016.
 */
public class ExpresionCaracter implements IExpresion {

    //region Atributos
    private final Character caracter;
    //endregion

    //region Constructor
    public ExpresionCaracter(Character caracter) {
        this.caracter = caracter;
    }
    //endregion

    //region Metodos
    public void interpret(Stack<Character> pilaCadenas) {
        pilaCadenas.push(caracter);
    }
    //endregion

}
