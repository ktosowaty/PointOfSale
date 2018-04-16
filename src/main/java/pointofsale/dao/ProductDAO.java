package pointofsale.dao;

import pointofsale.Product;

public interface ProductDAO {
    Product findByBarcode(String barcode);
}
