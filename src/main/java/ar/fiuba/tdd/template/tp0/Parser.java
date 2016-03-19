package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by CLAUDIO on 19/3/2016.
 */
class Parser {

    private final Lexer lexer;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
    }

    public List<String> parse(int numberOfResults) throws Exception {

        Stack<Character> context = new Stack<>();
        IExpresion expresion = lexer.siguienteExpresion();

        List<String> salida = new ArrayList<>();
        for (int i = 1; i <= numberOfResults; i++) {
            StringBuffer result = new StringBuffer();

            while (expresion != null) {
                expresion.interpret(context);
                expresion = lexer.siguienteExpresion();
            }

            for (Character character : context) {
                result.append(character);
            }

            salida.add(result.toString());
        }

        return salida;
    }
}

