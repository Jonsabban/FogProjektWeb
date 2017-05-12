
import classes.Customer;
import facade.DBFacade;
import facade.Facade;
import facade.FacadeInterface;
import facade.userAlreadyExistsException;
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
    private DBFacade dbfacade;

    public facadeTests() {
        this.facade = new Facade();
        this.dbfacade = new DBFacade();
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

    @Test (expected = userAlreadyExistsException.class)
    public void createUserUsernameAlreadyExists() throws userAlreadyExistsException {
        //test if method fails when a Username already exists
        assertFalse(dbfacade.createUser("hans", "123asd123", "...", 0, 0, "..."));
    }
    @Test
    public void createUserSuccess() throws userAlreadyExistsException {
        dbfacade.createUser("jon", "123456", "apple123", 0, 0, "nope");
        Customer user = dbfacade.getUser("jon", "123456");
        assertEquals(user.getcName(), "jon");
    }
    

}
