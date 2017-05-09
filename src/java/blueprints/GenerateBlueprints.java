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
    private ArrayList<String> measureArrayTop = new ArrayList();
    private ArrayList<String> measureArraySide = new ArrayList();

    public String outlineTop(int height, int width) {

        String outline;
        String measureHeight;
        String measureWidth;
        
        
        outline = "<rect x='100' y='100' height='" + height + "' width='" 
                + width + "' style='fill:rgb(255,255,255);stroke-width:2px;stroke:rgb(0,0,0)' />";
        
        measureWidth = m.createMeasurementH("measureWidth", 100, height + 120, width, width);
        measureHeight = m.createMeasurementV("measureHeight", 50,height+100, height, height);
        measureArrayTop.add(measureWidth);
        measureArrayTop.add(measureHeight);
        
        return outline;
    }
    
    public String stem(int height, int width) {
        int mid = (height + 200) / 2;
        String stem = "<rect x='100' y='" + (mid - 1) + "' height='2' width='" 
                + width + "' style='fill:rgb(255,255,255);stroke-width:1px;stroke:rgb(0,0,0)' />";
        
        // "<path d=\"M100 " + (mid - 1) + " L" + (width+100) + " " 
        // + (mid - 1) + " L" + (width+100) + " " + (mid + 1) + " L100 " 
        // + (mid + 1) + "\"  />"
        return stem;
    }
    
    public ArrayList<String> taglaegteUp(int height, int width) {
        ArrayList<String> taglaegteUp = new ArrayList();
        int mid = (height + 200)/2;
        int dif = ((height + 65) - (mid + 7)) / 5;
        
        // top taglaegte
        taglaegteUp.add("<path d=\"M100 131 L" + (width + 100) + " 131 L" 
                + (width + 100) + " 135 L100 135 \"/>");
        
        // between taglaegte
        int y = (mid - 7) - dif;
        while (y - 4 >= 139) {
            taglaegteUp.add("<path d=\"M100 " + y + " L" + (width + 100) 
                + " " + y + " L" + (width + 100) + " " + (y - 4) 
                + " L100 " + (y - 4) + " \"/>");
            y -= dif;

        }
        
        // bottom taglaegte
        taglaegteUp.add("<path d=\"M100 " + (mid-3) + " L" + (width + 100) 
                + " " + (mid-3) + " L" + (width + 100) + " " + (mid-7) 
                + " L100 " + (mid-7) + " \"/>");
        
        return taglaegteUp;
    }
    
    public ArrayList<String> taglaegteDown(int height, int width) {
        ArrayList<String> taglaegteDown = new ArrayList();
        int mid = (height + 200)/2;
        
        int dif = ((height + 65) - (mid + 7)) / 5; 
        // top taglaegte
        taglaegteDown.add("<path d=\"M100 " + (mid + 3) + " L" + (width + 100) 
                + " " + (mid + 3) + " L" + (width + 100) + " " + (mid + 7) 
                + " L100 " + (mid + 7) + " \"/>");
        
        // between taglaegte
        int y = (mid + 7) + dif;
        while ( y + 4 <= ((height + 100) - 35)) {
            taglaegteDown.add("<path d=\"M100 " + y + " L" + (width + 100) 
                + " " + y + " L" + (width + 100) + " " + (y + 4) 
                + " L100 " + (y + 4) + " \"/>");
            y += dif;  
        }
        
        // bottom taglaegte most 
        taglaegteDown.add("<path d=\"M100 " + ((height + 100) - 35) + " L" 
                + (width + 100) + " " + ((height + 100) - 35) + " L" 
                + (width + 100) + " " + ((height + 100) - 31) + " L100 " 
                + ((height + 100) - 31) + " \"/>");
        
        return taglaegteDown;
    }

    public ArrayList<String> createSpaerFlat(int height, int width) {
        ArrayList<String> spaer = new ArrayList();
        String measurement;

        int spaerDistance = 100;
        int spaernb = 1;

        while (spaerDistance < (width + 100)) {

            spaer.add("<line x1=" + spaerDistance + " y1='100' x2=" + spaerDistance + " y2=" + (height + 100) + " style='stroke:rgb(0,0,0);stroke-width:1' />");
            
            measurement = m.createMeasurementH("spaer" + spaernb, spaerDistance, 90, 55, 55);
            
            spaerDistance += 55;
            spaernb += 1;
            if(spaerDistance <= (width + 100))
                measureArrayTop.add(measurement);
            else if(spaerDistance > 0) {
                measurement = m.createMeasurementH("spaerEnd", spaerDistance - 55, 90, (width % 55), (width % 55));
                measureArrayTop.add(measurement);
            }
                
             
        }

        return spaer;
    }
    
    public ArrayList<String> createSpaerRejsning(int height, int width) {
        ArrayList<String> spaer = new ArrayList();
        String measurement;

        int spaerDistance = 120;
        int spaernb = 1;

        while (spaerDistance < (width + 100)) {

            spaer.add("<path d=\"M" + spaerDistance + " 100 L" + spaerDistance 
                    + " " + (height + 100) + " L" + (spaerDistance + 5) + " " 
                    + (height + 100) + " L" + (spaerDistance + 5) + " 100\" />");
            
            measurement = m.createMeasurementH("spaer" + spaernb, spaerDistance, 90, 90, 90);
            
            spaerDistance += 90;
            spaernb += 1;
            measureArrayTop.add(measurement);
        }

        return spaer;
    }
    
    public ArrayList<String> stolperTop( int width, boolean rejsning, boolean skur) {
        ArrayList<String> stolperTop = new ArrayList();
        int y;
        int xStart;
        int xEnd;
        
        if (rejsning == true) {
            y = 120;
            xStart = 190;
            if (skur == true)
                xEnd = width - 20;
            else
            xEnd = width + 70;
        }
        else {
            y = 130;
            xStart = 200;
            if (skur == true)
                xEnd = width - 30;
            else
                xEnd = width + 50;
        }
        
        stolperTop.add("<rect width=\"10\" height=\"10\" x=\"" + xStart + "\" y=\"" 
                + y + "\" style=\"fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)\" />");
        stolperTop.add("<rect width=\"10\" height=\"10\" x=\"" + xEnd 
                + "\" y=\"" + y + "\" style=\"fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)\" />");
        
        
        if ((xEnd - xStart) > 310) {
            int between = (xEnd + xStart)/2;
            stolperTop.add("<rect width=\"10\" height=\"10\" x=\"" 
                + between + "\" y=\"" + y + "\" style=\"fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)\" />");
        }
                
        return stolperTop;
    }
    
    public ArrayList<String> stolperBottom(int height, int width, boolean rejsning, boolean skur) {
        ArrayList<String> stolperBottom = new ArrayList();
        int y;
        int xStart;
        int xEnd;
        
        if (rejsning == true) {
            y = height + 70;
            xStart = 190;
            
            if (skur == true)
                xEnd = width - 20;
            else
                xEnd = width + 70;
        }
        else {
            y = height + 60;
            xStart = 200;
            
            if (skur == true)
                xEnd = width - 30;
            else
                xEnd = width + 50;
        }
        
        stolperBottom.add("<rect width=\"10\" height=\"10\" x=\"" + xStart + "\" y=\"" 
                + y  + "\" style=\"fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)\" />");
        stolperBottom.add("<rect width=\"10\" height=\"10\" x=\"" + xEnd 
                + "\" y=\"" + y + "\" style=\"fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)\" />");
        
        if ((xEnd - xStart) > 310) {
            int between = (xEnd + xStart)/2;
            stolperBottom.add("<rect width=\"10\" height=\"10\" x=\"" 
                + between + "\" y=\"" + y + "\" style=\"fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)\" />");
        }
        return stolperBottom;
    }
    
    public String bjaelkeTopFlat(int width) {
        String top;
        top = "<path d=\"M100 132 L" + (width + 100) + " 132 L" + (width + 100) + " 138 L100 138 Z\" />";
        
        return top;
    }
    
    public String bjaelkeBottomFlat(int width, int height) {
        String bottom;
        String measurement;
        
        int startY = height + 62; //Spørg hvorfor xD
        bottom = "<path d=\"M100 " + startY + " L" + (width + 100) + " " + startY + " L" + (width + 100) + " " + (startY + 6) + " L100 " + (startY + 6) + " Z\" />";
        
        
        measurement = m.createMeasurementV("beams", 90, startY+8, height-62, height-72);
        measureArrayTop.add(measurement);
        
        return bottom;
    }
    
    public String bjaelkeTopRejsning(int width) {
        String top;
        top = "<path d=\"M115 122 L" + (width + 100) + " 122 L" + (width + 100) + " 128 L115 128 Z\" />";
        
        
        return top;
    }
    
    public String bjaelkeBottomRejsning(int width, int height) {
        String bottom;
        String measurement;
        
        int startY = height + 72; //Spørg hvorfor xD
        bottom = "<path d=\"M115 " + startY + " L" + (width + 100) + " " + startY + " L" + (width + 100) + " " + (startY+6) + " L115 " + (startY+6) + " Z\" />";
        
        
        measurement = m.createMeasurementV("beams", 90, startY+8, height-62, height-72);
        measureArrayTop.add(measurement);
        
        return bottom;
    }
    
    public String vindkryds(int height, int width) {
        String end;
        int Y = (height + 100) - 38;
        end = "<path stroke-dasharray=\"5,5\" d=\"M155 135 L" + (width + 45) 
                + " " + Y + " L" + (width + 50) + " " + Y + " L160 135 Z\" /> \n"
                + "<path stroke-dasharray=\"5,5\" d=\"M155 " + Y + " L" 
                + (width + 45) + " 135 L" + (width + 50) + " 135 L160 " + Y + " Z\" />";
        return end;
    }

    public String sideFlatRoof(int width) {

        String roofPath;
        String measurement;

        int length = width;
        double angel = (length / 100) * 0.98;

        roofPath = "<path id='roof' d=' M100 100 l" + length + " " + angel + " v7 l-" + length + " -" + angel + " z'/>";
        measurement = m.createMeasurementV("sideFlatRoof", 50, 330, 230, 230);
        measureArraySide.add(measurement);
        measurement = m.createMeasurementV("sideFlatRoof", 50, 330, 230, 230);

        return roofPath;
    }

    public String sideFlatRoof2(int width) {

        String roofPath2;
        String measurement;

        int length = width - 4;
        double angel = (width / 100) * 0.98;

        roofPath2 = "<path id='roof2' d=' M102 107 l" + length + " " + angel + " v7 l-" + length + " -" + angel + " z'/>";
        measurement = m.createMeasurementV("sideFlatRoof2", 80, 330, 220, 210);

        measureArraySide.add(measurement);

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

        measureArraySide.add(measurePost1);
        measureArraySide.add(measurePost2);
        measureArraySide.add(measureToEnd);

        return posts;
    }

    public ArrayList<String> getMeasurementsTop() {

        return measureArrayTop;
    }

    public ArrayList<String> getMeasurementsSide() {

        return measureArraySide;
    }

    public String skurOutline(int height, int width, boolean rejsning) {
        
        int yTop;
        int yBottom;
        if (rejsning == true){
            yTop = 120;
            yBottom = height + 80;
        }
        else {
            yTop = 130;
            yBottom = height + 70;
        }
       
        
        String outline = "<path d=\"M" + (width - 150) + " " + yTop + " L" 
                + (width + 70) + " " + yTop + " L" + (width + 70) + " " 
                + yBottom + " L" + (width - 150) + " " + yBottom 
                + " Z \" stroke-width=\"2\" stroke-dasharray=\"8,4\" /> \n "
                + "<path d=\"M" + (width - 149) + " " + (yTop + 1) + " L" 
                + (width + 69) + " " + (yTop + 1) + " L" + (width + 69) + " " 
                + (yBottom - 1) + " L" + (width - 149) + " " + (yBottom - 1) 
                + " Z stroke-width=\"1\" />"; 
        return outline;
    }

    public String skurStolper(int height, int width, boolean rejsning) {
        String end;
        int mid = (height + 200) / 2;
        int yTop;
        int yBottom;
        if (rejsning == true){
            yTop = 121;
            yBottom = height + 69;
        }
        else {
            yTop = 131;
            yBottom = height + 59;
        }
                
        String stolper = "<rect width=\"10\" height=\"10\" x=\"" + (width - 149) + "\" y=\"" 
                + yTop  + "\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" /> \n "
                + "<rect width=\"10\" height=\"10\" x=\"" + (width + 59) + "\" y=\"" 
                + yTop  + "\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" /> \n"
                + "<rect width=\"10\" height=\"10\" x=\"" + (width - 149) + "\" y=\"" 
                + yBottom  + "\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" /> \n"
                + "<rect width=\"10\" height=\"10\" x=\"" + (width + 59) + "\" y=\"" 
                + yBottom  + "\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" /> \n";
        
        String flatStolper = "<rect width=\"10\" height=\"10\" x=\"" + (width - 149) + "\" y=\"" 
                + (mid - 5)  + "\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" /> \n"
                + "<rect width=\"10\" height=\"10\" x=\"" + (width + 59) + "\" y=\"" 
                + (mid - 5) + "\" style=\"fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)\" />";
        
        if (rejsning == false)
            end = stolper + flatStolper;
        else
            end = stolper;
        
        return end;
    }

}
