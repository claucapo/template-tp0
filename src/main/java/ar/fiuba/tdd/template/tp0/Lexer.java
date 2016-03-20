package ar.fiuba.tdd.template.tp0;

import java.util.HashSet;
import java.util.Set;


/**
 * Lexer.
 * Clase Lexer
 * Implementa el Patron Lexer
 */
class Lexer {

    //region Atributos

    private final String cadenaRegexp;
    private final int maxLength;
    private int offset = 0;

    //endregion

    //region Constructor

    /**
     * Instancia un nuevo Objeto Lexer
     *
     * @param cadenaRegexp regular expression
     * @param maxLength    maximo generador de caracteres
     */
    public Lexer(String cadenaRegexp, int maxLength) {
        this.cadenaRegexp = cadenaRegexp;
        this.maxLength = maxLength;
    }

    //endregion

    //region Metodos

    /**
     * Siguiente expresion expresion.
     *
     * @return expresion
     * @throws Exception exception
     */
    public IExpresion siguienteExpresion() throws Exception {

        Character caracter = siguienteCaracter();
        IExpresion expresion;

        if (caracter == null) {
            expresion = null;
        } else if (caracter == '[') {

            Set<Character> conjunto = new HashSet<>();
            caracter = siguienteCaracter();

            while (caracter != null && caracter != ']') {
                conjunto.add(caracter);
                caracter = siguienteCaracter();
            }

            if (caracter == null) {
                throw new Exception("Regexp mal formada.");
            }

            expresion = new ExpresionConjunto(conjunto);


        } else if (ExpresionFactoryEnum.fromToken(caracter) != null) {
            expresion = ExpresionFactoryEnum.fromToken(caracter).obtenerExpresion(maxLength);
        } else {

            if (caracter == '\\') {

                caracter = siguienteCaracter();

                if (ExpresionFactoryEnum.fromToken(caracter) != null) {
                    expresion = ExpresionFactoryEnum.fromToken(caracter).obtenerExpresion(maxLength);
                } else if (caracter == '\\') {
                    expresion = ExpresionFactoryEnum.obtenerExpresionCaracter(caracter);
                } else {
                    throw new Exception("Regexp mal formada.");
                }

            } else {
                expresion = ExpresionFactoryEnum.obtenerExpresionCaracter(caracter);
            }
        }

        return expresion;
    }

    private Character siguienteCaracter() {

        Character salida = null;
        int length = cadenaRegexp.length();

        if (offset < length) {
            salida = cadenaRegexp.charAt(offset);
            offset++;
        }

        return salida;
    }

    //endregion Metodos
}
