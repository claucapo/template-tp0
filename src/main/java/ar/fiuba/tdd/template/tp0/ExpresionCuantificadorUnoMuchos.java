package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

/**
 * Created by CLAUDIO on 15/3/2016.
 */
public class ExpresionCuantificadorUnoMuchos implements IExpresion {

    private int maximo;
    private ExpresionConjunto conjunto;

    public ExpresionCuantificadorUnoMuchos(int maximo) {
        this.maximo = maximo;
    }

    public ExpresionCuantificadorUnoMuchos(int maximo, ExpresionConjunto conjunto) {
        this.maximo = maximo;
        this.conjunto = conjunto;
    }

    public void interpret(Stack<Character> s) {
        if (null != conjunto) {
            int numeroAleatorio = RandomUtil.obtenerNumeroAleatorio(0, 1);
            if (numeroAleatorio == 1) {
                for (int i = 1; i <= maximo; i++) {
                    for (Character item : conjunto.getContenidoConjunto()
                            ) {
                        s.push(item);
                    }
                }
            } else {
                for (Character item : conjunto.getContenidoConjunto()
                        ) {
                    s.push(item);
                }
            }
        } else {
            int numeroAleatorio = RandomUtil.obtenerNumeroAleatorio(0, 1);
            if (numeroAleatorio == 1) {
                Character caracter = s.pop();

                for (int i = 1; i <= maximo; i++) {
                    s.push(caracter);
                }
            }
        }

    }
}
