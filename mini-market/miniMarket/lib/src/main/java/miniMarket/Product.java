package miniMarket;

public class Product {
    private String name;
    private double price;
    private TypeProduct type;

    public Product(String name, double price, TypeProduct type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public TypeProduct getType() {
        return type;
    }
}
