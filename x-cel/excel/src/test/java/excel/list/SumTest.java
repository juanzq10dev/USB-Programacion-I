package excel.list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SumTest {
    
    @Test
    void testCalculateWithNumbersAndLettersInRange() {
        Position a1 = new Position('a', 1);
        Position a2 = new Position('a', 2);
        Position b1 = new Position('b', 1);
        Position b2 = new Position('b', 2);
        Table table = new Table(); 
        Operator sum = new Sum(table);
        table.write("abc", a2);
        table.write("13", b1);
        table.write("105", a1);
        table.write("avc", b2);
        double result =  sum.Calculate(a1,b2);
        double expected = 118;
        
        assertEquals(expected, result, 0.0);
    }

    @Test
    void testCalculateWhithNumbers() {
        Position a1 = new Position('a', 1);
        Position a2 = new Position('a', 2);
        Position a3 = new Position('a', 3);
        Position a4 = new Position('a', 4);
        Table table = new Table(); 
        Operator sum = new Sum(table);
        table.write("2", a2);
        table.write("220", a3);
        table.write("509", a1);
        table.write("339", a4);
        double result =  sum.Calculate(a1,a4);
        double expected = 1070;
        
        assertEquals(expected, result, 0.0);
    }

    @Test
    void testCalculateWithLettersInRange() {
        Position a1 = new Position('a', 1);
        Position a2 = new Position('a', 2);
        Position b1 = new Position('b', 1);
        Position b2 = new Position('b', 2);
        Table table = new Table(); 
        Operator sum = new Sum(table);
        table.write("abc", a2);
        table.write("hola", b1);
        table.write("je", a1);
        table.write("avc", b2);
        double result =  sum.Calculate(a1,b2);
        double expected = 0;
        
        assertEquals(expected, result, 0.0);
    }

    @Test
    void testCalculateWithNegativeAndPositiveNumbers() {
        Position a1 = new Position('a', 1);
        Position a2 = new Position('a', 2);
        Position b1 = new Position('b', 1);
        Position b2 = new Position('b', 2);
        Table table = new Table(); 
        Operator sum = new Sum(table);
        table.write("5", a2);
        table.write("-95", b1);
        table.write("12", a1);
        table.write("22", b2);
        double result =  sum.Calculate(a1,b2);
        double expected = -56;
        
        assertEquals(expected, result, 0.0);
    }
}

