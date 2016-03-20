package ar.fiuba.tdd.template.tp0;

import java.util.Stack;


/**
 * Clase ExpresionCuantificadorCeroMuchos.
 * Implementa IExpresion
 */
public class ExpresionCuantificadorCeroMuchos implements IExpresion {

    //region Atributos
    private final int maximo;
    //endregion Atributos

    //region Constructor

    /**
     * Instantiates a new Expresion cuantificador cero muchos.
     *
     * @param maximo the maximo
     */
    public ExpresionCuantificadorCeroMuchos(int maximo) {
        this.maximo = maximo;
    }
    //endregion

    //region Metodos

    /**
     * Metodo interpret.
     *
     * @param pilaCadena Pila con los elementos del cuantificador
     */
    public void interpret(Stack<Character> pilaCadena) throws Exception {
        int numeroAleatorio = RandomUtil.obtenerNumeroAleatorio(0, 1);
        if (numeroAleatorio == 1) {
            new Validacion(pilaCadena).validar();
            Character caracter = pilaCadena.pop();

            for (int i = 1; i <= maximo; i++) {
                pilaCadena.push(caracter);
            }
        }

    }


    //endregion
}
