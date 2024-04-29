package Manager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import com.lvs.Manager.CustomerManager;
import com.lvs.Classes.FilialCustomer;
import com.lvs.Classes.BusinessCustomer;
import com.lvs.Classes.Customer;
import com.lvs.Classes.PrivateCustomer;

public class CustomerManagerTest {
    
    CustomerManager cm;
    @BeforeEach
    public void setUp() {
        cm = new CustomerManager();
    }

    @Test
    public void testAddFilialCustomer() {
        CustomerManager cm = new CustomerManager();
        cm.addFilialCustomer("F02", "Hamburg", "Jane Doe");
        FilialCustomer fc = (FilialCustomer) cm.findCustomer("F02");
        assertEquals("F02", fc.getName());
        assertEquals("Hamburg", fc.getAddress());
        assertEquals("Jane Doe", fc.getContactPerson());
    }

    @Test
    public void testAddBusinessCustomer() {
        CustomerManager cm = new CustomerManager();
        cm.addBusinessCustomer("Jane Doe", "Berlin", "Jane Contact");
        BusinessCustomer bc = (BusinessCustomer) cm.findCustomer("Jane Doe");
        assertEquals("Jane Doe", bc.getName());
        assertEquals("Berlin", bc.getAddress());
        assertEquals("Jane Contact", bc.getContactPerson());
    }

    @Test
    public void testAddPrivateCustomer() {
        CustomerManager cm = new CustomerManager();
        cm.addPrivateCustomer("William Doe", "Munich");
        PrivateCustomer pc = (PrivateCustomer) cm.findCustomer("William Doe");
        assertEquals("William Doe", pc.getName());
        assertEquals("Munich", pc.getAddress());
    }
}
