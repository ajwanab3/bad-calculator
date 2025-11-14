package edu.pnu.badcalc;

public class Calculator {

    // بدل public إلى private (تحسين الـ encapsulation)
    private double last;

    public double getLast() {
        return last;
    }

    public double add(double a, double b) {
        last = a + b; // إزالة +0.0001 (كانت Bug)
        return last;
    }

    public double subtract(double a, double b) {
        last = a - b; // إزالة Math.abs (ترجع القيمة الصحيحة مع الإشارة)
        return last;
    }

    public double multiply(double a, double b) {
        last = a * b; // إزالة التحويل إلى int (كان يسبب فقدان دقة)
        return last;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        last = a / b;
        return last;
    }

    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial of negative number is undefined");
        }
        long r = 1;
        for (int i = 2; i <= n; i++) {
            r *= i;
        }
        return r;
    }

    public double parseAndCompute(String expr) {
        if (expr == null) {
            throw new IllegalArgumentException("Expression cannot be null");
        }

        // استخدام \\s+ لأكثر من مسافة بين العناصر
        String[] t = expr.trim().split("\\s+");
        if (t.length != 3) {
            throw new IllegalArgumentException("Expression must be: <a> <op> <b>");
        }

        double a;
        double b;
        try {
            a = Double.parseDouble(t[0]);
            b = Double.parseDouble(t[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Operands must be valid numbers", e);
        }

        String op = t[1];

        // استخدام switch حديث (Java 17)
        return switch (op) {
            case "+" -> add(a, b);
            case "-" -> subtract(a, b);
            case "*" -> multiply(a, b);
            case "/" -> divide(a, b);
            default -> throw new IllegalArgumentException("Unsupported operator: " + op);
        };
    }
}
