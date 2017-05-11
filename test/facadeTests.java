
import classes.Customer;
import facade.Facade;
import facade.FacadeInterface;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonas
 */
public class facadeTests {

    private FacadeInterface facade;

    public facadeTests() {
        facade = new Facade();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testCreateUser() {
        //test if method fails when a Username already exists
        assertFalse(facade.createUser("hans", "123asd123", "...", 0, 0, "..."));
    }
    @Test
    public void testGetUser() {
        Customer user = facade.getUser("jon", "123456");
        assertEquals(user.getcName(), "jon");
        
    }

}
