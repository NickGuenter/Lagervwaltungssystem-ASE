package Manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lvs.Classes.Address;
import com.lvs.Classes.Supplier;
import com.lvs.Manager.SupplierManager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class SupplierManagerTest {
    private SupplierManager supplierManager;
    private Supplier supplier1;
    private Supplier supplier2;

    @BeforeEach
    public void setUp() {
        supplierManager = new SupplierManager();
        supplier1 = new Supplier("Supplier1", new Address("City1"), "Contact1");
        supplier2 = new Supplier("Supplier2", new Address("City2"), "Contact2");
        supplierManager.getSuppliers().add(supplier1);
        supplierManager.getSuppliers().add(supplier2);
    }

    @Test
    public void testFindSupplier() {
        assertEquals(supplier1, supplierManager.findSupplier("Supplier1"));
        assertEquals(supplier2, supplierManager.findSupplier("Supplier2"));
        assertNull(supplierManager.findSupplier("NonexistentSupplier"));
    }

    @Test
    public void testRemoveSupplier() {
        supplierManager.removeSupplier("Supplier1");
        assertNull(supplierManager.findSupplier("Supplier1"));
    }

    @Test
    public void testGetSuppliers() {
        ArrayList<Supplier> suppliers = supplierManager.getSuppliers();
        assertEquals(2, suppliers.size());
        assertTrue(suppliers.contains(supplier1));
        assertTrue(suppliers.contains(supplier2));
    }
}
