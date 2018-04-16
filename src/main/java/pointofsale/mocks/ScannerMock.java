package pointofsale.mocks;

import pointofsale.Basket;
import pointofsale.PointOfSale;
import pointofsale.io.Scanner;

public class ScannerMock implements Scanner {
    public String readInput() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Scan product: ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        PointOfSale pointOfSale = new PointOfSale(new ScannerMock(), new LCDDisplayMock(),
                new PrinterMock(), new ProductDAOMock(), new Basket());
        System.out.println("Point of sale");
        pointOfSale.run();
    }
}
