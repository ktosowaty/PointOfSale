import org.junit.Assert;
import org.junit.Test;
import pointofsale.Money;

public class MoneyTest {
    @Test
    public void addTwoMoneyObjectsWithPositiveValue() {
        Money money = new Money(1230);
        money.add(new Money(10));
        Assert.assertEquals(money, new Money(1240));
    }

    @Test
    public void addTwoMoneyObjectsOneNegativeOnePositive() {
        Money money = new Money(1230);
        money.add(new Money(-10));
        Assert.assertEquals(money, new Money(1220));
    }

    @Test
    public void isStringRepresentationCorrect() {
        Money money = new Money(1230);
        Assert.assertEquals(money.toString(), "12.30");
    }

    @Test
    public void isStringRepresentationCorrectV2() {
        Money money = new Money(0);
        Assert.assertEquals(money.toString(), "0.00");
    }

    @Test
    public void isStringRepresentationCorrectV3() {
        Money money = new Money(10);
        Assert.assertEquals(money.toString(), "0.10");
    }
}
