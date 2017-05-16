
import classes.Category;
import classes.Customer;
import classes.Material;
import facade.DBFacade;
import facade.Facade;
import facade.userAlreadyExistsException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class InitTest {

    private final DBFacade dbfacade;
    
    Connection con;
    private static String DBNAME = "fogproject";
    private static String HOST = "localhost";
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String ID = "root";
    private static String PWD = "root";
    
    public InitTest() {
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
                try {
            String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
            Class.forName(DRIVER);
            con = DriverManager.getConnection(url, ID, PWD);

            try (Statement stmt = con.createStatement()) {             
                stmt.execute("Delete from customers");
                stmt.execute("insert into customers select * from customerstest");
            }                      
            
        } catch (ClassNotFoundException | SQLException ex) {
            con = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void testSetUpToDB() {
    assertNotNull("Setup to DB failed", con);
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
    @Test
    public void getAllCategories() {
       ArrayList<Category> categories = dbfacade.getAllCategories();       
       assertTrue("getCategories failed", categories != null);
       assertTrue("getCategories failed", categories.get(1).getName().equals("tagpakken"));
    }
    @Test
    public void getAllMaterials() {
       ArrayList<Material> materials = dbfacade.getAllMaterials();       
       assertTrue("getMaterials failed", materials != null);
       assertTrue("getMaterials failed", materials.get(1).getType().equals("25x150 mm. trykimp. Bræt"));
    }
    @Test
    public void getAllLengths() {
        ArrayList lengths = dbfacade.getAllLengths();
        assertTrue("getLengths failed", lengths != null);
        assertTrue("getLengths failed", lengths.get(1).equals(270));
    }
    @Test
    public void getAllWidths() {
        ArrayList widths = dbfacade.getAllWidths();
        assertTrue("getWidths failed", widths != null);
        assertTrue("getWidths failed", widths.get(1).equals(270));   
    }
    
}