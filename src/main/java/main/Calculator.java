package main;

import java.util.Scanner;
import java.util.logging.Logger;

public class Calculator {

    private Calculator() {

    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Calculator.class.getName());
        Scanner sc = new Scanner(System.in);
        logger.info("Enter first number");
        double num1 = sc.nextDouble();

        logger.info("Enter second number");
        double num2 = sc.nextDouble();

        double result = addValues(num1, num2);
        String resultStr = "Result is "+result;
        logger.info(resultStr);
    }
    public static double addValues(double num1, double num2) {
        return num1 + num2;
    }
    public static double divideValues(double num1, double num2) {
        return num1 / num2;
    }
    public static double multiplyValues(double num1, double num2) {
        return num1 * num2;
    }
}
