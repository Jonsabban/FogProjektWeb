
import classes.Measurement;
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
public class DrawTest {
    
    private Measurement m;
    
    
    public DrawTest() {
        this.m = new Measurement();
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
    public void testCreateDividerH() {
        
        String expected;
        expected = "<line x1=100 y1=195 x2=100 y2=205 />";
        String test;
        test = m.createDividerH(100, 200);
        
        assertEquals(expected, test);
        
    }
    @Test
    public void testCreateDividerV() {
        
        String expected;
        expected = "<line x1=95 y1=200 x2=105 y2=200 />";
        String test;
        test = m.createDividerV(100, 200);
                
        assertEquals(expected, test);
    }
    @Test
    public void testCreateMeasurementV() {
      
    String expected;
    expected = "<path id='test' d= 'M100 200 v-100'/>"
                + "<text>"
                + "<textPath xlink:href='#test' startOffset='50%'>"
                + "<tspan dy='-5' text-anchor='middle' >100 cm </tspan>"
                + "</textPath>"
                + "</text>"
                + m.createDividerV(100, 200)
                + m.createDividerV(100, 200 - 100);
    String test;
    test = m.createMeasurementV("test", 100, 200, 100, 100);
        System.out.println(test);
    
    assertEquals(expected, test);

    }
    
    
}
