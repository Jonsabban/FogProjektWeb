package classes;

/**
 *
 * @author Jonas
 */
public class Measurement {

    public String createDividerH(int centerX, int centerY) {

        return "<line x1=" + centerX + " y1=" + (centerY - 5) + " x2=" + centerX + " y2=" + (centerY + 5) + " />";

    }

    public String createDividerV(int centerX, int centerY) {

        return "<line x1=" + (centerX - 5) + " y1=" + centerY + " x2=" + (centerX + 5) + " y2=" + centerY + " />";

    }

    public String createMeasurementH(String pathName, int pathStartX, int pathStartY, int pathEnd, int distance) {
        
        //for small distances so distance mark are still visable
        String distString = distance + "cm";
        if (distance < 30) {
            distString = distance + "";
        }
        
        return "<path id='" + pathName + "' d= 'M" + pathStartX + " " + pathStartY + " h" + pathEnd + "'/>"
                + "<text>"
                + "<textPath xlink:href='#" + pathName + "' startOffset='50%'>"
                + "<tspan dy='-5' text-anchor='middle' >" + distString + " </tspan>"
                + "</textPath>"
                + "</text>"
                + createDividerH(pathStartX, pathStartY)
                + createDividerH(pathStartX + pathEnd , pathStartY);

    }

    public String createMeasurementV(String pathName, int pathStartX, int pathStartY, int pathEnd, int distance) {
              
        return "<path id='" + pathName + "' d= 'M" + pathStartX + " " + pathStartY + " v-" + pathEnd + "'/>"
                + "<text>"
                + "<textPath xlink:href='#" + pathName + "' startOffset='50%'>"
                + "<tspan dy='-5' text-anchor='middle' >" + distance + " cm </tspan>"
                + "</textPath>"
                + "</text>"
                + createDividerV(pathStartX, pathStartY)
                + createDividerV(pathStartX, pathStartY - pathEnd);

    }
}
