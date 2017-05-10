/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package result;

/**
 *
 * @author vfgya_000
 */
public class Calculator {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package result;

import classes.Material;
import java.util.ArrayList;

/**
 *
 * @author vfgya_000
 */
public class Calculator {

    public void calculateResultLifted(ArrayList<Material> list, int length, int width, int angle, boolean skur, int skurlength, int skurwidth) {
        for (int i = 0; i < list.size(); i++) {
            if (skur == true) {
                if (i == 1) {
                    list.get(i).setLength();
                    list.get(i).setAmount();
                }
            } else if (skur == false) {

            }
        }
    }

    public void calculateResultFlat(ArrayList<Material> list, int length, int width, boolean skur, int skurlength, int skurwidth) {
        for (int i = 0; i < list.size(); i++) {
            if (skur == true) {
                if (i == 1) {
                    list.get(i).setLength();
                    list.get(i).setAmount();
                }
            } else if (skur == false) {

            }
        }
    }
}
}
