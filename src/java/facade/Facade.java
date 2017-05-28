package facade;

import blueprints.GenerateBlueprints;
import classes.Category;
import classes.Customer;
import classes.Material;
import data.DataAccessObject;
import data.Encrypt;
import data.ImplDataAccess;
import java.util.ArrayList;

/**
 *
 * @author Jonas
 */
public class Facade implements FacadeInterface {
        private GenerateBlueprints gb;
 
    public Facade() {
        this.gb = new GenerateBlueprints();
    }

    @Override
    public String outlineTop(int height, int width) {
        return gb.outlineTop(height, width);
    }

    @Override
    public String stem(int height, int width) {
        return gb.stem(height, width);
    }

    @Override
    public ArrayList<String> taglaegteUp(int height, int width) {
        return gb.taglaegteUp(height, width);
    }

    @Override
    public ArrayList<String> taglaegteDown(int height, int width) {
        return gb.taglaegteDown(height, width);
    }

    @Override
    public ArrayList<String> createSpaerFlat(int height, int width) {
        return gb.createSpaerFlat(height, width);
    }

    @Override
    public ArrayList<String> postsTop(int width, boolean rejsning, boolean shed) {
        return gb.postsTop(width, rejsning, shed);
    }

    @Override
    public ArrayList<String> postsBottom(int height, int width, boolean rejsning, boolean shed) {
        return gb.postsBottom(height, width, rejsning, shed);
    }

    @Override
    public String bjaelkeTopFlat(int width) {
        return gb.bjaelkeTopFlat(width);
    }

    @Override
    public String bjaelkeBottomFlat(int width, int height) {
        return gb.bjaelkeBottomFlat(width, height);
    }

    @Override
    public ArrayList<String> createSpaerRejsning(int height, int width) {
        return gb.createSpaerRejsning(height, width);
    }

    @Override
    public String bjaelkeTopRejsning(int width) {
        return gb.bjaelkeTopRejsning(width);
    }

    @Override
    public String bjaelkeBottomRejsning(int width, int height) {
        return gb.bjaelkeBottomRejsning(width, height);
    }

    @Override
    public String vindkryds(int height, int width) {
        return gb.vindkryds(height, width);
    }

    @Override
    public String sideFlatRoof(int width) {
        return gb.sideFlatRoof(width);
    }

    @Override
    public String sideFlatRoof2(int width) {
        return gb.sideFlatRoof2(width);
    }

    @Override
    public ArrayList<String> supportPosts(int width, boolean rejsning, boolean shed, int roofHeight) {
        return gb.supportPosts(width, rejsning, shed, roofHeight);
    }

    @Override
    public ArrayList<String> getMeasurementsTop() {
        return gb.getMeasurementsTop();
    }

    @Override
    public ArrayList<String> getMeasurementsSide() {
        return gb.getMeasurementsSide();
    }

    @Override
    public String shedOutline(int height, int width, boolean rejsning) {
        return gb.shedOutline(height, width, rejsning);
    }

    @Override
    public String shedStolper(int height, int width, boolean rejsning) {
        return gb.shedStolper(height, width, rejsning);
    }

    @Override
    public ArrayList<String> shedSide(int width, boolean rejsning, int roofHeight) {
        return gb.shedSide(width, rejsning, roofHeight);
    }

    @Override
    public ArrayList<String> roofboards(int totalWidth, int roofHeight) {
        return gb.roofboards(totalWidth, roofHeight);
    }

    @Override
    public String roofHorizontal(int width, int roofHeight) {
        return gb.roofHorizontal(width, roofHeight);
    }

    @Override
    public String roofEnds(int width, int roofHeight) {
        return gb.roofEnds(width, roofHeight);
    }

    @Override
    public void calculateResultLifted(ArrayList<Material> list, int length, int width, int angle, boolean skur, int skurlength, int skurwidth) {
        
    }

    @Override
    public void calculateResultFlat(ArrayList<Material> list, int length, int width, boolean skur, int skurlength, int skurwidth) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
