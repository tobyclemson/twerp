package twerp.lang.elements;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class NumericExpression {
    Integer value;

    public NumericExpression(String expression) {
        this(Integer.parseInt(expression));
    }

    public Integer evaluate() {
        return value;
    }
}
