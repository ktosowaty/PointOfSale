import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pointofsale.Basket;
import pointofsale.PointOfSale;
import pointofsale.io.Scanner;
import pointofsale.mocks.LCDDisplayMock;
import pointofsale.mocks.PrinterMock;
import pointofsale.mocks.ProductDAOMock;

public class PointOfSaleTest {
    private Scanner scanner;
    private LCDDisplayMock display;
    private PrinterMock printer;
    private Basket basket;
    private PointOfSale pointOfSale;

    @Before
    public void prepareTests() {
        scanner = Mockito.mock(Scanner.class);
        display = Mockito.mock(LCDDisplayMock.class);
        printer = Mockito.mock(PrinterMock.class);
        basket = new Basket();
        pointOfSale = new PointOfSale(scanner, display, printer, new ProductDAOMock(), basket);
    }

    @Test
    public void exitAsInput() {
        Mockito.when(scanner.readInput()).thenReturn("exit");
        pointOfSale.run();
        Mockito.verify(display).display("Total: 0.00");
        Mockito.verify(printer).print(basket);
    }

    @Test
    public void correctBarcodeAsInput() {
        Mockito.when(scanner.readInput()).thenReturn("QWERTY123").thenReturn("exit");
        pointOfSale.run();
        Mockito.verify(display).display("Orange juice: 2.00");
        Mockito.verify(display).display("Total: 2.00");
        Mockito.verify(printer).print(basket);
    }

    @Test
    public void incorrectBarcodeAsInput() {
        Mockito.when(scanner.readInput()).thenReturn("RANDOM123").thenReturn("exit");
        pointOfSale.run();
        Mockito.verify(display).display("Product not found");
        Mockito.verify(display).display("Total: 0.00");
        Mockito.verify(printer).print(basket);
    }

    @Test
    public void emptyBarcodeAsInput() {
        Mockito.when(scanner.readInput()).thenReturn("").thenReturn("exit");
        pointOfSale.run();
        Mockito.verify(display).display("Invalid bar-code");
        Mockito.verify(display).display("Total: 0.00");
        Mockito.verify(printer).print(basket);
    }
}
