package twerp.lang;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import twerp.lang.grammar.TwerpLexer;
import twerp.lang.grammar.TwerpParser;
import twerp.lang.interpreter.TwerpInterpreter;

import java.io.IOException;

public class Main {
    public static void main(String... args) throws IOException {
        ANTLRFileStream sourceFile = new ANTLRFileStream(args[0]);
        TwerpLexer twerpLexer = new TwerpLexer(sourceFile);
        CommonTokenStream tokenStream = new CommonTokenStream(twerpLexer);

        TwerpParser twerpParser = new TwerpParser(tokenStream);

        System.out.println(new TwerpInterpreter()
                .visitExpression(twerpParser.expression())
                .evaluate());
    }
}
