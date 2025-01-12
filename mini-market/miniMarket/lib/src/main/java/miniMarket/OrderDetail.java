package miniMarket;

public class OrderDetail {

    private Product product;
    private int quantity;

    public OrderDetail(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public boolean contains(Product product) {
        if (product == this.product) {
            return true;
        } else {
            return false;
        }
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
