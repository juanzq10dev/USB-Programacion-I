package excel.list;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class DivisionTest {
    @Test
    public void testDivisionShouldDivide() {
        Position a1 = new Position('a', 1);
        Position h1 = new Position('h', 1);
        Table table = new Table(); 
        Operator division = new Division(table);
        table.write("12", a1);
        table.write("6", h1);
        double result =  division.Calculate(a1,h1);
        double expected = 2;
        
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testCalculateShouldThrowErrorIfDividendIs0() {
        Position a1 = new Position('a', 1);
        Position h1 = new Position('h', 1);
        Table table = new Table(); 
        Operator division = new Division(table);
        table.write("12", a1);
        table.write("0", h1);
        assertThrows(IllegalArgumentException.class, () -> division.Calculate(a1,h1));
    }
    @Test
    public void testDivideWithNegativeNumbers() {
        Position a1 = new Position('a', 1);
        Position h1 = new Position('h', 1);
        Table table = new Table(); 
        Operator division = new Division(table);
        table.write("-23", a1);
        table.write("5", h1);
        double result =  division.Calculate(a1,h1);
        double expected = -4.6;
        
        assertEquals(expected, result, 0.0);
    }
    @Test
    public void secondTestDivideShouldDivide() {
        Position a1 = new Position('a', 1);
        Position h1 = new Position('h', 1);
        Table table = new Table(); 
        Operator division = new Division(table);
        table.write("729", a1);
        table.write("9", h1);
        double result =  division.Calculate(a1,h1);
        double expected = 81;
        
        assertEquals(expected, result, 0.0);
    }
}
