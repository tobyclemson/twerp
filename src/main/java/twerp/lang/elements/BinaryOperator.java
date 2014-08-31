package twerp.lang.elements;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import static org.javafunk.funk.Eagerly.firstMatching;
import static org.javafunk.funk.Literals.iterableFrom;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum BinaryOperator {
    PLUS("+") {
        @Override
        public NumericExpression computes(NumericExpression leftOperand, NumericExpression rightOperand) {
            return new NumericExpression(leftOperand.evaluate() + rightOperand.evaluate());
        }
    },
    MINUS("-") {
        @Override
        public NumericExpression computes(NumericExpression leftOperand, NumericExpression rightOperand) {
            return new NumericExpression(leftOperand.evaluate() - rightOperand.evaluate());
        }
    };

    String sign;

    BinaryOperator(String sign) {
        this.sign = sign;
    }

    public static BinaryOperator fromSign(String sign){
       return firstMatching(
               iterableFrom(BinaryOperator.values()),
               operator -> operator.sign.equals(sign))
               .get();
    }

    public abstract NumericExpression computes(NumericExpression leftOperand, NumericExpression rightOperand);
}
