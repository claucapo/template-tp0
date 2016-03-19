package ar.fiuba.tdd.template.tp0;

import java.util.Random;

/**
 * Created by CLAUDIO on 19/3/2016.
 */
public class RandomUtil {
    public static int obtenerNumeroAleatorio(int minimo, int maximo) {
        Random random = new Random();
        int interval = maximo - minimo + 1;
        int number = minimo + Math.abs(random.nextInt()) % interval;
        return number;
    }
}
