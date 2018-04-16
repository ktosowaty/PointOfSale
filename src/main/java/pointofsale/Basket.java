package pointofsale;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Money countTotalValue() {
        Money money = new Money(0);
        for(Product aProductList : productList) {
            money.add(aProductList.getPrice());
        }
        return money;
    }
}
