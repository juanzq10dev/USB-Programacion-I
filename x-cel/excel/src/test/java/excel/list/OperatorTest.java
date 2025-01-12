package excel.list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class OperatorTest {

    @Test
    void transformListShouldReturnOnlyNumbersInTheNewArrayList() {
            Position a1 = new Position('a', 1);
            Position a2 = new Position('a', 2);
            Position a3 = new Position('a', 3);
            Table table = new Table(); 
            Operator operator = new Operator(table);
            table.write("abc", a2);
            table.write("13", a1);
            table.write("47", a3);
            ArrayList<Double> result = operator.transformList(a1, a3); 
            ArrayList<Double> expected = new ArrayList<Double>(Arrays.asList(13.0, 47.0));
            assertEquals(expected, result);
        }
}
