/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blueprints;

import java.util.ArrayList;

/**
 *
 * @author alexander
 */
public class GenerateBlueprints {
        
    public ArrayList<String> createSpær(int height, int width) {
    ArrayList<String> spær = new ArrayList();
    
    int spærDistance = 0;
    
    while (spærDistance < width) {
        
    spær.add("<line x1=" + spærDistance + " y1=\"0\" x2=" + spærDistance + " y2=" + height + " style=\"stroke:rgb(0,0,0);stroke-width:1\" />");
    
    spærDistance += 55;
    }
    
    return spær;
    };
    
    public String sideFlatRoof(int width) {
        
        String roofPath;
        
        int length = width;
        double angel = (length/100) * 0.98;
        
        roofPath = "<path id='roof' d=' M100 100 l" + length + " " + angel +  " v7 l-" + length + " -" + angel + " z  > " + "<use xlink:href='#roof' fill='white' stroke='black'  />";
        
        return roofPath;
        
    }
    
    
}
