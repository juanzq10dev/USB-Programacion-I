package miniMarket;

import org.junit.Test;
import java.util.*;

public class OrderTest {
    @Test
    public void testAddProductShouldAddTwooMilksAndFiveChocolates() {
        TypeProduct dairy = new TypeProduct("Dairy", 10, 10);
        Product milk = new Product("Milk", 12, dairy);
        TypeProduct candy = new TypeProduct("Candy", 20, 5);
        Product chocolate = new Product("Chocolate", 12, candy);

        Order order = new Order();
        order.addProduct(milk, 2);
        order.addProduct(chocolate, 5);
        ArrayList<OrderDetail> result = order.getProductList();
        ArrayList<OrderDetail> expected = new ArrayList<OrderDetail>();
        expected.add(new OrderDetail(milk, 2));
        expected.add(new OrderDetail(chocolate, 5));
        result.equals(expected);
    }

    @Test
    public void testGetProductListShouldReturnProductList() {
        TypeProduct vegetables = new TypeProduct("Vegetables", 30, 5);
        Product tomato = new Product("Tomato", 1, vegetables);
        ArrayList<OrderDetail> expected = new ArrayList<OrderDetail>();
        expected.add(new OrderDetail(tomato, 5));
        Order order = new Order();
        order.addProduct(tomato, 5);
        ArrayList<OrderDetail> result = order.getProductList();
        result.equals(expected);
    }
}
