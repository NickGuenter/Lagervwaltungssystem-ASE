package Manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lvs.Classes.Product;
import com.lvs.Manager.ProductManager;

public class ProductManagerTest {
    private ProductManager productManager;
    private Product product1;
    private Product product2;
    private ArrayList<Product> products;

    @BeforeEach
    void setUp() {
        productManager = new ProductManager();
        product1 = new Product("Product 1", 10.0, 5);
        product2 = new Product("Product 2", 20.0, 10);
        products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
    }

    @Test
    void testAddProduct() {
        productManager.addProduct(product1);
        assertTrue(productManager.getProducts().contains(product1));
    }

    @Test
    void testRemoveProduct() {
        productManager.addProduct(product1);
        productManager.removeProduct(product1);
        assertFalse(productManager.getProducts().contains(product1));
    }

    @Test
    void testAddProducts() {
        productManager.addProducts(products);
        assertTrue(productManager.getProducts().contains(product1));
        assertTrue(productManager.getProducts().contains(product2));
    }

    @Test
    void testCheckStock() {
        productManager.addProducts(products);
        assertTrue(productManager.checkStock(products));

        Product product3 = new Product("Product 3", 30.0, 15);
        products.add(product3);
        assertFalse(productManager.checkStock(products));
    }
}
