package twerp.lang.runtime;

import lombok.SneakyThrows;
import org.antlr.runtime.CharStream;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import twerp.lang.grammar.TwerpLexer;
import twerp.lang.grammar.TwerpParser;
import twerp.lang.interpreter.TwerpInterpreter;

import java.io.InputStream;

public class TwerpEvaluator {

    @SneakyThrows
    public TwerpPrintable evaluate(InputStream inputStream) {
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(inputStream);
        TwerpLexer twerpLexer = new TwerpLexer(antlrInputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(twerpLexer);

        TwerpParser twerpParser = new TwerpParser(tokenStream);

        Number evaluate = new TwerpInterpreter()
                .visitExpression(twerpParser.expression())
                .evaluate();

        return new TwerpPrintable(evaluate);
    }
}
