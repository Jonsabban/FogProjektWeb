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
        String measurements;

        int length = width;
        double angel = (length / 100) * 0.98;

        roofPath = "<path id='roof' d=' M100 100 l" + length + " " + angel + " v7 l-" + length + " -" + angel + " z>";
        measurements = 
                    "<path id='height' d= 'M50 330 v-230'/>" +
                    "<text font-family='Verdana' font-size='10' >" +
                    "<textPath xlink:href='#height' startOffset='50%'>" +
                    "<tspan dy='-5' text-anchor='middle' >2,30</tspan>" +
                    "</textPath>" +
                    "</text>";
        
        String sideRoofFladt = roofPath + measurements;
        
        return sideRoofFladt;
    }

    public String sideFlatRoof2(int width) {

        String roofPath2;

        int length = width - 4;
        double angel = (width / 100) * 0.98;

        roofPath2 = "<path id='roof' d=' M102 107 l" + length + " " + angel + " v7 l-" + length + " -" + angel + " z  > " + "<use xlink:href='#roof' fill='white' stroke='black'  />";

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

    public String ground(int width, int height) {
//    <path id='ground' d="
//              M 100 300
//              L 650 300              
//              " />
//        <use xlink:href="#ground" fill="none" stroke="black"  />

    String ground = "<path id='ground' d='' style='stroke-width:1px;stroke:black; ";

    return ground;
    }
}
