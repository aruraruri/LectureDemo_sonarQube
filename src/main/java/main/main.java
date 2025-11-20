package main;


import java.util.Scanner;
import java.util.logging.Logger;

public class main {
    private static Scanner scanner;
    private static Logger logger;
    private static int loopCount;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        logger = Logger.getLogger(calc.Calculator.class.getName());
        askLoopCount();
    }

    public static void askLoopCount() {
        logger.info("How many additions?");
        loopCount = scanner.nextInt();
        runLoop();
    }

    public static void runLoop() {
        for (int i=0; i<loopCount; i++) {
            String result = "1+1 is: "+ calc.Calculator.addValues(1, 1);
            logger.info(result);
        }
    };
}
