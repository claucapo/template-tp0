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
        if (numeroAleatorio == 0) {
            if (pilaCadena.size() == 0) {
                throw new Exception("Regexp mal formada.");
            }
            Character caracter = pilaCadena.pop();

            for (int i = 1; i <= maximo; i++) {
                pilaCadena.push(caracter);
            }
        } else {
            if (pilaCadena.size() == 0) {
                throw new Exception("Regexp mal formada.");
            }
            Character caracter = pilaCadena.pop();
            pilaCadena.push(caracter);
        }

    }

    //endregion
}
