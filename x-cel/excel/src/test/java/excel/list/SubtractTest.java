package excel.list;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SubtractTest {
    @Test
    void testCalculateWithPositiveNumbers() {
        Position a1 = new Position('a', 1);
        Position a2 = new Position('a', 2);
        Position b1 = new Position('b', 1);
        Position b2 = new Position('b', 2);
        Table table = new Table(); 
        Operator subtract = new Subtract(table);
        table.write("abc", a2);
        table.write("13", b1);
        table.write("105", a1);
        table.write("55", b2);
        double result =  subtract.Calculate(a1,b2);
        double expected = 37;
        
        assertEquals(expected, result, 0.0);
    }

    @Test
    void testCalculateWithNegativeAndPositiveNumbers() {
        Position a1 = new Position('a', 1);
        Position a2 = new Position('a', 2);
        Position b1 = new Position('b', 1);
        Position b2 = new Position('b', 2);
        Table table = new Table(); 
        Operator subtract = new Subtract(table);
        table.write("254", a2);
        table.write("-13", b1);
        table.write("-59", a1);
        table.write("55", b2);
        double result =  subtract.Calculate(a1,b2);
        double expected = -355;
        
        assertEquals(expected, result, 0.0);
    }

    @Test
    void testCalculateWhitNegativeNumbers() {
        Position a1 = new Position('a', 1);
        Position a2 = new Position('a', 2);
        Position b1 = new Position('b', 1);
        Position b2 = new Position('b', 2);
        Table table = new Table(); 
        Operator subtract = new Subtract(table);
        table.write("-564", a2);
        table.write("-1", b1);
        table.write("-88", a1);
        table.write("-76", b2);
        double result =  subtract.Calculate(a1,b2);
        double expected = 553;
        
        assertEquals(expected, result, 0.0);
    }
}

