package pointofsale.mocks;

import pointofsale.Money;
import pointofsale.Product;
import pointofsale.dao.ProductDAO;

import java.util.HashMap;
import java.util.Map;

public class ProductDAOMock implements ProductDAO {
    private Map<String, Product> database = new HashMap<>();

    public ProductDAOMock() {
        add(new Product("QWERTY123", "Orange juice", new Money(200)));
        add(new Product("ABCABCABC", "Apple juice", new Money(599)));
        add(new Product("123456789", "Pear juice", new Money(1991)));
        add(new Product("987654321", "Mouse", new Money(2134)));
        add(new Product("CBACBACBA", "Bread", new Money(24563)));
        add(new Product("123456QWE", "Butter", new Money(2213)));
        add(new Product("123QWERTY", "Phone", new Money(2412)));
        add(new Product("A1A1A1A1A", "TV", new Money(2214)));
    }

    private void add(Product product) {
        database.put(product.getBarcode(), product);
    }

    public Product findByBarcode(String barcode) {
        Product product = null;
        if(database.containsKey(barcode)) product = database.get(barcode);
        return product;
    }
}
