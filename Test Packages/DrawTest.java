
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
        test.addAll(f.createSpaerFlat(330, 330));
        
        expectedFirst = "<line x1=100 y1='100' x2=100 y2=430 style='stroke:rgb(0,0,0);stroke-width:1' />";
        assertTrue("createSpaerFlat (First) fails", expectedFirst.equals(test.get(0)));
        expectedEnd = "<line x1=375 y1='100' x2=375 y2=430 style='stroke:rgb(0,0,0);stroke-width:1' />";
        assertTrue("createSpaerFlat (End) fails", expectedEnd.equals(test.get(test.size()-1)));
    }
    @Test
    public void createSpaerFlatSmallEndMeasurements() {
        String expected;
        ArrayList<String> test = new ArrayList();
        f.createSpaerFlat(600, 600);
        test.addAll(f.getMeasurementsTop());
        expected = "<path id='spaerEnd' d= 'M650 90 h50'/>"
                + "<text><textPath xlink:href='#spaerEnd' startOffset='50%'><tspan dy='-5' text-anchor='middle' >50cm </tspan></textPath></text>"
                + "<line x1=650 y1=85 x2=650 y2=95 />"
                + "<line x1=700 y1=85 x2=700 y2=95 />";

        assertTrue("SpaerFlatSmallEndMeasurementsMeasurement fails", expected.equals(test.get(test.size()-1)));
        }
    @Test
    public void createSpaerRejsning() {
        String expectedFirst;
        String expectedEnd;
        ArrayList<String> test = new ArrayList();
        test.addAll(f.createSpaerRejsning(600, 450));

        expectedFirst = "<path d='M100 100 L100 700 L105 700 L105 100' />";
        assertTrue("createSpaerRejsning (First) fails", expectedFirst.equals(test.get(0)));
        expectedEnd = "<path d='M460 100 L460 700 L465 700 L465 100' />";
        assertTrue("createSpaerRejsning (End) fails", expectedEnd.equals(test.get(test.size()-1)));
        
    }
    @Test
    public void createSpaerRejsningSmallEndMeasurements() {
        String expected;
        ArrayList<String> test = new ArrayList();
        f.createSpaerRejsning(600, 600);
        test.addAll(f.getMeasurementsTop());

        expected = "<path id='spaerEnd' d= 'M640 90 h60'/>"
                + "<text><textPath xlink:href='#spaerEnd' startOffset='50%'>"
                + "<tspan dy='-5' text-anchor='middle' >60cm </tspan></textPath></text>"
                + "<line x1=640 y1=85 x2=640 y2=95 /><"
                + "line x1=700 y1=85 x2=700 y2=95 />";

        assertTrue("SpaerFlatSmallEndMeasurementsMeasurement fails", expected.equals(test.get(test.size()-1)));
        }
    @Test
    public void postsTopFlatNoShed2Posts() {
        String expected1;
        String expected2;
        ArrayList<String> test = new ArrayList();
        test.addAll(f.postsTop(270, false, false));

        expected1 = "<rect width='10' height='10' x='200' y='130' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        assertTrue("postsTopFlatNoShed2Posts fails", expected1.equals(test.get(0)));
        expected2 = "<rect width='10' height='10' x='320' y='130' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        assertTrue("postsTopFlatNoShed2Posts fails", expected2.equals(test.get(1)));        
    }
    @Test
    public void postsTopHighRoofNoShed2Posts() {
        String expected1;
        String expected2;
        ArrayList<String> test = new ArrayList();
        test.addAll(f.postsTop(270, true, false));

        expected1 = "<rect width='10' height='10' x='190' y='120' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        assertTrue("postsTopHighRoofNoShed2Posts fails", expected1.equals(test.get(0)));
        expected2 = "<rect width='10' height='10' x='340' y='120' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        assertTrue("postsTopHighRoofNoShed2Posts fails", expected2.equals(test.get(1)));        
        }
    @Test
    public void postsTopFlatShed() {
        String expected1;
        String expected2;
        String expected3;
        ArrayList<String> test = new ArrayList();
        test.addAll(f.postsTop(600, false, true));
        
        expected1 = "<rect width='10' height='10' x='200' y='130' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        assertTrue("postsTopFlatShed fails", expected1.equals(test.get(0)));
        expected2 = "<rect width='10' height='10' x='570' y='130' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        assertTrue("postsTopFlatShed fails", expected2.equals(test.get(1)));
        expected3 = "<rect width='10' height='10' x='385' y='130' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        assertTrue("postsTopFlatShed fails", expected3.equals(test.get(2)));
    }
    @Test
    public void postsBottomFlat2PostsNoShed() {
        String expected1;
        String expected2;
        ArrayList<String> test = new ArrayList();
        test.addAll(f.postsBottom(270, 270, false, false));

        expected1 = "<rect width='10' height='10' x='200' y='330' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        assertTrue("postsBottomFlat2PostsNoShed fails", expected1.equals(test.get(0)));
        expected2 = "<rect width='10' height='10' x='320' y='330' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        assertTrue("postsBottomFlat2PostsNoShed fails", expected2.equals(test.get(1)));        
        }
    @Test
    public void postsBottomFlatRoof3PostsShed() {
        String expected1;
        String expected2;
        String expected3;
        ArrayList<String> test = new ArrayList();
        test.addAll(f.postsBottom(600, 600, false, true));

        expected1 = "<rect width='10' height='10' x='200' y='660' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        assertTrue("postsBottomHighRoof3PostsShed fails", expected1.equals(test.get(0)));
        expected2 = "<rect width='10' height='10' x='570' y='660' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        assertTrue("postsBottomHighRoof3PostsShed fails", expected2.equals(test.get(1)));
        expected3 = "<rect width='10' height='10' x='385' y='660' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        assertTrue("postsBottomHighRoof3PostsShed fails", expected3.equals(test.get(2)));        
        }
    @Test
    public void postsBottomHighRoof3PostsShed() {
        String expected1;
        String expected2;
        String expected3;
        ArrayList<String> test = new ArrayList();
        test.addAll(f.postsBottom(600, 600, true, true));

        expected1 = "<rect width='10' height='10' x='190' y='670' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        assertTrue("postsBottomHighRoof3PostsShed fails", expected1.equals(test.get(0)));
        expected2 = "<rect width='10' height='10' x='580' y='670' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        assertTrue("postsBottomHighRoof3PostsShed fails", expected2.equals(test.get(1)));
        expected3 = "<rect width='10' height='10' x='385' y='670' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        assertTrue("postsBottomHighRoof3PostsShed fails", expected3.equals(test.get(2)));        
        }
    @Test
    public void bjaelkeTopFlat() {
        String expected;
        expected = "<path d='M100 132 L370 132 L370 138 L100 138 Z' />";
        assertTrue("bjaelkeTopFlat fails", expected.equals(f.bjaelkeTopFlat(270)));
        
    }
    @Test
    public void bjaelkeBottomFlat() {
        String expected;
        expected = "<path d='M100 332 L370 332 L370 338 L100 338 Z' />";
        assertTrue("bjaelkeBottomFlat fails", expected.equals((f.bjaelkeBottomFlat(270, 270))));
        
    }
    @Test
    public void bjaelkeTopRejsning() {
        String expected;
        expected = "<path d='M115 122 L370 122 L370 128 L115 128 Z' />";
        assertTrue("bjaelkeTopRejsning fails", expected.equals((f.bjaelkeTopRejsning(270))));
        
    }
    @Test
    public void bjaelkeBottomRejsning() {
        String expected;
        expected = "<path d='M115 342 L370 342 L370 348 L115 348 Z' />";
        assertTrue("bjaelkeBottomRejsning fails", expected.equals(f.bjaelkeBottomRejsning(270, 270)));
        
    }
    @Test
    public void vindkryds() {
        String expected;
        String test;
        test = f.vindkryds(270, 270);
        expected = "<path stroke-dasharray='5,5' d='M155 135 L315 332 L320 332 L160 135 Z' /> \n" +
        "<path stroke-dasharray='5,5' d='M155 332 L315 135 L320 135 L160 332 Z' />";
        assertTrue("vindkryds fails", expected.equals(test));
        }
    @Test
    public void sideFlatRoof() {
        String expected;
        expected = "<path id='roof' d=' M100 100 l270 1.96 v7 l-270 -1.96 z'/>";
        assertTrue("sideFlatRoof fails", expected.equals(f.sideFlatRoof(270)));
    }
    @Test
    public void sideFlatRoof2() {
        String expected;
        expected = "<path id='roof2' d=' M102 107 l266 1.96 v7 l-266 -1.96 z'/>";
        assertTrue("sideFlatRoof2 fails", expected.equals(f.sideFlatRoof2(270)));
    }
    @Test
    public void supportPosts2PostsFlatNoShed() {
        String expected1;
        String expected2;
        ArrayList<String> test = new ArrayList();
        test.addAll(f.supportPosts(270, false, false, 15));
        
        expected1 = "<rect width='10' height='212' x='150' y='108' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        expected2 = "<rect width='10' height='212' x='310' y='108' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        assertTrue("supportPosts2PostsFlatNoShed fails", expected1.equals(test.get(0)));
        assertTrue("supportPosts2PostsFlatNoShed fails", expected2.equals(test.get(1)));
    }
    @Test
    public void supportPosts3PostsHighRoofShed() {
        String expected1;
        String expected2;
        String expected3;
        ArrayList<String> test = new ArrayList();
        test.addAll(f.supportPosts(600, true, true, 15));
        
        expected1 = "<rect width='10' height='212' x='190' y='143' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        expected2 = "<rect width='10' height='212' x='570' y='143' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        expected3 = "<rect width='10' height='212' x='380' y='143' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />";
        assertTrue("supportPosts3PostsHighRoofShed fails", expected1.equals(test.get(0)));
        assertTrue("supportPosts3PostsHighRoofShed fails", expected2.equals(test.get(1)));
        assertTrue("supportPosts3PostsHighRoofShed fails", expected3.equals(test.get(2)));
    }
    @Test
    public void shedOutlineHighRoof() {
        String expected;
        expected =
                "<path d='M120 120 L340 120 L340 350 L120 350 Z ' stroke-width='2' stroke-dasharray='6,2' /> \n" +
                " <path d='M121 121 L339 121 L339 349 L121 349 Z stroke-width='1' />";
        assertTrue("shedOutlineHighRoof fails", expected.equals(f.shedOutline(270, 270, true)));
        
    }
    @Test
    public void shedOutlineFlatRoof() {
        String expected;
        expected =
                "<path d='M120 130 L340 130 L340 340 L120 340 Z ' stroke-width='2' stroke-dasharray='6,2' /> \n" +
                " <path d='M121 131 L339 131 L339 339 L121 339 Z stroke-width='1' />";
        assertTrue("shedOutlineFlatRoof fails", expected.equals(f.shedOutline(270, 270, false)));
        
    }
    @Test
    public void shedStolperFlatRoof() {
        String expected;
        expected =
        "<rect width='10' height='10' x='121' y='131' style='fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)' /> \n" +
        " <rect width='10' height='10' x='329' y='131' style='fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)' /> \n" +
        "<rect width='10' height='10' x='121' y='329' style='fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)' /> \n" +
        "<rect width='10' height='10' x='329' y='329' style='fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)' /> \n" +
        "<rect width='10' height='10' x='121' y='230' style='fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)' /> \n" +
        "<rect width='10' height='10' x='329' y='230' style='fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)' />";
        assertTrue("shedStolperFlatRoof fails", expected.equals(f.shedStolper(270, 270, false)));
        
    }
    @Test
    public void shedSideHighRoof() {
       String expected;
       String expectedMid;
       String expectedEnd;
       ArrayList<String> test = new ArrayList();
       test.addAll(f.shedSide(270, true, 15));
       
       expected = "<path d='M120 143 L120 353 L128 353 L128 143 Z' />";
       expectedMid = "<path d='M228 143 L228 353 L236 353 L236 143 Z' />";
       expectedEnd = "<path d='M336 143 L336 353 L344 353 L344 143 Z' />";
       
       assertTrue("shedSideFlatRoofStart fails", expected.equals(test.get(0)));
       assertTrue("shedSideFlatRoofMid fails", expectedMid.equals(test.get(test.size()/2)));
       assertTrue("shedSideFlatRoofEnd fails", expectedEnd.equals(test.get(test.size()-1)));

    }
    @Test
    public void shedSideFlatRoof() {
       String expected;
       String expectedMid;
       String expectedEnd;
       ArrayList<String> test = new ArrayList();
       test.addAll(f.shedSide(270, false, 15));

       expected = "<path d='M120 108 L120 318 L128 318 L128 108 Z' />";
       expectedMid = "<path d='M228 108 L228 318 L236 318 L236 108 Z' />";
       expectedEnd = "<path d='M336 108 L336 318 L344 318 L344 108 Z' />";
       
       assertTrue("shedSideFlatRoofStart fails", expected.equals(test.get(0)));
       assertTrue("shedSideFlatRoofMid fails", expectedMid.equals(test.get(test.size()/2)));
       assertTrue("shedSideFlatRoofEnd fails", expectedEnd.equals(test.get(test.size()-1)));

    }
    
    
}
    


