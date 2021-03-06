package ar.fiuba.tdd.template.tp0;

import java.util.HashSet;
import java.util.Set;


/**
 * Clase Lexer.
 * Implementa el Patron Lexer
 */
class Lexer {

    //region Atributos

    private final String cadenaRegexp;
    private final int maxLength;
    private int offset;

    //endregion

    //region Constructor

    /**
     * Instancia un nuevo Objeto Lexer.
     *
     * @param cadenaRegexp regular expression
     * @param maxLength    maximo generador de caracteres
     */
    public Lexer(String cadenaRegexp, int maxLength) {
        this.cadenaRegexp = cadenaRegexp;
        this.maxLength = maxLength;
        irAlPrincipio();
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
            expresion = expresionConjunto();
        } else if (ExpresionFactoryEnum.fromToken(caracter) != null) {
            expresion = ExpresionFactoryEnum.fromToken(caracter).obtenerExpresion(maxLength);
        } else {
            if (caracter == '\\') {
                expresion = expresionEscapeada();
            } else {
                expresion = ExpresionFactoryEnum.obtenerExpresionCaracter(caracter);
            }
        }

        return expresion;
    }

    private IExpresion expresionConjunto() throws Exception {

        Character caracter;
        Set<Character> conjunto = new HashSet<>();
        caracter = siguienteCaracter();

        while (caracter != null && caracter != ']') {
            conjunto.add(caracter);
            caracter = siguienteCaracter();
        }

        if (caracter == null) {
            throw new Exception("Regexp mal formada.");
        }

        return new ExpresionConjunto(conjunto);
    }

    private IExpresion expresionEscapeada() throws Exception {
        Character caracter = siguienteCaracter();

        IExpresion expresion;
        if (isCaracterEscapeable(caracter)) {
            expresion = ExpresionFactoryEnum.obtenerExpresionCaracter(caracter);
        } else {
            throw new Exception("Regexp mal formada.");
        }
        return expresion;
    }

    private boolean isCaracterEscapeable(Character caracter) {
        return ExpresionFactoryEnum.fromToken(caracter) != null || caracter == '\\' || caracter == '[' || caracter == ']';
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


    public void irAlPrincipio() {
        offset = 0;
    }

    //endregion Metodos
}
