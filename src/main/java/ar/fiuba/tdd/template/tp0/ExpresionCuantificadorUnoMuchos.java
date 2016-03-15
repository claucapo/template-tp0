package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

/**
 * Created by CLAUDIO on 15/3/2016.
 */
public class ExpresionCuantificadorUnoMuchos implements IExpresion {

    private int maximo;

    public ExpresionCuantificadorUnoMuchos(int maximo)
    {
        this.maximo = maximo;
    }
    public void interpret(Stack<String> s)
    {
        String caracter = s.pop();
        String salida = "";
        for(int i=1;i<=maximo;i++)
        {
            salida+=caracter;
        }
        s.push(salida);
    }
}
