package main;

import blueprints.GenerateBlueprints;
import classes.Measurement;
import java.util.ArrayList;

public class Start {

    public static void main(String[] args) {
        GenerateBlueprints gb = new GenerateBlueprints();
        Measurement m = new Measurement();
        
        gb.sideFlatRoof(550);
        gb.sideFlatRoof2(550);
        
        ArrayList<String> mes = gb.getMeasurements();
        
        for (String a : mes) {
            System.out.println(a);
            
        }
    }

}
