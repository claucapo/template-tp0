package ar.fiuba.tdd.template.tp0;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CLAUDIO on 15/3/2016.
 */
public enum ExpresionFactoryEnum {

        CUANTIFICADOR_CERO_MUCHOS("*"){
            @Override
            public IExpresion obtenerExpresion()
            {
                if(escape){
                    escape = false;
                    return  new ExpresionCaracter(token);
                }

                return new ExpresionCuantificadorCeroMuchos(8);
            }
        },
        CUANTIFICADOR_CERO_UNO("?")
        {
            @Override
            public IExpresion obtenerExpresion()
            {
                if(escape){
                    escape = false;
                    return  new ExpresionCaracter(token);
                }
                return new ExpresionCuantificadorCeroUno();
            }
        },
        CUANTIFICADOR_UNO_MUCHOS("+")
        {
            @Override
            public IExpresion obtenerExpresion()
            {
                if(escape){
                    escape = false;
                    return  new ExpresionCaracter(token);
                }
                return new ExpresionCuantificadorUnoMuchos(8);
            }

        },
        EXPRESION_PUNTO(".")
        {
            @Override
            public IExpresion obtenerExpresion()
            {
                if(escape){
                    escape = false;
                    return  new ExpresionCaracter(token);
                }
                return new ExpresionPunto();
            }
        },EXPRESION_ESCAPE("\\")
            {
                @Override
                public IExpresion obtenerExpresion()
                {
                    if(!escape){
                        escape = true;
                        return new ExpresionEscape();
                    }else{
                        escape = false;
                        return new ExpresionCaracter(token);
                    }

                }
            },EXPRESION_INICIO_CONJUNTO("[")
            {
                @Override
                public IExpresion obtenerExpresion()
                {
                    inicioConjunto = true;
                    conjunto = new ExpresionConjunto();
                    return new ExpresionEscape();
                }
            },EXPRESION_FIN_CONJUNTO("]")
            {
                @Override
                public IExpresion obtenerExpresion()
                {
                    inicioConjunto = false;
                    ExpresionConjunto salida = new ExpresionConjunto();
                    salida.setContenidoConjunto(conjunto.getContenidoConjunto());
                    conjunto = null;
                    return salida;
                }
            };

        private static final Map<String, ExpresionFactoryEnum> stringMap = new HashMap<String, ExpresionFactoryEnum>();

        static
        {
            for(ExpresionFactoryEnum expresion : values())
                stringMap.put(expresion.toString(), expresion);
        }

        private static boolean escape = false;
        private static boolean inicioConjunto = false;
        private static boolean finConjunto = false;
        private static ExpresionConjunto conjunto = null;

        private ExpresionFactoryEnum(String token)
        {
            this.token = token;
        }

        final String token;

        @Override
        public String toString()
        {
            return token;
        }

        public static ExpresionFactoryEnum fromToken(String token)
        {
            return stringMap.get(token);
        }

        public abstract IExpresion obtenerExpresion();

        public static IExpresion obtenerExpresionCaracter(String caracter)
        {
            if(inicioConjunto && null!=conjunto)
            {
                conjunto.getContenidoConjunto().add(caracter);
                return new ExpresionEscape();
            }  else if(caracter == "\\")
            {
                return new ExpresionEscape();
            } else
            {
                return new ExpresionCaracter(caracter);
            }

        }

}
