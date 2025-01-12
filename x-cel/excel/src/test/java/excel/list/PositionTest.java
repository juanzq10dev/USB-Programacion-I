package excel.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    @Test
    public void testConstructorPositionShouldReturnErrorIfCharacterIsNotValid() {
        assertThrows(IllegalArgumentException.class, () -> new Position('?', 50));
        assertThrows(IllegalArgumentException.class, () -> new Position('#', 50));
        assertThrows(IllegalArgumentException.class, () -> new Position('1', 50));
        assertThrows(IllegalArgumentException.class, () -> new Position("110"));
        assertThrows(IllegalArgumentException.class, () -> new Position("#10"));
    }

    @Test
    public void testPositionConstructorShouldWorkWithLowerCaseAndUpperCaseCharacters() {
        assertDoesNotThrow(() -> new Position('z', 12));
        assertDoesNotThrow(() -> new Position('Z', 12));
    }

    @Test
    public void testPositionRowShouldReturnTwentySixForZ() {
        Position position = new Position('z', 10);
        Position position2 = new Position('Z', 10);
        int result = position.obtainColumnValue();
        int expected = 25;
        assertEquals(expected, result);
        result = position2.obtainColumnValue();
        assertEquals(expected, result);
    }

    @Test
    public void testObtainPositionYShouldReturnTwentyForTwentyOne() {
        Position position = new Position('Z', 21);
        int result = position.obtainRowValue();
        int expected = 20;
        assertEquals(expected, result);
    }
}
