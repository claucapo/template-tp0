package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by CLAUDIO on 15/3/2016.
 */
public class ExpresionConjunto  implements IExpresion {

    private List<String> contenidoConjunto = new ArrayList<String>();

    public void interpret(Stack<String> s) {
        for (String item : contenidoConjunto) {
            s.push(item);
        }
    }

    public List<String> getContenidoConjunto() {
        return contenidoConjunto;
    }

    public void setContenidoConjunto(List<String> contenidoConjunto) {
        this.contenidoConjunto = contenidoConjunto;
    }
}