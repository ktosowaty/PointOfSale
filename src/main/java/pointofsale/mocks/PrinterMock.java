package pointofsale.mocks;

import pointofsale.Basket;
import pointofsale.Product;
import pointofsale.io.Printer;

public class PrinterMock implements Printer {
    public void print(Basket basket) {
        System.out.println("Printer:");
        for (Product aProductList : basket.getProductList()) {
            System.out.println(aProductList.getName() + ": " + aProductList.getPrice());
        }
        System.out.println("------------------------------");
        System.out.println("Total: " + basket.countTotalValue());
    }
}
