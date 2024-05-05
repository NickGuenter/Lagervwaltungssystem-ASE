package Manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lvs.Classes.Address;
import com.lvs.Classes.BusinessCustomer;
import com.lvs.Classes.Order;
import com.lvs.Classes.Party;
import com.lvs.Classes.Product;
import com.lvs.Classes.Supplier;
import com.lvs.Manager.OrderManager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class OrderManagerTest {
    private OrderManager orderManager;
    private Order order1;
    private Order order2;
    private Party party1;
    private Party party2;
    private Product product1;
    private Product product2;
    private ArrayList<Product> products;

    @BeforeEach
    public void setUp() {
        orderManager = new OrderManager();
        product1 = new Product("Product1", 10.0, 5);
        product2 = new Product("Product2", 20.0, 10);
        products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        party1 = new Supplier("Supplier1", new Address("Hamburg"), "John Doe");
        party2 = new BusinessCustomer("Customer1", new Address("Berlin"), "Jane Doe");

        order1 = new Order(party1, products);
        order2 = new Order(party2, products);
        orderManager.addOrder(order1);
    }

    @Test
    public void testGetOrders() {
        ArrayList<Order> orders = orderManager.getOrders();
        assertTrue(orders.contains(order1));
        assertFalse(orders.contains(order2));
    }

    @Test
    public void testAddOrder() {
        orderManager.addOrder(order2);
        assertTrue(orderManager.getOrders().contains(order2));
    }

    @Test
    public void testGetOrdersByProduct() {
        ArrayList<Order> ordersByProduct = orderManager.getOrdersByProduct("Product1");
        assertTrue(ordersByProduct.contains(order1));
        assertFalse(ordersByProduct.contains(order2));
    }
}