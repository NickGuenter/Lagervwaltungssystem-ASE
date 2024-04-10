package Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lvs.Classes.Customer;
import com.lvs.Classes.Order;
import com.lvs.Classes.Product;
import com.lvs.Classes.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.ArrayList;
import java.util.UUID;

public class OrderTest {

    private Order order;
    private Supplier supplier;
    private Customer customer;
    private ArrayList<Product> products;

    @BeforeEach
    public void setUp() {
        supplier = new Supplier("AT Logistics", "Österreich", "Stefan Kinzl");
        customer = new Customer("Max Mustermann");
        products = new ArrayList<>();
        products.add(new Product("Product 1", 10.0, 100));
        products.add(new Product("Product 2", 20.0, 200));
        order = new Order(supplier, products);
    }

    @Test
    public void testGetOrderId() {
        UUID orderId = order.getOrderId();
        assertNotNull(orderId);
    }

    @Test
    public void testGetOrderValue() {
        double orderValue = order.getOrderValue();
        assertEquals(5000, orderValue);
    }

    @Test
    public void testGetSupplier() {
        Supplier orderSupplier = order.getSupplier();
        assertEquals(supplier, orderSupplier);
    }

    @Test
    public void testGetProducts() {
        ArrayList<Product> orderProducts = order.getProducts();
        assertEquals(products, orderProducts);
    }

    @Test
    public void testGetOrderQuantity() {
        int orderQuantity = order.getOrderQuantity();
        assertEquals(300, orderQuantity);
    }
}
