package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

/**
 * Created by CLAUDIO on 15/3/2016.
 */
public class ExpresionCuantificadorCeroUno implements IExpresion {

    //region Atributos
    private ExpresionConjunto conjunto;
    //endregion

    //region Constructores
    public ExpresionCuantificadorCeroUno()
    {

    }

    public ExpresionCuantificadorCeroUno(ExpresionConjunto conjunto)
    {
        this.conjunto=conjunto;
    }
    //endregion

    //region Metodos
    public void interpret(Stack<Character> pilaCadenas)
    {
        if(null!=conjunto){
            int numeroAleatorio = RandomUtil.obtenerNumeroAleatorio(0,1);
            if(numeroAleatorio==1){
                for (Character item:conjunto.getContenidoConjunto()
                        ) {
                    pilaCadenas.push(item);
                }
            }
        }else {
            int numeroAleatorio = RandomUtil.obtenerNumeroAleatorio(0, 1);
            if (numeroAleatorio == 1) {
                Character caracter = pilaCadenas.pop();
                pilaCadenas.push(caracter);
            }

        }
    }
    //endregion
}
