/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import classes.Category;
import classes.Customer;
import classes.Material;
import java.util.ArrayList;

/**
 *
 * @author vfgya
 */
public interface DataAccessObject
{

    // Categories
    public ArrayList<Category> getAllCategories();

    // Materials
    public ArrayList<Material> getAllMaterials();
    
    // Customers
    public ArrayList<String> getAllUserNames();
    public Customer getUser(String username, String password);
    public void createUser(String name, String password, String address, int zipcode, int phone, String email);
    public void deleteUser(String name, String password);
    
    // Length & Width
    public ArrayList<Integer> getAllLengths();
    public ArrayList<Integer> getAllWidths();

}
