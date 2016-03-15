package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

/**
 * Created by CLAUDIO on 15/3/2016.
 */
public class ExpresionCaracter implements IExpresion  {

    private String caracter;

    public ExpresionCaracter(String caracter)
    {
        this.caracter = caracter;
    }

    public void interpret(Stack<String> pilaCadenas)
    {
        pilaCadenas.push(caracter);
    }

}
