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
        List<String> listaSalida = new ArrayList<String>();
        agregarElementosAlParserTree(regEx);
        generarSalida(numberOfResults, listaSalida);
        return listaSalida;

    }

    private void generarSalida(int numberOfResults, List<String> listaSalida) {
        for(int i=1;i<=numberOfResults;i++){
            Stack<String> context = procesarParserTree();
            String salida = "";
            for(String obj : context)
            {
                salida+=obj;
            }
            listaSalida.add(salida);
        }
    }

    private Stack<String> procesarParserTree() {
        Stack<String> context = new Stack<String>();
        for (IExpresion e : parseTree)
            e.interpret(context);
        return context;
    }

    private void agregarElementosAlParserTree(String regEx) {
        for (char ch: regEx.toCharArray())
        {
            String token = "" + ch;

            if (ExpresionFactoryEnum.fromToken(token) != null)
                parseTree.add(ExpresionFactoryEnum.fromToken(token).obtenerExpresion());
            else {
                parseTree.add(ExpresionFactoryEnum.obtenerExpresionCaracter(token));
            }

        }
    }

    private boolean isCuanficadorUnoMuchos(String token) {
        return token.equals("+");
    }

    private boolean isCuanficadorCeroMuchos(String token) {
        return token.equals("*");
    }

    private boolean isCuanficadorCeroUno(String token) {
        return token.equals("?");
    }

    private boolean isExpresionPunto(String token) {
        return token.equals(".");
    }
}