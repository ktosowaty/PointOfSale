import org.junit.Assert;
import org.junit.Test;
import pointofsale.Basket;
import pointofsale.Money;
import pointofsale.Product;

import java.util.ArrayList;
import java.util.List;

public class BasketTest {
    @Test
    public void isBasketListEqualListWithSameProducts() {
        Basket basket = new Basket();
        basket.addProduct(new Product("Hehe", "HeheName", new Money(2000)));
        basket.addProduct(new Product("Haha", "HahaName", new Money(3000)));
        List<Product> list = new ArrayList<>();
        list.add(new Product("Hehe", "HeheName", new Money(2000)));
        list.add(new Product("Haha", "HahaName", new Money(3000)));
        Assert.assertEquals(basket.getProductList(), list);
    }

    @Test
    public void countTotalValueOfEmptyBasket() {
        Basket basket = new Basket();
        Assert.assertEquals(basket.countTotalValue(), new Money(0));
    }

    @Test
    public void countTotalValueOfNotEmptyBasket() {
        Basket basket = new Basket();
        basket.addProduct(new Product("Hehe", "HeheName", new Money(2000)));
        basket.addProduct(new Product("Haha", "HahaName", new Money(3000)));
        Assert.assertEquals(basket.countTotalValue(), new Money(5000));
    }
}
