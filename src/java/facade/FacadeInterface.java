package facade;

import classes.Category;
import classes.Customer;
import classes.Material;
import java.util.ArrayList;

/**
 *
 * @author Jonas
 */
public interface FacadeInterface {
   

    
    //Top
    public String outlineTop(int height, int width);
    public String stem(int height, int width);
    public ArrayList<String> taglaegteUp(int height, int width);
    public ArrayList<String> taglaegteDown(int height, int width);
    public ArrayList<String> createSpaerFlat(int height, int width);
    public ArrayList<String> postsTop(int width, boolean rejsning, boolean shed);
    public ArrayList<String> postsBottom(int height, int width, boolean rejsning, boolean shed);
    public String bjaelkeTopFlat(int width);
    public String bjaelkeBottomFlat(int width, int height);
    //Top width raised roof
    public ArrayList<String> createSpaerRejsning(int height, int width);
    public String bjaelkeTopRejsning(int width);
    public String bjaelkeBottomRejsning(int width, int height);
    public String vindkryds(int height, int width);

    //Side view
    public String sideFlatRoof(int width);
    public String sideFlatRoof2(int width);
    public ArrayList<String> supportPosts(int width, boolean rejsning, boolean shed, int roofHeight);
    public ArrayList<String> getMeasurementsTop();
    public ArrayList<String> getMeasurementsSide();

    //Shed
    public String shedOutline(int height, int width, boolean rejsning);
    public String shedStolper(int height, int width, boolean rejsning);
    public ArrayList<String> shedSide(int width, boolean rejsning, int roofHeight);
    public ArrayList<String> roofboards(int totalWidth, int roofHeight);
    public String roofHorizontal(int width, int roofHeight);
    public String roofEnds(int width, int roofHeight);
    
    //Material List
    public void calculateResultLifted(ArrayList<Material> list, int length, int width, int angle, boolean skur, int skurlength, int skurwidth);
    public void calculateResultFlat(ArrayList<Material> list, int length, int width, boolean skur, int skurlength, int skurwidth);
}
