
import classes.Material;
import facade.DBFacade;
import facade.Facade;
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
public class CalculatorTest {
    
        private Facade f;
        private DBFacade DB;
    
    public CalculatorTest() {
        this.f = new Facade();
        this.DB = new DBFacade();
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

    
    @Test
    public void calcTestRasiedRoofWithShed() {
        
        ArrayList<Material> MAL = DB.getAllMaterials();
        f.calculateResultLifted(MAL, 510, 540, 15, true, 210, 360);
        
        //Test of a list that correct
        assertTrue(MAL.get(0).getId() == 17 && MAL.get(0).getAmount() == 2);
        assertTrue(MAL.get(1).getId() == 18 && MAL.get(1).getAmount() == 2);
        assertTrue(MAL.get(2).getId() == 19 && MAL.get(2).getAmount() == 1);
        assertTrue(MAL.get(3).getId() == 20 && MAL.get(3).getAmount() == 1);
        assertTrue(MAL.get(4).getId() == 21 && MAL.get(4).getAmount() == 9);
        assertTrue(MAL.get(5).getId() == 22 && MAL.get(5).getAmount() == 2);
        assertTrue(MAL.get(6).getId() == 23 && MAL.get(6).getAmount() == 1);
        assertTrue(MAL.get(7).getId() == 24 && MAL.get(7).getAmount() == 4);
        assertTrue(MAL.get(8).getId() == 25 && MAL.get(8).getAmount() == 6);
        assertTrue(MAL.get(9).getId() == 26 && MAL.get(9).getAmount() == 2);
        assertTrue(MAL.get(10).getId() == 27 && MAL.get(10).getAmount() == 29);
        assertTrue(MAL.get(11).getId() == 28 && MAL.get(11).getAmount() == 148);
        assertTrue(MAL.get(12).getId() == 29 && MAL.get(12).getAmount() == 3);
        assertTrue(MAL.get(13).getId() == 30 && MAL.get(13).getAmount() == 1);
        assertTrue(MAL.get(14).getId() == 31 && MAL.get(14).getAmount() == 10);
        assertTrue(MAL.get(15).getId() == 32 && MAL.get(15).getAmount() == 1);
        assertTrue(MAL.get(16).getId() == 33 && MAL.get(16).getAmount() == 72);
        assertTrue(MAL.get(17).getId() == 34 && MAL.get(17).getAmount() == 15);
        assertTrue(MAL.get(18).getId() == 35 && MAL.get(18).getAmount() == 6);
        assertTrue(MAL.get(19).getId() == 36 && MAL.get(19).getAmount() == 6);
        assertTrue(MAL.get(20).getId() == 37 && MAL.get(20).getAmount() == 2);
        assertTrue(MAL.get(21).getId() == 38 && MAL.get(21).getAmount() == 6);
        assertTrue(MAL.get(22).getId() == 39 && MAL.get(22).getAmount() == 6);
        assertTrue(MAL.get(23).getId() == 40 && MAL.get(23).getAmount() == 1);
        assertTrue(MAL.get(24).getId() == 41 && MAL.get(24).getAmount() == 2);
        assertTrue(MAL.get(25).getId() == 42 && MAL.get(25).getAmount() == 10);
        assertTrue(MAL.get(26).getId() == 43 && MAL.get(26).getAmount() == 1);
        assertTrue(MAL.get(27).getId() == 44 && MAL.get(27).getAmount() == 1);
        assertTrue(MAL.get(28).getId() == 45 && MAL.get(28).getAmount() == 1);
        assertTrue(MAL.get(29).getId() == 46 && MAL.get(29).getAmount() == 20);
        assertTrue(MAL.get(30).getId() == 47 && MAL.get(30).getAmount() == 20);
        assertTrue(MAL.get(31).getId() == 48 && MAL.get(31).getAmount() == 1);
        assertTrue(MAL.get(32).getId() == 49 && MAL.get(32).getAmount() == 1);
    }
}



