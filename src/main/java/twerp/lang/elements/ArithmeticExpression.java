package twerp.lang.elements;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.antlr.v4.runtime.Token;

@Value
public class ArithmeticExpression {
    Token leftOperand;
    Token rightOperand;
    Token binaryOperator;

    public Number evaluate() {
        return Integer.parseInt(leftOperand.getText()) + Integer.parseInt(rightOperand.getText()) ;
    }
}
