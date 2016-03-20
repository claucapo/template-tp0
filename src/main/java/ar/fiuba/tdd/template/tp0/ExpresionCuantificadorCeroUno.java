package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

/**
 * Clase ExpresionCuanificadorCeroUno.
 */
public class ExpresionCuantificadorCeroUno implements IExpresion {

    //region Constructor

    /**
     * Instantiates a new Expresion cuantificador cero uno.
     */
    public ExpresionCuantificadorCeroUno() {

    }
    //endregion

    //region Metodos

    /**
     * Metodo interpret.
     *
     * @param pilaCadenas Pila con los elementos del cuantificador
     */
    public void interpret(Stack<Character> pilaCadenas) throws Exception {
        int numeroAleatorio = RandomUtil.obtenerNumeroAleatorio(0, 1);
        if (numeroAleatorio == 1) {
            if (pilaCadenas.size() == 0) {
                throw new Exception("Regexp mal formada.");
            }
            Character caracter = pilaCadenas.pop();
            pilaCadenas.push(caracter);
        }
    }

    //endregion
}
