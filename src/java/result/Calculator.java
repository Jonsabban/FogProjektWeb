/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package result;

import classes.Material;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vfgya_000
 */
public class Calculator {
    
    public void calculateResult(ArrayList<Material> list, int length, int width, int angle, boolean skur, int skurlength, int skurwidth)
    {
        for(int i = 0; i < list.size(); i++)
        {
            if (i == 1)
            {
                list.get(i).setLength();
                list.get(i).setAmount();
            }
        }
    }
}
