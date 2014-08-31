package twerp.lang.elements;

import org.antlr.v4.runtime.Token;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ArithmeticExpressionTest {
    @Test
    public void sumsIntegersWhenBinaryOperatorIsPlus() throws Exception {
        // Given
        NumericExpression leftOperand = new NumericExpression("5");
        NumericExpression rightOperand = new NumericExpression("10");
        BinaryOperator binaryOperator = BinaryOperator.fromSign("+");

        ArithmeticExpression arithmeticExpression = new ArithmeticExpression(
                leftOperand, rightOperand, binaryOperator);

        // When
        Number result = arithmeticExpression.evaluate();

        // Then
        assertThat(result, is(15));
    }

    @Test
    public void subtractsIntegersWhenBinaryOperatorIsMinus() throws Exception {
        // Given
        NumericExpression leftOperand = new NumericExpression("10");
        NumericExpression rightOperand = new NumericExpression("5");
        BinaryOperator binaryOperator = BinaryOperator.fromSign("-");

        ArithmeticExpression arithmeticExpression = new ArithmeticExpression(
                leftOperand, rightOperand, binaryOperator);

        // When
        Number result = arithmeticExpression.evaluate();

        // Then
        assertThat(result, is(5));
    }
}
