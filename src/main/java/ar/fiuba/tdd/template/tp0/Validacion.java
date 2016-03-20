package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

/**
 * Clase Validacion.
 */
public class Validacion {
    private Stack<Character> pilaCadena;

    /**
     * Instancia nuevo Objeto Validacion.
     *
     * @param pilaCadena the pila cadena
     */
    public Validacion(Stack<Character> pilaCadena) {
        this.pilaCadena = pilaCadena;
    }

    /**
     * Metodo validar.
     *
     * @throws Exception the exception
     */
    public void validar() throws Exception {
        if (pilaCadena.empty()) {
            throw new Exception("Regexp mal formada.");
        }
    }
}