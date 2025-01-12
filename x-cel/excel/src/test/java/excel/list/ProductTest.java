package excel.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    @Test
    public void testCalculate() { 
        Position a1 = new Position('a', 1);
        Position a2 = new Position('a', 2);
        Position b1 = new Position('b', 1);
        Position b2 = new Position('b', 2);
        Table table = new Table(); 
        Operator product = new Product(table);
        table.write("abc", a2);
        table.write("13", b1);
        table.write("105", a1);
        table.write("55", b2);
        double result =  product.Calculate(a1,b2);
        double expected = 75075;
        
        assertEquals(expected, result, 0.0);
    }

    @Test
   public void testCalculate2() {
        Position a1 = new Position('a', 1);
        Position b1 = new Position('b', 1);
        Position b2 = new Position('b', 2);
        Table table = new Table(); 
        Operator product = new Product(table);
        table.write("13", b1);
        table.write("10", a1);
        table.write("-35", b2);
        double result =  product.Calculate(a1,b2);
        double expected = -4550;
        
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testCalculate3() {
        Position a1 = new Position('a', 1);
        Position b1 = new Position('b', 1);
        Position b2 = new Position('b', 2);
        Table table = new Table(); 
        Operator product = new Product(table);
        table.write("47", b1);
        table.write("23", a1);
        table.write("5", b2);
        double result =  product.Calculate(a1,b2);
        double expected = 5405;
        
        assertEquals(expected, result, 0.0);
    }
    
    @Test
    public void testCalculate4() {
        Position a1 = new Position('a', 1);
        Position b1 = new Position('b', 1);
        Position b2 = new Position('b', 2);
        Table table = new Table(); 
        Operator product = new Product(table);
        table.write("-1", b1);
        table.write("32", a1);
        table.write("0", b2);
        double result =  product.Calculate(a1,b2);
        double expected = 0;
        
        assertEquals(expected, result, 0.0);
    }
}

