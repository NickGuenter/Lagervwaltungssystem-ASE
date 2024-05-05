package Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lvs.Classes.Address;
import com.lvs.Classes.Order;
import com.lvs.Classes.Product;
import com.lvs.Classes.Supplier;
import com.lvs.Classes.Party;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.UUID;

public class OrderTest {

    private Order order;
    private Party party;
    private ArrayList<Product> products;

    @BeforeEach
    public void setUp() {
        party = new Supplier("AT Logistics", new Address("Österreich"), "Stefan Kinzl");
        products = new ArrayList<>();
        products.add(new Product("Product 1", 10.0, 100));
        products.add(new Product("Product 2", 20.0, 200));
        order = new Order(party, products);
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
    public void testGetParty() {
        Party partyNew = new Supplier("AT Logistics", new Address("Österreich"), "Stefan Kinzl");
        assertEquals(partyNew.getName(), order.getParty().getName());
        assertEquals(partyNew.getAddress(), order.getParty().getAddress());
        assertEquals(((Supplier) partyNew).getContactPerson(), ((Supplier) order.getParty()).getContactPerson());
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

    @Test
    public void testCalculateOrderValue() {
        double orderValue = order.calculateOrderValue();
        assertEquals(5000, orderValue);
    }
}
