package edu.pnu.badcalc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void addShouldReturnSum() {
        assertEquals(5.0, calc.add(2.0, 3.0), 1e-9);
    }

    @Test
    void subtractShouldReturnDifference() {
        assertEquals(-1.0, calc.subtract(2.0, 3.0), 1e-9);
    }

    @Test
    void multiplyShouldHandleDecimals() {
        assertEquals(7.5, calc.multiply(2.5, 3.0), 1e-9);
    }

    @Test
    void divideShouldReturnQuotient() {
        assertEquals(2.0, calc.divide(6.0, 3.0), 1e-9);
    }

    @Test
    void divideByZeroShouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.divide(1.0, 0.0));
    }

    @Test
    void factorialOfZeroIsOne() {
        assertEquals(1L, calc.factorial(0));
    }

    @Test
    void factorialOfPositiveNumber() {
        assertEquals(120L, calc.factorial(5));
    }

    @Test
    void parseAndComputeValidAddition() {
        assertEquals(7.0, calc.parseAndCompute("3 + 4"), 1e-9);
    }

    @Test
    void parseAndComputeInvalidExpressionShouldThrow() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.parseAndCompute("bad input"));
    }
}
