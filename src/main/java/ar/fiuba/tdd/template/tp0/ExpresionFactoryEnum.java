package ar.fiuba.tdd.template.tp0;

import java.util.HashMap;
import java.util.Map;


/**
 * Enumerador ExpresionFactoryEnum
 * Patron Type Safe Factory
 * Devuelve instancias de Expresion segun el caracter.
 */
public enum ExpresionFactoryEnum {


    //region Enumeradores

    /**
     * Cuantificador cero muchos.
     */
    CUANTIFICADOR_CERO_MUCHOS("*") {
        @Override
        public IExpresion obtenerExpresion(int maxLength) {
            return new ExpresionCuantificadorCeroMuchos(maxLength);
        }
    },
    /**
     * Cuantificador cero uno.
     */
    CUANTIFICADOR_CERO_UNO("?") {
        @Override
        public IExpresion obtenerExpresion(int maxLength) {
            return new ExpresionCuantificadorCeroUno();
        }
    },
    /**
     * Cuantificador uno muchos.
     */
    CUANTIFICADOR_UNO_MUCHOS("+") {
        @Override
        public IExpresion obtenerExpresion(int maxLength) {
            return new ExpresionCuantificadorUnoMuchos(maxLength);
        }

    },
    /**
     * Expresion punto.
     */
    EXPRESION_PUNTO(".") {
        @Override
        public IExpresion obtenerExpresion(int maxLength) {
            return new ExpresionPunto();
        }
    };

    //endregion


    //region Atributos

    private static final Map<String, ExpresionFactoryEnum> mapaCaracteres = new HashMap<>();

    static {
        for (ExpresionFactoryEnum expresion : values())
            mapaCaracteres.put(expresion.token, expresion);
    }

    /**
     * Token.
     */
    final String token;
    //endregion

    //region Constructor


    ExpresionFactoryEnum(String token) {
        this.token = token;
    }

    //endregion


    //region Metodos

    /**
     * Obtiene una instancia Enum de un caracter
     *
     * @param token token
     * @return instancia enum factory
     */
    public static ExpresionFactoryEnum fromToken(Character token) {
        return mapaCaracteres.get(token.toString());
    }

    /**
     * Obtiene una instancia de Expresion Caracter
     *
     * @param caracter caracter
     * @return Objeto Expresion
     */
    public static IExpresion obtenerExpresionCaracter(Character caracter) {
        return new ExpresionCaracter(caracter);
    }

    /**
     * Metodo Abstracto Obtener Expresion
     *
     * @param maxLength maximo
     * @return objeto expresion
     */
    public abstract IExpresion obtenerExpresion(int maxLength);

    //endregion

}
