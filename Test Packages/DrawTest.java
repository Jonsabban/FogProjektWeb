
import classes.Measurement;
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
public class DrawTest {
    
    private Measurement m;
    private Facade f;
    
    
    public DrawTest() {
        this.m = new Measurement();
        this.f = new Facade();
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
    
    assertEquals(expected, test);

    }
    @Test
    public void createMeasurementHSmallDistance() {
        
        String expected;
        expected = "<path id='test' d= 'M100 200 h25'/>"
                + "<text>"
                + "<textPath xlink:href='#test' startOffset='50%'>"
                + "<tspan dy='-5' text-anchor='middle' >25 </tspan>"
                + "</textPath>"
                + "</text>"
                + m.createDividerH(100, 200)
                + m.createDividerH(100 + 25 , 200);
    String test;
    test = m.createMeasurementH("test", 100, 200, 25, 25);
    
    assertEquals(expected, test);
    }
    @Test
    public void createMeasurementLongDistance() {
        String expected;
        expected = "<path id='test' d= 'M100 200 h100'/>"
                + "<text>"
                + "<textPath xlink:href='#test' startOffset='50%'>"
                + "<tspan dy='-5' text-anchor='middle' >100cm </tspan>"
                + "</textPath>"
                + "</text>"
                + m.createDividerH(100, 200)
                + m.createDividerH(100 + 100 , 200);
    String test;
    test = m.createMeasurementH("test", 100, 200, 100, 100);
    assertEquals(expected, test);
    }
    
    //Blueprints test
    
    @Test
    public void outlineTop() {
        String expected;
        expected = "<rect x='100' y='100' height='100' width='200' style='fill:rgb(255,255,255);stroke-width:2px;stroke:rgb(0,0,0)' />";
        
        assertTrue("outlineTop fails", f.outlineTop(100, 200).equals(expected));
        
    }
    @Test
    public void testStem() {
        String expected;
        int mid = (100 + 200) / 2;
        expected = "<rect x='100' y='" + (mid - 1) + "' height='2' width='200' style='fill:rgb(255,255,255);stroke-width:1px;stroke:rgb(0,0,0)' />";
        
        assertTrue("testStem fails", f.stem(100, 200).equals(expected));
    }
    @Test
    public void taglaegteUp() {
        ArrayList<String> expected = new ArrayList();
        expected.add("<path d='M100 131 L200 131 L200 135 L100 135 '/>");
        
        ArrayList<String> test = new ArrayList();
        test.addAll(f.taglaegteUp(200, 100));
        assertTrue("taglaegteUp fails", expected.get(0).equals(test.get(0)));
   
    }
    @Test
    public void taglaegteDown() {
        int mid = (200 + 200)/2;
        String expected = "<path d='M100 " + (mid + 3) + " L200 " + (mid + 3) + " L200 "+ (mid + 7) + " L100 " + (mid + 7) + " '/>";
        
        ArrayList<String> test = new ArrayList();
        test.addAll(f.taglaegteDown(200, 100));
        assertTrue("taglaegteDown fails", expected.equals(test.get(0)));
    }
    @Test
    public void createSpaerFlat() {
        String expectedFirst;
        String expectedEnd;
        ArrayList<String> test = new ArrayList();
        test.addAll(f.createSpaerFlat(200, 100));
        
        expectedFirst = "<line x1=100 y1='100' x2=100 y2=300 style='stroke:rgb(0,0,0);stroke-width:1' />";
        assertTrue("createSpaerFlat (First) fails", expectedFirst.equals(test.get(0)));
        expectedEnd = "<line x1=155 y1='100' x2=155 y2=300 style='stroke:rgb(0,0,0);stroke-width:1' />";
        assertTrue("createSpaerFlat (End) fails", expectedEnd.equals(test.get(1)));
    }
    @Test
    public void createSpaerFlatSmallEnd() {
        
    }
}
