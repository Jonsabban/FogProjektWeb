package facade;

import classes.Category;
import classes.Customer;
import classes.Material;
import java.util.ArrayList;

/**
 *
 * @author Jonas
 */
public interface FacadeInterface {
    
    
    // Categories
    public ArrayList<Category> getAllCategories();

    // Materials
    public ArrayList<Material> getAllMaterials();
    
    // Customers
    public ArrayList<String> getAllUserNames();
    public Customer getUser(String username, String password);
    public boolean createUser(String name, String password, String address, int zipcode, int phone, String email);
    
    // Length & Width
    public ArrayList<Integer> getAllLengths();
    public ArrayList<Integer> getAllWidths();
    
    
    
    
}
