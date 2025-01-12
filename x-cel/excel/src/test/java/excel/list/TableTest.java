package excel.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class TableTest {
    @Test
    public void writeShouldLetWriteATextWithAPosition() {
        Table table = new Table();
        String text = "50";
        Position position  = new Position('X',30);
        boolean result = table.write(text, position);
        assertTrue(result);
    }

    @Test
    public void writeShouldNotLetWriteOutsideOfTheArray() {
        Table table = new Table();
        String text = "50";
        Position position  = new Position('X', 51);
        boolean result = table.write(text, position);
        assertFalse(result);
    }

    @Test
    public void writeShouldFailIfTestIsNull() { 
        Table table = new Table();
        String text = null;
        Position position  = new Position('X', 13);
        boolean result = table.write(text, position);
        assertFalse(result);
    }

    @Test
    public void testObtainRangeListShouldReturnList () {
        Position A1 = new Position ('A', 1);
        Position A2 = new Position('A', 2);
        Position B2 = new Position ("B2");

        Table table = new Table();
        table.write("hola Ariel", A2); 
        table.write("hola Diego", A1);
        table.write("hola Valeria", B2);

        ArrayList<String> result = table.obtainRangeList(A1, B2);
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("hola Diego", "hola Ariel", "hola Valeria")); 

        assertEquals(expected, result);
    }

    @Test 
    public void testWriteShouldBeAbleToReceiveOperationMethods() {
        Position a1 = new Position('a', 1);
        Position a2 = new Position('a', 2);
        Position b1 = new Position('b', 1);
        Position b2 = new Position('b', 2);
        Position c3 = new Position('c', 3);
        Table table = new Table(); 
        Operator sum = new Sum(table);
        table.write("abc", a2);
        table.write("13", b1);
        table.write("105", a1);
        table.write("55", b2);

        boolean result = table.write(sum.Calculate(a1, b2), c3);
        assertTrue(result);
    }

    @Test void testObtainPositionTextShouldReturnText() {
        Position A1 = new Position('A', 1);
        Table table = new Table();
        table.write("Hello World", A1);
        
        String result = table.obtainText(A1);
        String expected = "Hello World";
        assertEquals(expected, result);
    }
}

