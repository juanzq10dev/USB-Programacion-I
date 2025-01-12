package miniMarket;

import org.junit.Test;
import static org.junit.Assert.*;

public class InvoiceTest {
    @Test
    public void testForGarlicButter() {
        TypeProduct dairy = new TypeProduct("Dairy", 11, 10);
        Product garlicButter = new Product("Garlic Butter", 15, dairy);

        Order order = new Order();
        order.addProduct(garlicButter, 10);
        Invoice invoice = new Invoice(order);

        double expected = 150;
        double result = invoice.obtainProductTotalPrice(garlicButter);
        assertEquals(expected, result, 0.0);

        result = invoice.obtainPriceWithDiscount(garlicButter);
        assertEquals(expected, result, 0.0);

        result = invoice.getTotalPrice();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testForPasta() {
        TypeProduct pasta = new TypeProduct("Pasta", 5, 50);
        Product noodles = new Product("Noodel", 5.50, pasta);

        Order order = new Order();
        order.addProduct(noodles, 20);
        Invoice invoice = new Invoice(order);

        double expected = 110;
        double result = invoice.obtainProductTotalPrice(noodles);
        assertEquals(expected, result, 0.0);

        expected = 55;
        result = invoice.obtainPriceWithDiscount(noodles);
        assertEquals(expected, result, 0.0);

        expected = 55;
        result = invoice.getTotalPrice();
    }

    @Test
    public void testForGarlicButterAndNoodles() {
        TypeProduct pasta = new TypeProduct("Pasta", 5, 50);
        Product noodles = new Product("Noodel", 5.50, pasta);

        TypeProduct dairy = new TypeProduct("Dairy", 11, 10);
        Product garlicButter = new Product("Garlic Butter", 15, dairy);

        Order order = new Order();
        order.addProduct(noodles, 20);
        order.addProduct(garlicButter, 10);
        Invoice invoice = new Invoice(order);

        double expected = 150;
        double result = invoice.obtainProductTotalPrice(garlicButter);
        assertEquals(expected, result, 0.0);

        result = invoice.obtainPriceWithDiscount(garlicButter);
        assertEquals(expected, result, 0.0);

        expected = 110;
        result = invoice.obtainProductTotalPrice(noodles);
        assertEquals(expected, result, 0.0);

        expected = 55;
        result = invoice.obtainPriceWithDiscount(noodles);
        assertEquals(expected, result, 0.0);

        expected = 205;
        result = invoice.getTotalPrice();
    }
}
