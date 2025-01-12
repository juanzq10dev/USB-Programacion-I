package miniMarket;

public class TypeProduct {
    private String typeName;
    private int amountForDiscount;
    private double discount;

    public TypeProduct(String typeName, int amountForDiscount, double discount) {
        this.typeName = typeName;
        this.discount = discount;
        this.amountForDiscount = amountForDiscount;
    }

    public String getTypeName() {
        return typeName;
    }

    public double getDiscount() {
        return discount;
    }

    public int getAmountForDiscount() {
        return amountForDiscount;
    }
}
