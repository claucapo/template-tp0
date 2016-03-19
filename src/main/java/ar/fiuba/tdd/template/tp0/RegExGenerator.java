package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;

public class RegExGenerator {

    private ArrayList<IExpresion> parseTree = new ArrayList<IExpresion>();
    private int maxLength;

    public RegExGenerator(int maxLength) {
        this.maxLength = maxLength;
    }

    public List<String> generate(String regEx, int numberOfResults) throws Exception {
        Lexer lexer = new Lexer(regEx, maxLength);
        Parser parser = new Parser(lexer);
        return parser.parse(numberOfResults);

    }
}