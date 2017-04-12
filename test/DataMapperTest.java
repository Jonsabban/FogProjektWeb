
import classes.Customer;
import classes.Material;
import data.DataMapper;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexander
 */
public class DataMapperTest {

    DataMapper dm;

    @Before
    public void setUp() {
        dm = new DataMapper();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetMaterial() {

        Material material = dm.getMaterial(1);

        assertEquals(material.getId(), 1);
        assertEquals(material.getType(), "25x200 mm. trykimp. Brædt");
        assertEquals(material.getPackage(), "Stk");
        assertEquals(material.getMinAmount(), 0);
        assertEquals(material.getCategory(), "Træ & Tagplader");

        material = dm.getMaterial(9);

        assertEquals(material.getId(), 9);
        assertEquals(material.getType(), "plastmo bundskruer");
        assertEquals(material.getPackage(), "Pakke");
        assertEquals(material.getMinAmount(), 200);
        assertEquals(material.getCategory(), "Beslag & Skruer");

    }

    @Test
    public void testGetCustomer() {

        Customer customer = dm.getCustomer("NotReal@Email.fake");

        assertEquals(customer.getcID(), 1);
        assertEquals(customer.getcName(), "Testcustomer");
        assertEquals(customer.getcAddress(), "123FakeStreet");
        assertEquals(customer.getcZipcode(), 5555);
        assertEquals(customer.getcPhone(), 12345678);
        assertEquals(customer.getcEmail(), "NotReal@Email.fake");

    }

}
