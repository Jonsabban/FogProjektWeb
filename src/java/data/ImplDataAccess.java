/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import classes.Category;
import classes.Customer;
import classes.Material;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vfgya
 */
public class ImplDataAccess implements DataAccessObject {

    // en metode som henter all kategorierne fra databaserne
    @Override
    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            DBConnector db = new DBConnector();
            Statement stmt = db.getConnection().createStatement();
            String sql = "select * from category";
            Category category = null;
            try {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int cId = rs.getInt("caID");
                    String title = rs.getString("caTitle");
                    category = new Category(cId, title);
                    categories.add(category);
                }
            } catch (Exception ex) {
                Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    // en metode som henter all materialerne fra databaserne
    @Override
    public ArrayList<Material> getAllMaterials() {
        ArrayList<Material> materials = new ArrayList<>();
        try {
            DBConnector db = new DBConnector();
            Statement stmt = db.getConnection().createStatement();
            String sql = "select * from materials";
            Material material = null;
            try {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int mId = rs.getInt("matID");
                    String type = rs.getString("matType");
                    String mPackage = rs.getString("matPackage");
                    String desc = rs.getString("matDescription");
                    int caId = rs.getInt("FkCaID");
                    material = new Material(mId, type, 0, 0, mPackage, desc, caId);
                    materials.add(material);
                }
            } catch (Exception ex) {
                Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materials;
    }

    @Override
    public Customer getUser(String username, String password) {
        Customer customer = null;
        try {
            DBConnector db = new DBConnector();
            Statement stmt = db.getConnection().createStatement();
            String sql = "select * from customers where cName = '" + username + "' and cPasword = '" + password + "'";
            try {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int cid = rs.getInt("cId");
                    String cName = rs.getString("cName");
                    customer = new Customer(cid, cName, null, null, 0, 0, null);
                }
            } catch (Exception ex) {
                Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }

    @Override
    public void createUser(String name, String password, String address, int zipcode, int phone, String email) {
        DBConnector db = new DBConnector();
        try {
            String sql = "insert into customers (cName,cAddress,cZipcode,cPhone,cEmail,cPasword) values(?,?,?,?,?,?)";
            PreparedStatement stmt = db.getConnection().prepareStatement(sql);

            String eP = Encrypt.sha256(password);

            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setInt(3, zipcode);
            stmt.setInt(4, phone);
            stmt.setString(5, email);
            stmt.setString(6, eP);

            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Integer> getAllLengths() {
        ArrayList<Integer> lengths = new ArrayList<>();
        try {
            DBConnector db = new DBConnector();
            Statement stmt = db.getConnection().createStatement();
            String sql = "select lnumber from length";
            try {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int l = rs.getInt("lnumber");
                    lengths.add(l);
                }
            } catch (Exception ex) {
                Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lengths;
    }

    @Override
    public ArrayList<Integer> getAllWidths() {
        ArrayList<Integer> widths = new ArrayList<>();
        try {
            DBConnector db = new DBConnector();
            Statement stmt = db.getConnection().createStatement();
            String sql = "select wnumber from width";
            try {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int w = rs.getInt("wnumber");
                    widths.add(w);
                }
            } catch (Exception ex) {
                Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return widths;
    }

    @Override
    public ArrayList<String> getAllUserNames() {
        ArrayList<String> customers = new ArrayList<>();
        try {
            DBConnector db = new DBConnector();
            Statement stmt = db.getConnection().createStatement();
            String sql = "select cName from customers";
            try {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String name = rs.getString("cName");
                    customers.add(name);
                }
            } catch (Exception ex) {
                Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }
}
