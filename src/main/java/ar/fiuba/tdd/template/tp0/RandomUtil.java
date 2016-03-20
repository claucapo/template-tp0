package ar.fiuba.tdd.template.tp0;

import java.util.Random;


/**
 * Clase Random Util.
 * Clase util para los numeros aleatorios
 */
class RandomUtil {

    //region Metodos

    /**
     * Obtener Numero Aleatorio.
     *
     * @param minimo minimo
     * @param maximo maximo
     * @return numero aleatorio
     */
    public static int obtenerNumeroAleatorio(int minimo, int maximo) {
        Random random = new Random();
        int interval = maximo - minimo + 1;
        return minimo + random.nextInt() % interval;
    }

    //endregion
}
