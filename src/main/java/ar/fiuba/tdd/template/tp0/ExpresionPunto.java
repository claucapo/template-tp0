package ar.fiuba.tdd.template.tp0;

import java.util.Stack;


/**
 * The type Expresion punto.
 */
public class ExpresionPunto implements IExpresion {

    //region Metodos

    public void interpret(Stack<Character> pilaCadenas) {
        int numeroAleatorio = RandomUtil.obtenerNumeroAleatorio(32, 255);
        char randomNum = (char) (numeroAleatorio);
        pilaCadenas.push(randomNum);
    }

    //endregion

}
