package miniMarket;

public class InvoiceDetail {
    private String productName;
    private int productQuantity;
    private double unitPrice;
    private double productTotalPrice;
    private double discount;
    private double priceWithDiscount;

    public InvoiceDetail(String productName, int productQuantity, double unitPrice, double productTotalPrice, double discount, double priceWithDiscount) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.unitPrice = unitPrice;
        this.productTotalPrice = productTotalPrice;
        this.discount = discount;
        this.priceWithDiscount = priceWithDiscount;
    }

    public boolean contains(String productName) {
        if (this.productName == productName) {
            return true;
        } else {
            return false;
        }
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getProductTotalPrice() {
        return productTotalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public double getPriceWithDiscount() {
        return priceWithDiscount;
    }
}
