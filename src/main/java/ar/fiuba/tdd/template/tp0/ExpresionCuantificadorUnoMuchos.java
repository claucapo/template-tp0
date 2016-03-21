package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

/**
 * The type Expresion cuantificador uno muchos.
 */
public class ExpresionCuantificadorUnoMuchos implements IExpresion {

    //region Atributos

    private final int maximo;

    //endregion

    //region Constructor

    /**
     * Instantiates a new Expresion cuantificador uno muchos.
     *
     * @param maximo the maximo
     */
    public ExpresionCuantificadorUnoMuchos(int maximo) {
        this.maximo = maximo;
    }

    //endregion

    //region Metodos

    /**
     * Instantiates a new Expresion cuantificador uno muchos.
     *
     * @param pilaCadena pilaCadena
     */
    public void interpret(Stack<Character> pilaCadena) throws Exception {
        int numeroAleatorio = RandomUtil.obtenerNumeroAleatorio(0, 1);
        new Validacion(pilaCadena).validar();
        if (numeroAleatorio == 0) {
            Character caracter = pilaCadena.pop();
            int maximoAleatorio = RandomUtil.obtenerNumeroAleatorio(1, maximo);
            for (int i = 1; i <= maximoAleatorio; i++) {
                pilaCadena.push(caracter);
            }
        } else {
            Character caracter = pilaCadena.pop();
            pilaCadena.push(caracter);
        }

    }


    //endregion
}
