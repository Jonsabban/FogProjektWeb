/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import classes.Material;
import java.util.ArrayList;

/**
 *
 * @author vfgya
 */
public interface DataAccessObject {
    
    // Materials
    public ArrayList<Material> getAllMaterials();
    
}
