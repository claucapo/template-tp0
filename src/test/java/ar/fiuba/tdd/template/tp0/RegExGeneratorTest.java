package ar.fiuba.tdd.template.tp0;

import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class RegExGeneratorTest {

    private static final int MAXLENGTH;

    static {
        MAXLENGTH = 5;
    }

    private boolean validate(String regEx) throws Exception {
        RegExGenerator generator = new RegExGenerator(MAXLENGTH);
        List<String> results = generator.generate(regEx, 1);
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

    @Test
    public void testAnyCharacter() throws Exception {
        assertTrue(validate("."));
    }

    @Test
    public void testMultipleCharacters() throws Exception {
        assertTrue(validate("..."));
    }

    @Test(expected = Exception.class)
    public void testLiteral() throws Exception {
        assertTrue(validate("\\@"));
    }

    @Test(expected = Exception.class)
    public void testLiteralDotCharacter() throws Exception {
        assertTrue(validate("\\@.."));
    }

    @Test(expected = Exception.class)
    public void testZeroOrOneCharacter() throws Exception {
        assertTrue(validate("\\@.h?"));
    }

    @Test
    public void testCharacterSet() throws Exception {
        assertTrue(validate("[abc]"));
    }

    @Test
    public void testCharacterSetWithQuantifiers() throws Exception {
        assertTrue(validate("[abc]+"));
    }

    // Tests Agregados
    @Test
    public void testCuantificadorCeroMuchosJuntoConExpresionPunto() throws Exception {
        assertTrue(validate(".*"));
    }

}
