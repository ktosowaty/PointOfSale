package pointofsale;

import java.util.Objects;

public class Product {
    private String barcode;
    private String name;
    private Money price;

    public Product(String code, String name, Money price) {
        if(price.getValue()<0) throw new IllegalArgumentException("Negative price!");
        else if(code==null || code.isEmpty()) throw new IllegalArgumentException("Invalid barcode!");
        else if(name==null || name.isEmpty()) throw new IllegalArgumentException("Invalid name!");
        this.barcode = code;
        this.name = name;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(barcode, product.barcode) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode, name, price);
    }
}
