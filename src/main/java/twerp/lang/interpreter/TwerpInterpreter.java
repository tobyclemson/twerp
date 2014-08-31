package twerp.lang.interpreter;

import org.antlr.v4.runtime.misc.NotNull;
import twerp.lang.elements.ArithmeticExpression;
import twerp.lang.elements.BinaryOperator;
import twerp.lang.elements.NumericExpression;
import twerp.lang.grammar.TwerpBaseVisitor;
import twerp.lang.grammar.TwerpParser;

public class TwerpInterpreter extends TwerpBaseVisitor<ArithmeticExpression> {
    @Override
    public ArithmeticExpression visitExpression(@NotNull TwerpParser.ExpressionContext context) {
        NumericExpression leftOperand = new NumericExpression(context.DIGIT(0).getText());
        NumericExpression rightOperand = new NumericExpression(context.DIGIT(1).getText());
        BinaryOperator binaryOperator = BinaryOperator.fromSign(context.BINARYOP().getText());

        return new ArithmeticExpression(leftOperand, rightOperand, binaryOperator);
    }
}
