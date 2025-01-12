package excel.list;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AverageTest {

    @Test
    public void testCalculateWhenResultHasDecimals() {
        Position a1 = new Position('a', 1);
        Position a2 = new Position('a', 2);
        Position b1 = new Position('b', 1);
        Position b2 = new Position('b', 2);
        Table table = new Table(); 
        Operator average = new Average(table);
        table.write("abc", a2);
        table.write("13", b1);
        table.write("105", a1);
        table.write("55", b2);
        double result =  average.Calculate(a1,b2);
        double expected = 57.67;
        
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testAverageWithNegativeNumbers() {
        Position a1 = new Position('a', 1);
        Position a2 = new Position('a', 2);
        Position b1 = new Position('b', 1);
        Position b2 = new Position('b', 2);
        Table table = new Table(); 
        Operator average = new Average(table);
        table.write("abc", a2);
        table.write("12", b1);
        table.write("-9", a1);
        table.write("27", b2);
        double result =  average.Calculate(a1,b2);
        double expected = 10;
        
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testCalculateWhithVerticalRange() {
        Position a1 = new Position('a', 1);
        Position a2 = new Position('a', 2);
        Position a3 = new Position('a', 3);
        Position a4 = new Position('a', 4);
        Table table = new Table(); 
        Operator average = new Average(table);
        table.write("abc", a2);
        table.write("13", a3);
        table.write("105", a1);
        table.write("55", a4);
        double result =  average.Calculate(a1,a4);
        double expected = 57.67;
        
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testCalculateWhitHorizontalRange() {
        Position a1 = new Position('a', 1);
        Position c1 = new Position('c', 1);
        Position b1 = new Position('b', 1);
        Position d1 = new Position('d', 1);
        Table table = new Table(); 
        Operator average = new Average(table);
        table.write("bzrp", c1);
        table.write("10", b1);
        table.write("115", a1);
        table.write("33", d1);
        double result =  average.Calculate(a1,d1);
        double expected = 52.67;
        
        assertEquals(expected, result, 0.0);
    }
}
