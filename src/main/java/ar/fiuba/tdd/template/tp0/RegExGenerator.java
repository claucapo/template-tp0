package ar.fiuba.tdd.template.tp0;

import java.util.List;

/**
 * Clase RegExGenerator.
 */
class RegExGenerator {

    //region Atributos

    private final int maxLength;

    //endregion

    //region Constructor

    /**
     * Instancia un nuevo Objeto RegExGeneratos.
     *
     * @param maxLength maximo generador
     */
    public RegExGenerator(int maxLength) {
        this.maxLength = maxLength;
    }

    //endregion

    //region Metodos

    /**
     * Genera la lista de resultados.
     *
     * @param regEx           regular expresion
     * @param numberOfResults el numero de resultados
     * @return lista de salida
     * @throws Exception retorna exception si la regular expresion esta mal formada.
     */
    public List<String> generate(String regEx, int numberOfResults) throws Exception {
        Lexer lexer = new Lexer(regEx, maxLength);
        Parser parser = new Parser(lexer);
        return parser.parse(numberOfResults);

    }

    //endregion
}