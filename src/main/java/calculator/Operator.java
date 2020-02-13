package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+",
            (left, right) -> (left + right)),
    MINUS("-",
            (left, right) -> (left - right)),
    MULTIPLICATION("*",
            (left, right) -> (left * right)),
    DIVISION("/",
            (left, right) -> (left / right));

    private String symbol;
    private BiFunction<Double, Double, Double> expression;

    Operator(String symbol, BiFunction<Double, Double, Double> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public double calculate(double left, double right) {
        return expression.apply(left, right);
    }

    public static Operator find(String operator) {
        return Arrays.stream(Operator.values())
                .filter(op -> op.symbol.equals(operator))
                .findFirst()
                .get();
    }

    public static void throwExceptionWhenInputIsNotSymbol(String input) {
        Arrays.stream(Operator.values())
                .filter(op -> op.symbol.equals(input))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static boolean isDivisionOperator(String operator) {
        return Constant.DIVISION_SYMBOL.equals(operator);
    }
}
