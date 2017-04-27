/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import classes.Category;
import classes.Material;
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
public class ImplDataAccess implements DataAccessObject
{

    // en metode som henter all materialerne fra databaserne

    @Override
    public ArrayList<Material> getALlMaterialsByCatId(int id)
    {
        ArrayList<Material> materials = new ArrayList<>();
        try
        {
            DBConnector db = new DBConnector();
            Statement stmt = db.getConnection().createStatement();
            String sql = "select * from materials where FkCaID = " + id;
            Material material = null;
            try
            {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next())
                {
                    int mId = rs.getInt("matID");
                    String type = rs.getString("matType");
                    String mPackage = rs.getString("matPackage");
                    String desc = rs.getString("matDescription");
                    int caId = rs.getInt("FkCaID");
                    material = new Material(mId, type, 0, 0, mPackage, desc, id);
                    materials.add(material);
                }
            } catch (Exception ex)
            {
                Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex)
        {
            Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materials;
    }

    @Override
    public Category getCategoryById(int id)
    {
        Category category = null;
        try
        {
            DBConnector db = new DBConnector();
            Statement stmt = db.getConnection().createStatement();
            String sql = "select * from category where caID = " + id;
            try
            {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next())
                {
                    int cid = rs.getInt("caID");
                    String title = rs.getString("caTitle");
                    category = new Category(id, title);
                }
            } catch (Exception ex)
            {
                Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex)
        {
            Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return category;
    }

    @Override
    public ArrayList<Category> getAllCategories()
    {
         ArrayList<Category> categories = new ArrayList<>();
        try
        {
            DBConnector db = new DBConnector();
            Statement stmt = db.getConnection().createStatement();
            String sql = "select * from category";
            Category category = null;
            try
            {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next())
                {
                    int cId = rs.getInt("caID");
                    String title = rs.getString("caTitle");
                    category = new Category(cId, title);
                    categories.add(category);
                }
            } catch (Exception ex)
            {
                Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex)
        {
            Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    @Override
    public ArrayList<Material> getAllMaterials()
    {
        ArrayList<Material> materials = new ArrayList<>();
        try
        {
            DBConnector db = new DBConnector();
            Statement stmt = db.getConnection().createStatement();
            String sql = "select * from materials";
            Material material = null;
            try
            {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next())
                {
                    int mId = rs.getInt("matID");
                    String type = rs.getString("matType");
                    String mPackage = rs.getString("matPackage");
                    String desc = rs.getString("matDescription");
                    int caId = rs.getInt("FkCaID");
                    material = new Material(mId, type, 0, 0, mPackage, desc, caId);
                    materials.add(material);
                }
            } catch (Exception ex)
            {
                Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex)
        {
            Logger.getLogger(ImplDataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materials;
    }
}
