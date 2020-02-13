package calculator;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static void runCalculator() {
        try {
            Expression expression = getExpression();
            double result = Calculator.calculate(expression.getExpression());
            Output.printResult(result);
        } catch (Exception e) {
            Output.printExceptionMessage(e.getMessage());
            runCalculator();
        }
    }

    private static Expression getExpression() {
        System.out.print("계산식을 입력하십시오: ");
        return new Expression(scanner.nextLine());
    }

    public static void main(String[] args) {
        runCalculator();
    }
}
