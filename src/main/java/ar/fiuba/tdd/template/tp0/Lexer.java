package ar.fiuba.tdd.template.tp0;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by CLAUDIO on 19/3/2016.
 */
public class Lexer {

    private String cadenaRegexp;
    private int maxLength;
    private int offset = 0;

    public Lexer(String cadenaRegexp, int maxLength) {
        this.cadenaRegexp = cadenaRegexp;
        this.maxLength = maxLength;
    }

    public IExpresion siguienteExpresion() throws Exception {

        Character caracter = siguienteCaracter();
        IExpresion expresion = null;

        if (caracter == null) {
        } else if (caracter == '[') {

            Set<Character> conjunto = new HashSet<Character>();
            caracter = siguienteCaracter();

            while (caracter != ']') {
                conjunto.add(caracter);
                caracter = siguienteCaracter();
            };

            expresion = new ExpresionConjunto(conjunto);


        }else if (ExpresionFactoryEnum.fromToken(caracter) != null) {
            expresion = ExpresionFactoryEnum.fromToken(caracter).obtenerExpresion(maxLength);
        } else {

            if (caracter == '\\') {

                caracter = siguienteCaracter();

                if (ExpresionFactoryEnum.fromToken(caracter) != null) {
                    expresion = ExpresionFactoryEnum.fromToken(caracter).obtenerExpresion(maxLength);
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
}
