package calculator;

import java.util.List;

public class Calculator {
    private Calculator() {
    }

    public static double calculate(List<String> expression) {
        double left = Double.valueOf(expression.get(0));
        for (int i = 1; i < expression.size(); i = i + 2) {
            String operator = expression.get(i);
            double right = Double.valueOf(expression.get(i + 1));
            left = Operator.find(operator).calculate(left, right);
        }
        return left;
    }
}
