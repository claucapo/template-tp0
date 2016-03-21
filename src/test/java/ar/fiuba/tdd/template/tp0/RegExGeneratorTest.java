package ar.fiuba.tdd.template.tp0;

import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

/**
 * Clase RegExGeneratorTest.
 */
public class RegExGeneratorTest {

    //region Atributos

    private static final int MAXLENGTH;

    static {
        MAXLENGTH = 5;
    }

    //endregion

    //region Metodos

    private boolean validate(String regEx) throws Exception {
        RegExGenerator generator = new RegExGenerator(MAXLENGTH);
        List<String> results = generator.generate(regEx, 5);
        // force matching the beginning and the end of the strings
        Pattern pattern = Pattern.compile("^" + regEx + "$");
        return results
                .stream()
                .reduce(true,
                    (acc, item) -> {
                        Matcher matcher = pattern.matcher(item);
                        return acc && matcher.find();
                    },
                    (item1, item2) -> item1 && item2);
    }

    //endregion

    //region Tests

    //region Test del Template
    /**
     * Test para regular expression de 1 caracter.
     *
     * @throws Exception the exception
     */
    @Test
    public void testAnyCharacter() throws Exception {
        assertTrue(validate("."));
    }

    /**
     * Test de regular expression de multiples caracteres.
     *
     * @throws Exception the exception
     */
    @Test
    public void testMultipleCharacters() throws Exception {
        assertTrue(validate("..."));
    }

    /**
     * Test de una regular expresion mal formada.
     *
     * @throws Exception the exception
     */
    @Test(expected = Exception.class)
    public void testLiteral() throws Exception {
        assertTrue(validate("\\@"));
    }

    /**
     * Test de otra regular expresion mal formada.
     *
     * @throws Exception the exception
     */
    @Test(expected = Exception.class)
    public void testLiteralDotCharacter() throws Exception {
        assertTrue(validate("\\@.."));
    }

    /**
     * Test de una regular expresion de 0 o 1 caracter.
     *
     * @throws Exception the exception
     */
    @Test(expected = Exception.class)
    public void testZeroOrOneCharacter() throws Exception {
        assertTrue(validate("\\@.h?"));
    }


    //endregion

    //region Tests Agregados
    /**
     * Test de una regular expresion con conjuntos.
     *
     * @throws Exception the exception
     */
    @Test
    public void testCharacterSet() throws Exception {
        assertTrue(validate("[abc]"));
    }

    /**
     * Test de una regular expresion con conjunto y cuantificador +.
     *
     * @throws Exception the exception
     */
    @Test
    public void testCharacterSetWithQuantifiers() throws Exception {
        assertTrue(validate("[abc]+"));
    }

    /**
     * Test cuantificador cero muchos junto con expresion punto.
     *
     * @throws Exception the exception
     */
    @Test
    public void testCuantificadorCeroMuchosJuntoConExpresionPunto() throws Exception {
        assertTrue(validate(".*"));
    }



    /**
     * Test escapear barra.
     *
     * @throws Exception the exception
     */
    @Test(expected = Exception.class)
    public void testInicioConjuntoSolo() throws Exception {
        assertTrue(validate("["));
    }

    /**
     * Cuantificador  Sin Caracter.
     *
     * @throws Exception the exception
     */
    @Test(expected = Exception.class)
    public void testCuantificadorSinCaracter() throws Exception {
        assertTrue(validate("+"));
    }

    /**
     * Conjunto de 5 caracteres.
     *
     * @throws Exception the exception
     */
    @Test
    public void testConjuntoDeCinco() throws Exception {
        assertTrue(validate("[abcde]"));
    }

    /**
     * Conjunto de 5 caracteres cero muchos.
     *
     * @throws Exception the exception
     */
    @Test
    public void testConjuntoDeCincoCeroMuchos() throws Exception {
        assertTrue(validate("[abcde]*"));
    }

    /**
     * Conjunto de 5 caracteres uno muchos.
     *
     * @throws Exception the exception
     */
    @Test
    public void testConjuntoDeCincoUnoMuchos() throws Exception {
        assertTrue(validate("[abcde]+"));
    }

    /**
     * Conjunto de 5 caracteres uno muchos.
     *
     * @throws Exception the exception
     */
    @Test
    public void testConjuntoDeCincoCeroUno() throws Exception {
        assertTrue(validate("[abcde]?"));
    }

    /**
     * 2 Conjuntos Seguidos.
     *
     * @throws Exception the exception
     */
    @Test
    public void testConjuntoDosConjuntos() throws Exception {
        assertTrue(validate("[abcde][abcde]"));
    }

    /**
     * Escape *.
     *
     * @throws Exception the exception
     */
    @Test
    public void testEscapeAsterico() throws Exception {
        assertTrue(validate("\\*"));
    }


    /**
     * Escape [.
     *
     * @throws Exception the exception
     */
    @Test
    public void testEscapeCorchete() throws Exception {
        assertTrue(validate("\\["));
    }

    /**
     * Escape ].
     *
     * @throws Exception the exception
     */
    @Test
    public void testEscapeCierreCorchete() throws Exception {
        assertTrue(validate("\\]"));
    }

    /**
     * Test escapear barra.
     *
     * @throws Exception the exception
     */
    @Test
    public void testEscapearBarra() throws Exception {
        assertTrue(validate("\\\\"));
    }

    /**
     * Test escapear ?.
     *
     * @throws Exception the exception
     */
    @Test
    public void testEscapearSignoPregunta() throws Exception {
        assertTrue(validate("\\?"));
    }

    /**
     * Test escapear +.
     *
     * @throws Exception the exception
     */
    @Test
    public void testEscapearSignoMas() throws Exception {
        assertTrue(validate("\\+"));
    }


    /**
     * Test Conjunto y Caracter.
     *
     * @throws Exception the exception
     */
    @Test
    public void testConjuntoYCaracter() throws Exception {
        assertTrue(validate("[ab]a"));
    }

    /**
     * Test Conjunto y Expresion Punto.
     *
     * @throws Exception the exception
     */
    @Test
    public void testConjuntoYExpresionPunto() throws Exception {
        assertTrue(validate("[ab]."));
    }

    /**
     * Test Expresion Punto y Expresion Cuantificador Cero Muchos.
     *
     * @throws Exception the exception
     */
    @Test
    public void testExpresionPuntoYExpresionCuantificadorCeroMuchos() throws Exception {
        assertTrue(validate(".*"));
    }


    /**
     * Test Expresion Punto y Expresion Cuantificador Uno Muchos.
     *
     * @throws Exception the exception
     */
    @Test
    public void testExpresionPuntoYExpresionCuantificadorUnoMuchos() throws Exception {
        assertTrue(validate(".+"));
    }

    //endregion

    //endregion

}
