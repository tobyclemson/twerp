package twerp.lang.interpreter;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import twerp.lang.elements.ArithmeticExpression;
import twerp.lang.grammar.TwerpBaseVisitor;
import twerp.lang.grammar.TwerpParser;

public class TwerpInterpreter extends TwerpBaseVisitor<ArithmeticExpression> {
    @Override
    public ArithmeticExpression visitExpression(@NotNull TwerpParser.ExpressionContext context) {
        Token leftOperand = context.DIGIT(0).getSymbol();
        Token binaryOperator = context.BINARYOP().getSymbol();
        Token rightOperand = context.DIGIT(1).getSymbol();
        return new ArithmeticExpression(leftOperand, rightOperand, binaryOperator);
    }
}
