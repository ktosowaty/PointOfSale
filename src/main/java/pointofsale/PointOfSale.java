package pointofsale;

import pointofsale.io.LCDDisplay;
import pointofsale.io.Printer;
import pointofsale.dao.ProductDAO;
import pointofsale.io.Scanner;

public class PointOfSale {
    private Printer printer;
    private Scanner scanner;
    private LCDDisplay display;
    private ProductDAO productDAO;
    private Basket basket;

    public PointOfSale(Scanner scanner, LCDDisplay display, Printer printer,
                        ProductDAO productDAO, Basket basket) {
        this.scanner = scanner;
        this.printer = printer;
        this.display = display;
        this.productDAO = productDAO;
        this.basket = basket;
    }

    public void run() {
        while(true) {
            String input = scanner.readInput();
            if(isExit(input)) break;
            else if(input==null || input.isEmpty()) display.display("Invalid bar-code");
            else addProductToBasket(input);
        }
        display.display("Total: " + basket.countTotalValue());
        printer.print(basket);
    }

    private boolean isExit(String input) {
        return "exit".equals(input);
    }

    private void addProductToBasket(String input) {
        Product product = productDAO.findByBarcode(input);
        if(product==null) {
            display.display("Product not found");
        } else {
            basket.addProduct(product);
            display.display(product.getName() + ": " + product.getPrice());
        }
    }
}
