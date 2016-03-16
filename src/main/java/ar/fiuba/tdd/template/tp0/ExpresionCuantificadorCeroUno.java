package ar.fiuba.tdd.template.tp0;

import java.util.Random;
import java.util.Stack;

/**
 * Created by CLAUDIO on 15/3/2016.
 */
public class ExpresionCuantificadorCeroUno implements IExpresion {
    public void interpret(Stack<String> pilaCadenas)
    {
        String caracter = pilaCadenas.pop();
        String salida = "";
        Random rn = new Random();
        int maximo = 1;
        int minimo = 0;
        int n = maximo - minimo + 1;
        int i = rn.nextInt() % n;
        int randomNum =  minimo + i;
        if(randomNum == 1)
            salida+=caracter;
        pilaCadenas.push(salida);
    }
}
