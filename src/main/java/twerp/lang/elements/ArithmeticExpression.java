package twerp.lang.elements;

import lombok.Value;
import org.antlr.v4.runtime.Token;

@Value
public class ArithmeticExpression {
    NumericExpression leftOperand;
    NumericExpression rightOperand;
    BinaryOperator binaryOperator;

    public Number evaluate() {
        return binaryOperator.computes(leftOperand, rightOperand).evaluate();
    }
}
