
package facade;

import classes.Category;
import classes.Customer;
import classes.Material;
import java.util.ArrayList;

/**
 *
 * @author Sanox
 */
public interface DBFacadeInterface {
    
    // Categories
    public ArrayList<Category> getAllCategories();

    // Materials
    public ArrayList<Material> getAllMaterials();

    // Customers
    public ArrayList<String> getAllUserNames();
    public Customer getUser(String username, String password);
    public boolean createUser(String name, String password, String address, int zipcode, int phone, String email) throws userAlreadyExistsException;

    // Length & Width
    public ArrayList<Integer> getAllLengths();
    public ArrayList<Integer> getAllWidths();
}
