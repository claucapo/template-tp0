package ar.fiuba.tdd.template.tp0;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CLAUDIO on 15/3/2016.
 */
public enum ExpresionFactoryEnum {


    //region Enumeradores
    CUANTIFICADOR_CERO_MUCHOS("*") {
        @Override
        public IExpresion obtenerExpresion(int maxLength) {
            return new ExpresionCuantificadorCeroMuchos(maxLength);
        }
    },
    CUANTIFICADOR_CERO_UNO("?") {
        @Override
        public IExpresion obtenerExpresion(int maxLength) {
            return new ExpresionCuantificadorCeroUno();
        }
    },
    CUANTIFICADOR_UNO_MUCHOS("+") {
        @Override
        public IExpresion obtenerExpresion(int maxLength) {
            return new ExpresionCuantificadorUnoMuchos(maxLength);
        }

    },
    EXPRESION_PUNTO(".") {
        @Override
        public IExpresion obtenerExpresion(int maxLength) {
            return new ExpresionPunto();
        }
    };
    //endregion


    //region Atributos
    private static final Map<String, ExpresionFactoryEnum> mapaCaracteres = new HashMap<String, ExpresionFactoryEnum>();

    static {
        for (ExpresionFactoryEnum expresion : values())
            mapaCaracteres.put(expresion.token, expresion);
    }

    final String token;
    //endregion

    //region Constructor

    private ExpresionFactoryEnum(String token) {
        this.token = token;
    }

    //endregion

    //region Metodos
    public static ExpresionFactoryEnum fromToken(Character token) {
        return mapaCaracteres.get(token.toString());
    }

    public static IExpresion obtenerExpresionCaracter(Character caracter) {
        return new ExpresionCaracter(caracter);
    }

    public abstract IExpresion obtenerExpresion(int maxLength);
    //endregion

}
