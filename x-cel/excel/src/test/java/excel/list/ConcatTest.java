package excel.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ConcatTest {
    @Test
    public void testConcatShouldConcat() {
        Table table = new Table();
        Position A12 = new Position('A', 12);
        Position B10 = new Position('B', 10);
        Concat concatOperator = new Concat(table);

        table.write("Hola", A12);
        table.write("Mundo", B10);
        Object[] list = {A12, " ", B10};

        String result = concatOperator.concat(list);
        String expected = "Hola Mundo";
        
        assertEquals(expected, result);

        Position C15 = new Position('C', 15);
        table.write("20", C15);
        Object[] list2 = {A12, " ", B10, C15};
        expected = "Hola Mundo20";
        result = concatOperator.concat(list2);

        assertEquals(expected, result);
    }

    @Test 
    public void testThrowsShouldNotAdmitOtherList() {
        Table table = new Table();
        Position A12 = new Position('A', 12);
        Object[] list = {table, A12};
        Concat concatOperator = new Concat(table);
        
        assertThrows(IllegalArgumentException.class, () -> concatOperator.concat(list));
    }
}
