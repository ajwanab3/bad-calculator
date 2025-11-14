package edu.pnu.badcalc;

import java.util.Scanner;

public class App {

    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Calculator v1.0");
            System.out.println("Enter: <number> <operator> <number>, e.g. 3 + 4");
            System.out.println("Type 'quit' to exit.");

            while (true) {
                System.out.print("> ");
                String line = s.nextLine().trim();

                if (line.equalsIgnoreCase("quit")) {
                    break;
                }

                if (line.isEmpty()) {
                    continue; // تجاهل الأسطر الفارغة
                }

                try {
                    double result = calculator.parseAndCompute(line);
                    System.out.println("= " + result);
                } catch (IllegalArgumentException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }
    }
}
