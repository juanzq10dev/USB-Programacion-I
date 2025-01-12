package miniMarket;

import org.junit.Test;
import static org.junit.Assert.*;

public class TypeProductTest {
    @Test
    public void testGetTypeProductType() {
        String expected = "Candie";
        TypeProduct productType = new TypeProduct(expected, 10, 5);
        String result = productType.getTypeName();
        assertEquals(expected, result);
    }

    @Test
    public void testGetTypeProductAmountForDiscount() {
        int expected = 10;
        TypeProduct productType = new TypeProduct("Candie", expected, 5);
        int result = productType.getAmountForDiscount();
        assertEquals(expected, result);
    }

    @Test
    public void testGetTypeProductDiscount() {
        double expected = 10;
        TypeProduct productType = new TypeProduct("Candie", 5, expected);
        double result = productType.getAmountForDiscount();
        assertEquals(expected, result, 10);
    }
}
