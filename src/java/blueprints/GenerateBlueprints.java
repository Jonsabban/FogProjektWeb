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
    };

    public String midTop(int height, int width) {
        String end;
        if (width < 310) {
            end = "<rect x=" + (width / 2) + " y=\"30\" height=\"10\" width=\"10\" style=\"fill:rgb(0,0,0)\" />";
        }
        else {
            end = "";
        }
        return end;
    }
    public String midBottom(int height, int width) {
        String end;
        if (width < 310) {
            end = "<rect x=" + (width / 2) + " y=" + (height - 30) +" height=\"10\" width=\"10\" style=\"fill:rgb(0,0,0)\" />";
        }
        else {
            end = "";
        }
        return end;
    }
    
    
}
