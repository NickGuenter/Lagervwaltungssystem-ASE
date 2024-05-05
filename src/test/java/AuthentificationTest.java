import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.lvs.Authenticfiation;
import com.lvs.Classes.User;

public class AuthentificationTest {
    @Test
    public void testRegisterTrue() {
        Authenticfiation auth = new Authenticfiation();
        auth.register("Test", "Test1234");

        User user = auth.getUser("Test");
        assertNotNull(user);
    }

    @Test
    public void testRegisterFalse() {
        Authenticfiation auth = new Authenticfiation();
        auth.register("Test", "test123");

        User user = auth.getUser("Test");
        assertNull(user);
    }

    @Test
    public void testLoginTrue() {
        Authenticfiation auth = new Authenticfiation();
        auth.register("Test", "Test1234");

        boolean login = auth.login("Test", "Test1234");
        assertTrue(login);
    }

    @Test
    public void testLoginFalse() {
        Authenticfiation auth = new Authenticfiation();
        auth.register("Test", "test123");
        auth.register("Test2", "Test1234");

        boolean login = auth.login("Test", "test123");
        boolean login2 = auth.login("Test", "Test1234");
        assertFalse(login);
        assertFalse(login2);
    }

}
