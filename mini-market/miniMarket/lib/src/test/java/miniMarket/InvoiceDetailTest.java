package miniMarket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InvoiceDetailTest {
    @Test
    public void testContainsShouldReturnTrue() {
        InvoiceDetail invoiceDetail = new InvoiceDetail("Milk", 10, 7, 70, 0, 70);
        assertTrue(invoiceDetail.contains("Milk"));
    }

    @Test
    public void testContainsShoudReturnFalse() {
        InvoiceDetail invoiceDetail = new InvoiceDetail("Milk", 10, 7, 70, 0, 70);
        assertFalse(invoiceDetail.contains("Tomato"));
    }

    @Test
    public void testGetProductNameShouldReturnProductName() {
        InvoiceDetail invoiceDetail = new InvoiceDetail("Milk", 10, 7, 70, 0, 70);
        String expected = "Milk";
        String result = invoiceDetail.getProductName();
        assertEquals(expected, result);
    }

    @Test
    public void testGerQuantityShouldReturnQuantity() {
        InvoiceDetail invoiceDetail = new InvoiceDetail("Milk", 10, 7, 70, 0, 70);
        int expected = 10;
        int result = invoiceDetail.getProductQuantity();
        assertEquals(expected, result);
    }

    @Test
    public void testGetUnitPriceShouldReturnUnitPrice() {
        InvoiceDetail invoiceDetail = new InvoiceDetail("Milk", 10, 7, 70, 0, 70);
        double expected = 7;
        double result = invoiceDetail.getUnitPrice();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testGetProductTotalPriceShouldReturnTotalPrice() {
        InvoiceDetail invoiceDetail = new InvoiceDetail("Milk", 10, 7, 70, 0, 70);
        double expected = 70;
        double result = invoiceDetail.getProductTotalPrice();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testGetDiscount() {
        InvoiceDetail invoiceDetail = new InvoiceDetail("Milk", 10, 7, 70, 0, 70);
        double expected = 7;
        double result = invoiceDetail.getUnitPrice();
        assertEquals(expected, result, 0.0);
    }

    @Test
    public void testGetPriceWithDiscountShouldReturnTheSamePrice() {
        InvoiceDetail invoiceDetail = new InvoiceDetail("Milk", 10, 7, 70, 0, 70);
        double expected = 70;
        double result = invoiceDetail.getPriceWithDiscount();
        assertEquals(expected, result, 0.0);
    }
}
