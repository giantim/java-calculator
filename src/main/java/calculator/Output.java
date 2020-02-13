package calculator;

public class Output {
    private Output() {
    }

    public static void printResult(double result) {
        System.out.println("결과 값은 : " + result);
    }

    public static void printExceptionMessage(String message) {
        System.out.println(message);
    }
}
