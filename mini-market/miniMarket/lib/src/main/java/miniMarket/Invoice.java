package miniMarket;

import java.util.ArrayList;

public class Invoice {
    private ArrayList<InvoiceDetail> invoiceData;
    private double totalPrice;
    Order order;

    public Invoice(Order order) {
        this.order = order;
        invoiceData = new ArrayList<InvoiceDetail>();
        totalPrice = 0;
        fillInvoice();
    }

    private void fillInvoice() {
        ArrayList<OrderDetail> productList = order.getProductList();
        for (OrderDetail orderDetail : productList) {
            Product product = orderDetail.getProduct();
            if (contains(product) == false) {
                String productName = product.getName();
                int productQuantity = countProduct(product);
                double unitPrice = product.getPrice();
                double productTotalPrice = obtainProductTotalPrice(product);
                double discount = obtainDiscount(product);
                double priceWithDiscount = obtainPriceWithDiscount(product);
                InvoiceDetail invoiceDetail = new InvoiceDetail(productName, productQuantity, unitPrice, productTotalPrice, discount, priceWithDiscount);
                totalPrice += productTotalPrice;
                invoiceData.add(invoiceDetail);
            }
        }
    }

    private boolean contains(Product product) {
        for (InvoiceDetail invoiceDetail : invoiceData) {
            if (invoiceDetail.contains(product.getName())) {
                return true;
            }
        }
        return false;
    }

    public int countProduct(Product product) {
        ArrayList<OrderDetail> productList = order.getProductList();
        int count = 0;
        for (OrderDetail orderDetail : productList) {
            if (orderDetail.contains(product)) {
                count += orderDetail.getQuantity();
            }
        }
        return count;
    }

    public double obtainProductTotalPrice(Product product) {
        int productQuantity = countProduct(product);
        double totalPrice = product.getPrice() * productQuantity;
        return totalPrice;
    }

    public double obtainDiscount(Product product) {
        double quantity = countProduct(product);
        TypeProduct typeProduct = product.getType();
        int amountForDiscount = typeProduct.getAmountForDiscount();
        if (quantity >= amountForDiscount) {
            return typeProduct.getDiscount();
        } else {
            return 0;
        }
    }

    public double obtainPriceWithDiscount(Product product) {
        double totalPrice = obtainProductTotalPrice(product);
        double discount = obtainDiscount(product);
        double priceWithDiscount = totalPrice - ((totalPrice * discount) / 100);
        return priceWithDiscount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
