package Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lvs.Classes.Product;

import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductTest {

    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product("Test Product", 10.0, 100);
    }

    @Test
    public void testGetProductId() {
        UUID productId = product.getProductId();
        assertNotNull(productId);
    }

    @Test
    public void testGetName() {
        String name = product.getProductName();
        assertEquals("Test Product", name);
    }

    @Test
    public void testGetValue() {
        double value = product.getProductValue();
        assertEquals(10.0, value);
    }

    @Test
    public void testSetValue() {
        product.setProductValue(20.0);
        double value = product.getProductValue();
        assertEquals(20.0, value);
    }

    @Test
    public void testGetQuantity() {
        int quantity = product.getProductQuantity();
        assertEquals(100, quantity);
    }

    @Test
    public void testSetQuantity() {
        product.setProductQuantity(200);
        int quantity = product.getProductQuantity();
        assertEquals(200, quantity);
    }
}