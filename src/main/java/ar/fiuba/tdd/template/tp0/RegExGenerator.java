package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class RegExGenerator {

    private ArrayList<IExpresion> parseTree = new ArrayList<IExpresion>();
    private int maxLength;

    public RegExGenerator(int maxLength) {
        this.maxLength = maxLength;
    }

    public List<String> generate(String regEx, int numberOfResults) {

        for (char ch: regEx.toCharArray())
        {
            String token = "" + ch;

            if (token.equals("*"))
                parseTree.add( new ExpresionCuantificadorCeroMuchos(maxLength) );
            else if (token.equals("+"))
                parseTree.add( new ExpresionCuantificadorUnoMuchos(maxLength) );
            else if (token.equals("?"))
                parseTree.add( new ExpresionCuantificadorCeroUno() );
            else if (token.equals("."))
                parseTree.add( new ExpresionPunto() );
            else
                parseTree.add( new ExpresionCaracter(token) );
        }


        Stack<String> context = new Stack<String>();
        for (IExpresion e : parseTree)
            e.interpret(context);

        List<String> listaSalida = new ArrayList<String>();
        for(String obj : context)
        {
            listaSalida.add(obj);
        }

        return listaSalida;

    }
}