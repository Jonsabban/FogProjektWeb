
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void calcTest() {
        
        ArrayList<Material> MAL = DB.getAllMaterials();
        f.calculateResultLifted(MAL, 510, 540, 15, true, 210, 360);
        
        
        
    }
    
    
    
}



