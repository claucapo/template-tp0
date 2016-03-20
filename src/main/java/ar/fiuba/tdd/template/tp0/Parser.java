package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * The type Parser.
 */
class Parser {

    //region Atributos

    private final Lexer lexer;

    //endregion

    //region Constructor

    /**
     * Instancia un nuevo Objeto Parser
     *
     * @param lexer lexer
     */
    public Parser(Lexer lexer) {
        this.lexer = lexer;
    }

    //endregion

    //region Metodos

    /**
     * Metodo Parser
     *
     * @param numberOfResults El numero de resultados
     * @return la lista de salida
     * @throws Exception retorna exception si esta mal formada la regular expresion
     */
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

    //endregion
}

