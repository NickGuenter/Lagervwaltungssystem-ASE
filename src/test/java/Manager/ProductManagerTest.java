package Manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
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
        product1 = new Product("Product1", 10.0, 5);
        product2 = new Product("Product2", 20.0, 10);
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

    @Test
    public void testGetProductQuantity() {
        double quantity = productManager.getProductQuantity();
        productManager.addProducts(products);
        assertEquals(15, productManager.getProductQuantity() - quantity);
    }

    @Test
    public void testGetProductByName() {
        productManager.addProducts(products);
        assertEquals(product1, productManager.getProductByName("Product1"));
        assertEquals(product2, productManager.getProductByName("Product2"));
    }

    @Test
    public void testEditProductPrice() {
        productManager.addProducts(products);
        productManager.editProductPrice(15.0, "Product1");
        assertEquals(15.0, productManager.getProductByName("Product1").getProductValue());
    }

    @Test
    public void testEditProductQuantity() {
        productManager.addProducts(products);
        productManager.editProductQuantity(20, "Product1");
        assertEquals(20, productManager.getProductByName("Product1").getProductQuantity());
    }

    @Test
    public void testEditProductName() {
        productManager.addProducts(products);
        productManager.editProductName("NewProduct1", "Product1");
        assertNull(productManager.getProductByName("Product1"));
        assertNotNull(productManager.getProductByName("NewProduct1"));
    }

    @Test
    public void testGetProductsByName() {
        productManager.addProducts(products);
        ArrayList<Product> productsByName = productManager.getProductsByName("Product1");
        assertTrue(productsByName.contains(product1));
        assertEquals(1, productsByName.size());
    }
}
