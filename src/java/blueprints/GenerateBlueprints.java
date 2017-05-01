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
    
    public String sideFlatRoof2(int width) {
        
        String roofPath2;
        
        int length = width - 4;
        double angel = (width/100) * 0.98;
        
        roofPath2 = "<path id='roof' d=' M102 107 l" + length + " " + angel +  " v7 l-" + length + " -" + angel + " z  > " + "<use xlink:href='#roof' fill='white' stroke='black'  />";
        
    return roofPath2;
    }
    
    public ArrayList<String> supportPosts(int width, int height) {
        
        ArrayList<String> posts = new ArrayList();
     
        String post1 = "<rect width='10' height='230' x='200' y='101' style='stroke-width:1px;stroke:black;fill:white;'/>";
        String post2 = "<rect width='10' height='220' x='" + width + "' y='110' style='stroke-width:1px;stroke:black;fill:white;'/>";
        
        posts.add(post1);
        posts.add(post2);
        
        return posts;
    }
    
    
}
