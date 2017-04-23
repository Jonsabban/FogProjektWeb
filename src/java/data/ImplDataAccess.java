/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

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
                    String name = rs.getString("matID");
                    String type = rs.getString("matType");
                    String mPackage = rs.getString("matPackage");
                    String desc = rs.getString("matDescription");
                    material = new Material(name, 0, 0, mPackage, desc, null);
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
