package miniMarket;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    @Test
    public void testGetNameForMilk() {
        TypeProduct dairy = new TypeProduct("Dairy", 10, 10);
        Product product = new Product("Milk", 12, dairy);
        String result = product.getName();
        assertEquals("Milk", result);
    }

    @Test
    public void testGetPriceForMilk() {
        TypeProduct dairy = new TypeProduct("Dairy", 10, 10);
        Product product = new Product("Milk", 12, dairy);
        double result = product.getPrice();
        double expected = 12;
        assertEquals(expected, result, 12);
    }

    @Test
    public void testGetTypeForMilk() {
        TypeProduct dairy = new TypeProduct("Dairy", 10, 10);
        Product product = new Product("Milk", 12, dairy);
        TypeProduct result = product.getType();
        assertEquals(dairy, result);
    }
}
