package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class CalculatorTest {
    private List<String> expression;

    @BeforeEach
    public void setUp() {
        expression = new ArrayList<>();
    }

    @ParameterizedTest
    @ValueSource(strings = {"        ", "q + w + e", "1+2+3", "+ + 2", "1 abcd 2", "2 * 65 / 0", "2 + 3/", "/1 + 55", "1 + a3"})
    public void expressionConstructorTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            Expression expression = new Expression(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void addTest() {
        expression.add("1");
        expression.add("+");
        expression.add("2");
        Double result = Calculator.calculate(expression);
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    public void subtractTest() {
        expression.add("1");
        expression.add("-");
        expression.add("2");
        Double result = Calculator.calculate(expression);
        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    public void multipleTest() {
        expression.add("1");
        expression.add("*");
        expression.add("2");
        Double result = Calculator.calculate(expression);
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    public void divideTest() {
        expression.add("1");
        expression.add("/");
        expression.add("2");
        Double result = Calculator.calculate(expression);
        Assertions.assertThat(result).isEqualTo(0.5d);
    }
}
