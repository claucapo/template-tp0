package ar.fiuba.tdd.template.tp0;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        RegExGenerator regExGenerator = new RegExGenerator(5);
        try {
            String regexp = args[0];
            String numeroDeResultados = args[1];
            List<String> resultados = regExGenerator.generate(regexp, Integer.valueOf(numeroDeResultados));
            System.out.println("Regular Expresion:" + regexp);
            System.out.println("Resultados:");
            resultados.forEach((item) -> System.out.println(item));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

