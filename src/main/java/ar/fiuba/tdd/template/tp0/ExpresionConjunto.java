package ar.fiuba.tdd.template.tp0;

import java.util.Set;
import java.util.Stack;

/**
 * Created by CLAUDIO on 15/3/2016.
 */
public class ExpresionConjunto implements IExpresion {

    //region Atributos
    private final Set<Character> contenidoConjunto;
    //endregion

    //region Constructor
    public ExpresionConjunto(Set<Character> contenidoConjunto) {
        this.contenidoConjunto = contenidoConjunto;
    }
    //endregion

    //region Metodos

    public void interpret(Stack<Character> pilaCadena) {
        pilaCadena.push((Character) getContenidoConjunto().toArray()[RandomUtil.obtenerNumeroAleatorio(1, getContenidoConjunto().size() - 1)]);
    }

    public Set<Character> getContenidoConjunto() {
        return contenidoConjunto;
    }

    //endregion


}