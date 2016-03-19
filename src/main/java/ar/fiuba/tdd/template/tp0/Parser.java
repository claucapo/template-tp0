package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by CLAUDIO on 19/3/2016.
 */
public class Parser {

    private Lexer lexer;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
    }

    public List<String> parse() throws Exception {

        Stack<Character> context = new Stack<Character>();
        IExpresion expresion = lexer.siguienteExpresion();
        List<String> salida = new ArrayList<>();
        String result = "";

        while (expresion != null) {
            expresion.interpret(context);
            expresion = lexer.siguienteExpresion();
        }

        for (Character character : context) {
            result += character;
        }

        salida.add(result);
        return salida;
    }
}

