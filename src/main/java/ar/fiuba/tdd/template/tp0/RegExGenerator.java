package ar.fiuba.tdd.template.tp0;

import java.util.List;

class RegExGenerator {

    private final int maxLength;

    public RegExGenerator(int maxLength) {
        this.maxLength = maxLength;
    }

    public List<String> generate(String regEx, int numberOfResults) throws Exception {
        Lexer lexer = new Lexer(regEx, maxLength);
        Parser parser = new Parser(lexer);
        return parser.parse(numberOfResults);

    }
}