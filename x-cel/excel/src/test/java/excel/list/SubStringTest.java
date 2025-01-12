package excel.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class SubStringTest {
    @Test
    public void testSubStringShouldGiveAStringFromAnIndex() {
        Table table = new Table();
        SubString substring = new SubString(table);
        String text = "Hello World";
        int index = 4;

        Position A5 = new Position('A', 5);
        table.write(text, A5);
        
        String result = substring.substring(A5, index);
        String expected = "o World";
        assertEquals(expected, result);
    }

    @Test
    public void testSubStringShouldNotGiveAStringOutOfIndex() {
        Table table = new Table();
        SubString substring = new SubString(table);
        String text = "Hello World";
        int index = 20;

        Position A5 = new Position('A', 5);
        table.write(text, A5);

        assertThrows(IndexOutOfBoundsException.class, () -> substring.substring(A5, index));
    }
}
