package ar.fiuba.tdd.template.tp0;

import java.util.Random;
import java.util.Stack;

/**
 * Created by CLAUDIO on 15/3/2016.
 */
public class ExpresionPunto implements IExpresion {

    //region Metodos
    public void interpret(Stack<Character> pilaCadenas)
    {
        Random rn = new Random();
        int maximo = 255;
        int minimo = 32;
        int n = maximo - minimo + 1;
        int i = rn.nextInt() % n;
        char randomNum =  (char)(minimo + i);
        pilaCadenas.push(randomNum);
    }
    //endregion

}
