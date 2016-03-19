package ar.fiuba.tdd.template.tp0;

import java.util.Stack;

/**
 * Created by CLAUDIO on 15/3/2016.
 */
public class ExpresionCuantificadorCeroMuchos implements IExpresion {

    //region Atributos
    private int maximo;
    private ExpresionConjunto conjunto;
    //endregion Atributos

    //region Constructores
    public ExpresionCuantificadorCeroMuchos(int maximo)
    {
        this.maximo = maximo;
    }

    public ExpresionCuantificadorCeroMuchos(int maximo,ExpresionConjunto conjunto)
    {
        this.maximo = maximo;
        this.conjunto=conjunto;
    }
    //endregion

    //region Metodos
    public void interpret(Stack<Character> pilaCadena)
    {
        if(null!=conjunto){
            for(int i=1;i<=maximo;i++) {
                for (Character item:conjunto.getContenidoConjunto()
                     ) {
                    pilaCadena.push(item);
                }
            }
        }else{
            int numeroAleatorio = RandomUtil.obtenerNumeroAleatorio(0, 1);
            if (numeroAleatorio == 1) {
                Character caracter = pilaCadena.pop();

                for(int i=1;i<=maximo;i++)
                {
                    pilaCadena.push(caracter);
                }
            }
        }

    }
    //endregion
}
