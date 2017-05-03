/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueprints;

import classes.Measurement;
import java.util.ArrayList;

/**
 *
 * @author alexander
 */
public class GenerateBlueprints {
    Measurement m = new Measurement();
    
    ArrayList<String> measureArray = new ArrayList();

    //*NOTE* width and height is switched because it's going to be sideways.
    public ArrayList<String> createSpær(int height, int width) {
        ArrayList<String> spær = new ArrayList();

        int spærDistance = 100;

        while (spærDistance < (width + 100)) {

            spær.add("<line x1=" + spærDistance + " y1=\"100\" x2=" + spærDistance + " y2=" + (height + 100) + " style=\"stroke:rgb(0,0,0);stroke-width:1\" />");

            spærDistance += 55;
        }

        return spær;
    }

    ;

    public String midTop(int height, int width) {
        String end;
        if (width < 310) {
            end = "<rect x=" + (width / 2) + " y=\"30\" height=\"10\" width=\"10\" style=\"fill:rgb(0,0,0)\" />";
        } else {
            end = "";
        }
        return end;
    }

    public String midBottom(int height, int width) {
        String end;
        if (width < 310) {
            end = "<rect x=" + (width / 2) + " y=" + (height - 30) + " height=\"10\" width=\"10\" style=\"fill:rgb(0,0,0)\" />";
        } else {
            end = "";
        }
        return end;
    }

    public String sideFlatRoof(int width) {

        String roofPath;
        String measurement;

        int length = width;
        double angel = (length / 100) * 0.98;

        roofPath = "<path id='roof' d=' M100 100 l" + length + " " + angel + " v7 l-" + length + " -" + angel + " z'/>";
        measurement = m.createMeasurementV("sideFlatRoof", 50, 330, 230, 230);
        
        measureArray.add(measurement);
        
        return roofPath;
    }

    public String sideFlatRoof2(int width) {

        String roofPath2;
        String measurement;

        int length = width - 4;
        double angel = (width / 100) * 0.98;

        roofPath2 = "<path id='roof2' d=' M102 107 l" + length + " " + angel + " v7 l-" + length + " -" + angel + " z'/>";
        measurement = m.createMeasurementV("sideFlatRoof2", 80, 330, 220, 210);
        
        measureArray.add(measurement);
        
        return roofPath2;
    }

    public ArrayList<String> supportPosts(int width, int height) {

        ArrayList<String> posts = new ArrayList();
        String measurePost1;
        String measurePost2;
        String measureToEnd;

        
        String post1 = "<rect width='10' height='230' x='200' y='101' style='stroke-width:1px;stroke:black;fill:white;'/>";
        String post2 = "<rect width='10' height='220' x='" + width + "' y='111' style='stroke-width:1px;stroke:black;fill:white;'/>";
        //Measurements and ground lines
        measurePost1 = m.createMeasurementH("post1", 100, 341, 100, 100);
        measurePost2 = m.createMeasurementH("post2", 200, 341, width - 200, width - 200);
        measureToEnd = m.createMeasurementH("toEnd", width, 341, 100, 100);

        
        posts.add(post1);
        posts.add(post2);
        
        measureArray.add(measurePost1);
        measureArray.add(measurePost2);
        measureArray.add(measureToEnd);


        return posts;
    }

    public ArrayList<String> getMeasurements() {
        
        return measureArray;
    }

}
