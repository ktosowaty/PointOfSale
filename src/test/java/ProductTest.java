import org.junit.Assert;
import org.junit.Test;
import pointofsale.Money;
import pointofsale.Product;

public class ProductTest {
    @Test
    public void areTwoSameProductsEqual() {
        Product product1 = new Product("BARCODE", "NAME", new Money(123450));
        Product product2 = new Product("BARCODE", "NAME", new Money(123450));
        Assert.assertEquals(product1, product2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createProductWithNegativePrice() {
        Product product = new Product("BARCODE", "NAME", new Money(-123));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createProductWithEmptyBarcode() {
        Product product = new Product("", "NAME", new Money(123));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createProductWithEmptyName() {
        Product product = new Product("BARCODE", "", new Money(123));
    }
}
