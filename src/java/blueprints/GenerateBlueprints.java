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
        
        // "<path d='M100 " + (mid - 1) + " L" + (width+100) + " " 
        // + (mid - 1) + " L" + (width+100) + " " + (mid + 1) + " L100 " 
        // + (mid + 1) + "'  />"
        return stem;
    }
    
    public ArrayList<String> taglaegteUp(int height, int width) {
        ArrayList<String> taglaegteUp = new ArrayList();
        int mid = (height + 200)/2;
        int dif = ((height + 65) - (mid + 7)) / 5;
        
        // top taglaegte
        taglaegteUp.add("<path d='M100 131 L" + (width + 100) + " 131 L" 
                + (width + 100) + " 135 L100 135 '/>");
        
        // between taglaegte
        int y = (mid - 7) - dif;
        while (y - 4 >= 139) {
            taglaegteUp.add("<path d='M100 " + y + " L" + (width + 100) 
                + " " + y + " L" + (width + 100) + " " + (y - 4) 
                + " L100 " + (y - 4) + " '/>");
            y -= dif;

        }
        
        // bottom taglaegte
        taglaegteUp.add("<path d='M100 " + (mid-3) + " L" + (width + 100) 
                + " " + (mid-3) + " L" + (width + 100) + " " + (mid-7) 
                + " L100 " + (mid-7) + " '/>");
        
        return taglaegteUp;
    }
    
    public ArrayList<String> taglaegteDown(int height, int width) {
        ArrayList<String> taglaegteDown = new ArrayList();
        int mid = (height + 200)/2;
        
        int dif = ((height + 65) - (mid + 7)) / 5; 
        // top taglaegte
        taglaegteDown.add("<path d='M100 " + (mid + 3) + " L" + (width + 100) 
                + " " + (mid + 3) + " L" + (width + 100) + " " + (mid + 7) 
                + " L100 " + (mid + 7) + " '/>");
        
        // between taglaegte
        int y = (mid + 7) + dif;
        while ( y + 4 <= ((height + 100) - 35)) {
            taglaegteDown.add("<path d='M100 " + y + " L" + (width + 100) 
                + " " + y + " L" + (width + 100) + " " + (y + 4) 
                + " L100 " + (y + 4) + " '/>");
            y += dif;  
        }
        
        // bottom taglaegte most 
        taglaegteDown.add("<path d='M100 " + ((height + 100) - 35) + " L" 
                + (width + 100) + " " + ((height + 100) - 35) + " L" 
                + (width + 100) + " " + ((height + 100) - 31) + " L100 " 
                + ((height + 100) - 31) + " '/>");
        
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

            spaer.add("<path d='M" + spaerDistance + " 100 L" + spaerDistance 
                    + " " + (height + 100) + " L" + (spaerDistance + 5) + " " 
                    + (height + 100) + " L" + (spaerDistance + 5) + " 100' />");
            
            measurement = m.createMeasurementH("spaer" + spaernb, spaerDistance, 90, 90, 90);
            
            spaerDistance += 90;
            spaernb += 1;
            if(spaerDistance <= (width + 100))
                measureArrayTop.add(measurement);
            else if(spaerDistance > 0) {
                measurement = m.createMeasurementH("spaerEnd", spaerDistance - 90, 90, (width % 90), (width % 90));
                measureArrayTop.add(measurement);
            }
        }

        return spaer;
    }
    
    public ArrayList<String> postsTop( int width, boolean rejsning, boolean shed) {
        ArrayList<String> postsTop = new ArrayList();
        int y;
        int xStart;
        int xEnd;
        
        if (rejsning == true) {
            y = 120;
            xStart = 190;
            if (shed == true)
                xEnd = width - 20;
            else
            xEnd = width + 70;
        }
        else {
            y = 130;
            xStart = 200;
            if (shed == true)
                xEnd = width - 30;
            else
                xEnd = width + 50;
        }
        
        postsTop.add("<rect width='10' height='10' x='" + xStart + "' y='" 
                + y + "' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />");
        postsTop.add("<rect width='10' height='10' x='" + xEnd 
                + "' y='" + y + "' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />");
        
        
        if ((xEnd - xStart) > 310) {
            int between = (xEnd + xStart)/2;
            postsTop.add("<rect width='10' height='10' x='" 
                + between + "' y='" + y + "' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />");
        }
                
        return postsTop;
    }
    
    public ArrayList<String> postsBottom(int height, int width, boolean rejsning, boolean shed) {
        ArrayList<String> postsBottom = new ArrayList();
        int y;
        int xStart;
        int xEnd;
        
        if (rejsning == true) {
            y = height + 70;
            xStart = 190;
            
            if (shed == true)
                xEnd = width - 20;
            else
                xEnd = width + 70;
            
        }
        else {
            y = height + 60;
            xStart = 200;
            
            if (shed == true)
                xEnd = width - 30;
            else
                xEnd = width + 50;
        }
        
        postsBottom.add("<rect width='10' height='10' x='" + xStart + "' y='" 
                + y  + "' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />");
        postsBottom.add("<rect width='10' height='10' x='" + xEnd 
                + "' y='" + y + "' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />");
        
        if ((xEnd - xStart) > 310) {
            int between = (xEnd + xStart)/2;
            postsBottom.add("<rect width='10' height='10' x='" 
                + between + "' y='" + y + "' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />");
        }
        return postsBottom;
    }
    
    public String bjaelkeTopFlat(int width) {
        String top;
        top = "<path d='M100 132 L" + (width + 100) + " 132 L" + (width + 100) + " 138 L100 138 Z' />";
        
        return top;
    }
    
    public String bjaelkeBottomFlat(int width, int height) {
        String bottom;
        String measurement;
        
        int startY = height + 62; //Spørg hvorfor xD
        bottom = "<path d='M100 " + startY + " L" + (width + 100) + " " + startY + " L" + (width + 100) + " " + (startY + 6) + " L100 " + (startY + 6) + " Z' />";
        
        
        measurement = m.createMeasurementV("beams", 90, startY+8, height-62, height-72);
        measureArrayTop.add(measurement);
        
        return bottom;
    }
    
    public String bjaelkeTopRejsning(int width) {
        String top;
        top = "<path d='M115 122 L" + (width + 100) + " 122 L" + (width + 100) + " 128 L115 128 Z' />";
        
        
        return top;
    }
    
    public String bjaelkeBottomRejsning(int width, int height) {
        String bottom;
        String measurement;
        
        int startY = height + 72; //Spørg hvorfor xD
        bottom = "<path d='M115 " + startY + " L" + (width + 100) + " " + startY + " L" + (width + 100) + " " + (startY+6) + " L115 " + (startY+6) + " Z' />";
        
        
        measurement = m.createMeasurementV("beams", 90, startY+8, height-62, height-72);
        measureArrayTop.add(measurement);
        
        return bottom;
    }
    
    public String vindkryds(int height, int width) {
        String end;
        int Y = (height + 100) - 38;
        end = "<path stroke-dasharray='5,5' d='M155 135 L" + (width + 45) 
                + " " + Y + " L" + (width + 50) + " " + Y + " L160 135 Z' /> \n"
                + "<path stroke-dasharray='5,5' d='M155 " + Y + " L" 
                + (width + 45) + " 135 L" + (width + 50) + " 135 L160 " + Y + " Z' />";
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
        measurement = m.createMeasurementV("sideFlatRoofEnd", width + 120, 322, 220, 230 - (length /100 * 2));
        measureArraySide.add(measurement);
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

    public ArrayList<String> supportPosts(int width, boolean rejsning, boolean shed, int roofHeight) {
        
        int xStart;
        int xEnd;
        int top = 108;
        int boardHeight = 212;
        
        if (rejsning == true) {
            xStart = 190;
            top += roofHeight + 20;
            
            if (shed == true)
                xEnd = width - 30;
            else
            xEnd = width + 60;
        }
        else {
            xStart = 150;
            
            if (shed == true)
                xEnd = width - 40;
            else
                xEnd = width + 40;
        }
        
        ArrayList<String> posts = new ArrayList();
        String measurePost1;
        String measurePost2;
        String measurePost3;
        String measureToEnd;
        
        posts.add("<rect width='10' height='"+boardHeight+"' x='" + xStart 
                + "' y='"+top+"' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />");
        posts.add("<rect width='10' height='"+boardHeight+"' x='" + xEnd 
                + "' y='"+top+"' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />");
        
        if ((xEnd - xStart) > 310) {
            int between = (xEnd + xStart)/2;
            posts.add("<rect width='10' height='"+boardHeight+"' x='" 
                + between + "' y='"+top+"' style='fill:rgb(255,255,255);stroke-width:2;stroke:rgb(0,0,0)' />");
        }
        //Measurements and ground lines
        //if there is a 3rd post
        if ((xEnd - xStart) > 310) {
        int between = (xEnd + xStart)/2;
        
        measurePost1 = m.createMeasurementH("post1", 100, 341, xStart - 100, xStart - 100);
        measurePost2 = m.createMeasurementH("post2", xStart, 341, between - xStart, between - xStart);
        measurePost3 = m.createMeasurementH("post3", between, 341, xEnd - between , xEnd - between);
        measureToEnd = m.createMeasurementH("post4", xEnd, 341, (width + 100 ) - xEnd , (width + 100 ) - xEnd);
        
        measureArraySide.add(measurePost1);
        measureArraySide.add(measurePost2);
        measureArraySide.add(measurePost3);
        measureArraySide.add(measureToEnd);
    }
         //if there is 2 posts
        else {
        measurePost1 = m.createMeasurementH("post1", 100, 341, 50, 50);
        measurePost2 = m.createMeasurementH("post2", 150, 341, xEnd - 150, xEnd - 150);
        measureToEnd = m.createMeasurementH("toEnd", xEnd, 341, width+100 - xEnd, width+100 - xEnd);

        measureArraySide.add(measurePost1);
        measureArraySide.add(measurePost2);
        measureArraySide.add(measureToEnd);
       // if there is a shed on the carport
        if (shed == true) {
            
            
            
        }
    }
         return posts;
    }

    public ArrayList<String> getMeasurementsTop() {

        return measureArrayTop;
    }

    public ArrayList<String> getMeasurementsSide() {

        return measureArraySide;
    }

    public String shedOutline(int height, int width, boolean rejsning) {
        
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
       
        
        String outline = "<path d='M" + (width - 150) + " " + yTop + " L" 
                + (width + 70) + " " + yTop + " L" + (width + 70) + " " 
                + yBottom + " L" + (width - 150) + " " + yBottom 
                + " Z ' stroke-width='2' stroke-dasharray='6,2' /> \n "
                + "<path d='M" + (width - 149) + " " + (yTop + 1) + " L" 
                + (width + 69) + " " + (yTop + 1) + " L" + (width + 69) + " " 
                + (yBottom - 1) + " L" + (width - 149) + " " + (yBottom - 1) 
                + " Z stroke-width='1' />"; 
        return outline;
    }

    public String shedStolper(int height, int width, boolean rejsning) {
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
                
        String posts = "<rect width='10' height='10' x='" + (width - 149) + "' y='" 
                + yTop  + "' style='fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)' /> \n "
                + "<rect width='10' height='10' x='" + (width + 59) + "' y='" 
                + yTop  + "' style='fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)' /> \n"
                + "<rect width='10' height='10' x='" + (width - 149) + "' y='" 
                + yBottom  + "' style='fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)' /> \n"
                + "<rect width='10' height='10' x='" + (width + 59) + "' y='" 
                + yBottom  + "' style='fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)' /> \n";
        
        String flatStolper = "<rect width='10' height='10' x='" + (width - 149) + "' y='" 
                + (mid - 5)  + "' style='fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)' /> \n"
                + "<rect width='10' height='10' x='" + (width + 59) + "' y='" 
                + (mid - 5) + "' style='fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)' />";
        
        if (rejsning == false)
            end = posts + flatStolper;
        else
            end = posts;
        
        return end;
    }

    public ArrayList<String> shedSide(int width, boolean rejsning, int roofHeight) {
        ArrayList<String> shedSide = new ArrayList();
        int bp = width - 150;
        int top = 108;
        
        if (rejsning == true)
            top += roofHeight + 20;
        
        int boardHeight = 210;
        boolean boardSide = true;
        
        while (bp <= width + 70) {

            if (boardSide == true){
                shedSide.add("<path d='M" + bp + " "+top+" L" 
                    + bp + " "+(top+boardHeight)+" L" + (bp + 8) + " "+(top+boardHeight)+" L" + (bp + 8) + " "+top+" Z' />");
                bp += 8;
                boardSide = false;
            }
            else {
                shedSide.add("<path d='M" + bp + " "+top+" L" 
                    + bp + " "+(top+boardHeight)+" L" + (bp + 4) + " "+(top+boardHeight)+" L" + (bp + 4) + " "+top+" Z' />");
                bp += 4;
                boardSide = true;
            }
            
            }
            
        return shedSide;
    }

    public ArrayList<String> roofboards(int totalWidth, int roofHeight) {
        ArrayList<String> roofBoards = new ArrayList();
        int bp = 105;
        while (bp <= totalWidth + 95) {
            roofBoards.add("<path d='M" + bp + " 105 L" 
                + bp + " "+(roofHeight + 110)+" L" + (bp + 8) + " "+(roofHeight + 110)+" L" + (bp + 8) + " 105 Z' />");
                bp += 8;
        }
        return roofBoards;
    }

    public String roofHorizontal(int width, int roofHeight) {
        String end;
        int totalWidth = width + 100;
        int top = 110;
        int boardStart = top + roofHeight;
        String rooftop = "<path d='M100 100 L"+(totalWidth+2)+" 100 L"+(totalWidth+2)+" 105 L100 105 Z' />\n"; 
        String topBoard = "<path d='M100 "+boardStart+" L"+(totalWidth+2)+" "+boardStart+" L"+(totalWidth+2)+" "+(boardStart+10)+" L100 "+(boardStart+10)+" Z' /> \n ";
        String bottomBoard = "<path d='M130 "+(boardStart+10)+" L"+(totalWidth-26)+" "+(boardStart+10)+" L"+(totalWidth-26)+" "+(boardStart+20)+" L130 "+(boardStart+20)+" Z' />";
        
        end = rooftop + topBoard + bottomBoard;
        
        return end;
    }

    public String roofEnds(int width, int roofHeight) {
        
        int totalWidth = width + 96;
        
        String front = "<rect x='98' y='98' height='"+(roofHeight+15)+"' width='8' style='fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)'/> \n";
        String back = "<rect x='"+totalWidth+"' y='98' height='"+(roofHeight+15)+"' width='8' style='fill:rgb(255,255,255);stroke-width:1;stroke:rgb(0,0,0)' />";
        String end = front + back;
        return end;
    }

}
