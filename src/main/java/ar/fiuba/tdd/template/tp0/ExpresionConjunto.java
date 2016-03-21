package ar.fiuba.tdd.template.tp0;

import java.util.Set;
import java.util.Stack;

/**
 * Clase Expresion Conjunto.
 * Implementa IExpresion
 */
public class ExpresionConjunto implements IExpresion {

    //region Atributos
    private final Set<Character> contenidoConjunto;
    //endregion

    //region Constructor

    /**
     * Instancia un nuevo objeto ExpresionConjunto.
     *
     * @param contenidoConjunto contenidoConjunto
     */
    public ExpresionConjunto(Set<Character> contenidoConjunto) {
        this.contenidoConjunto = contenidoConjunto;
    }

    //endregion

    //region Metodos

    /**
     * Metodo Interpret.
     *
     * @param pilaCadena Pila con los elementos del conjunto
     */
    public void interpret(Stack<Character> pilaCadena) {
        int index = RandomUtil.obtenerNumeroAleatorio(0, getContenidoConjunto().size() - 1);
        pilaCadena.push((Character) getContenidoConjunto().toArray()[index]);
    }

    /**
     * Metodo getContenidoConjunto.
     */
    private Set<Character> getContenidoConjunto() {
        return contenidoConjunto;
    }

    //endregion


}