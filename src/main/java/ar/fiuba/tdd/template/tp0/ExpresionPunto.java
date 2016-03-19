package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

/**
 * Created by CLAUDIO on 15/3/2016.
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
