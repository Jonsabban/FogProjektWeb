/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Sanox
 */
public class DBFacade implements DBFacadeInterface {
    
    private DataAccessObject dao;

    public DBFacade() {
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
    public boolean createUser(String name, String password, String address, int zipcode, int phone, String email) throws userAlreadyExistsException {
        boolean success = true;
        ArrayList<String> getNames = dao.getAllUserNames();
        if (getNames.contains(name)) {
            //Username already exists in DataBase
            success = false;
            throw new userAlreadyExistsException();
        } else {
            dao.createUser(name, password, address, zipcode, phone, email);
        }
        return success;
    }

    @Override
    public ArrayList<Integer> getAllLengths() {
        return dao.getAllLengths();
    }

    @Override
    public ArrayList<Integer> getAllWidths() {
        return dao.getAllWidths();
    }

    
}
