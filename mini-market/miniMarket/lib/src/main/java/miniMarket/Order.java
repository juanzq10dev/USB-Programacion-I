package miniMarket;

import java.util.ArrayList;

public class Order {

    private ArrayList<OrderDetail> productList;

    public Order() {
        productList = new ArrayList<OrderDetail>();
    }

    public ArrayList<OrderDetail> getProductList() {
        return productList;
    }

    public void addProduct(Product product, int quantity) {
        OrderDetail orderDetail = new OrderDetail(product, quantity);
        productList.add(orderDetail);
    }
}
