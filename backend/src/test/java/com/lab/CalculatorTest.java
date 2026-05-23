package com.lab;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CalculatorTest {
    @Test
    public void testAddition() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3), "2 + 3 should equal 5");
    }
    @Test
    public void testSubtraction() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.subtract(5, 3), "5 - 3 should equal 2");
    }
}
