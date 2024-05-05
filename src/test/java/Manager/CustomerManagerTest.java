package Manager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;

import com.lvs.Manager.CustomerManager;
import com.lvs.Classes.FilialCustomer;
import com.lvs.Classes.PrivateCustomer;
import com.lvs.Classes.Address;
import com.lvs.Classes.Customer;

public class CustomerManagerTest {
    
    CustomerManager cm;
    @BeforeEach
    public void setUp() {
        cm = new CustomerManager();
        Customer customer = new PrivateCustomer("William Doe", new Address("Schwanau"));
        cm.getCustomers().add(customer);
    }

    @Test
    public void testFindCustomer() {
        Customer customer = cm.findCustomer("William Doe");
        assertEquals("William Doe", customer.getName());
        assertEquals("Schwanau", customer.getAddress());
    }

    @Test
    public void testAddCustomer() {
        cm.addCustomer("Filial", "F02", new Address("Hamburg"), Optional.of("Jane Doe"));
        FilialCustomer fc = (FilialCustomer) cm.findCustomer("F02");
        assertEquals("F02", fc.getName());
        assertEquals("Hamburg", fc.getAddress());
        assertEquals("Jane Doe", fc.getContactPerson());
    }

    @Test
    public void testRemoveCustomer() {
        cm.removeCustomer("William Doe");
        assertNull(cm.findCustomer("William Doe"));
    }
}
