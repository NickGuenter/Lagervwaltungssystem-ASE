package Manager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;

import com.lvs.Manager.CustomerManager;
import com.lvs.Classes.FilialCustomer;
import com.lvs.Classes.Address;

public class CustomerManagerTest {
    
    CustomerManager cm;
    @BeforeEach
    public void setUp() {
        cm = new CustomerManager();
    }

    @Test
    public void testAddCustomer() {
        CustomerManager cm = new CustomerManager();
        cm.addCustomer("Filial", "F02", new Address("Hamburg"), Optional.of("Jane Doe"));
        FilialCustomer fc = (FilialCustomer) cm.findCustomer("F02");
        assertEquals("F02", fc.getName());
        assertEquals("Hamburg", fc.getAddress());
        assertEquals("Jane Doe", fc.getContactPerson());
    }
}
