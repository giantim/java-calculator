package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Expression {
    private final List<String> expression;

    public Expression(String input) {
        throwExceptionWhenInputIsNullOrEmpty(input);
        String[] splitInput = input.split(Constant.BLANK);
        throwExceptionWhenInputIsBlank(splitInput);
        throwExceptionWhenInputIsNotNumber(splitInput);
        throwExceptionForInvalidOperator(splitInput);
        throwExceptionWhenDivideByZero(splitInput);
        this.expression = new ArrayList(Arrays.asList(splitInput));
    }

    private void throwExceptionWhenInputIsNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(Constant.INVALID_EXPRESSION);
        }
    }

    private void throwExceptionWhenInputIsBlank(String[] splitInput) {
        if (splitInput.length == 0) {
            throw new IllegalArgumentException(Constant.INVALID_EXPRESSION);
        }
    }

    private void throwExceptionWhenInputIsNotNumber(String[] splitInput) {
        try {
            for (int i = 0; i < splitInput.length; i = i + 2) {
                Double.valueOf(splitInput[i]);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(Constant.INVALID_EXPRESSION);
        }
    }

    private void throwExceptionForInvalidOperator(String[] splitInput) {
        try {
            for (int i = 1; i < splitInput.length; i = i + 2) {
                Operator.throwExceptionWhenInputIsNotSymbol(splitInput[i]);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(Constant.INVALID_EXPRESSION);
        }
    }

    private void throwExceptionWhenDivideByZero(String[] splitInput) {
        for (int i = 1; i < splitInput.length; i = i + 2) {
            if (Operator.isDivisionOperator(splitInput[i]) && Double.valueOf(splitInput[i + 1]) == Constant.ZERO) {
                throw new IllegalArgumentException(Constant.INVALID_EXPRESSION);
            }
        }
    }

    public List<String> getExpression() {
        return this.expression;
    }
}
