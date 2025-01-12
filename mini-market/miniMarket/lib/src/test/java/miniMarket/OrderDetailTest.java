package miniMarket;

import org.junit.Test;
import static org.junit.Assert.*;

public class OrderDetailTest {
    @Test
    public void testContainsShoudReturnTrue() {
        TypeProduct dairy = new TypeProduct("Dairy", 11, 5);
        Product milk = new Product("milk", 7, dairy);
        OrderDetail orderDetail = new OrderDetail(milk, 2);
        assertTrue(orderDetail.contains(milk));
    }

    @Test
    public void testContainsShouldReturnFalse() {
        TypeProduct dairy = new TypeProduct("Dairy", 11, 5);
        Product milk = new Product("milk", 7, dairy);
        TypeProduct vegetables = new TypeProduct("Vegetables", 20, 5);
        Product tomato = new Product("Tomato", 1, vegetables);
        OrderDetail orderDetail = new OrderDetail(milk, 2);
        assertFalse(orderDetail.contains(tomato));
    }

    @Test
    public void testGetProductShouldReturnProduct() {
        TypeProduct vegetables = new TypeProduct("Vegetables", 20, 5);
        Product tomato = new Product("Tomato", 1, vegetables);
        OrderDetail orderDetail = new OrderDetail(tomato, 10);
        Product result = orderDetail.getProduct();
        Product expected = tomato;
        assertEquals(expected, result);
    }

    @Test
    public void testGetQiantityShouldReturnQuantity() {
        TypeProduct iceCream = new TypeProduct("Ice Cream", 0, 0);
        Product gelato = new Product("Gelato", 10, iceCream);
        OrderDetail orderDetail = new OrderDetail(gelato, 5);
        double result = orderDetail.getQuantity();
        double expected = 5;
        assertEquals(expected, result, 0.0);
    }
}
