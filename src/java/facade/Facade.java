package facade;

import classes.Category;
import classes.Customer;
import classes.Material;
import data.DataAccessObject;
import data.Encrypt;
import data.ImplDataAccess;
import java.util.ArrayList;

/**
 *
 * @author Jonas
 */
public class Facade implements FacadeInterface{
    
    private DataAccessObject dao;

    public Facade() {
        this.dao = new ImplDataAccess();
    }
    
    @Override
    public ArrayList<Category> getAllCategories() {
        return dao.getAllCategories();
    }

    @Override
    public ArrayList<Material> getAllMaterials() {
        return dao.getAllMaterials();
    }

    @Override
    public ArrayList<String> getAllUserNames() {
        return dao.getAllUserNames();
    }

    @Override
    public Customer getUser(String username, String password) {
        String eP = Encrypt.sha256(password);
        return dao.getUser(username, eP);
    }

    @Override
    public boolean createUser(String name, String password, String address, int zipcode, int phone, String email) {
        boolean success = true;
        ArrayList<String> getNames = dao.getAllUserNames();
        if (getNames.contains(name)) {
            //Username already exists in DataBase
            success = false;
        }
        else {
        dao.createUser(name, password, address, zipcode, phone, email);
        }
        return success;
    }

    @Override
    public ArrayList<Integer> getAllLengths() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> getAllWidths() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
}
