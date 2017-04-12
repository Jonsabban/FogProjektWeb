package data;

import classes.Customer;
import classes.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataMapper {

    private final Connection conn;

    public DataMapper() {
        conn = new DBConnector().getConnection();
    }

    public Material getMaterial(int id) {
        Material material = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQLString = "select * from MATERIALS where partID = ? ";
        try {

            stmt = conn.prepareStatement(SQLString);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int partId = rs.getInt("partID");
                String type = rs.getString("partType");
                int minAmount = rs.getInt("partMinAmount");
                String packages = rs.getString("partPackage");
                String category = rs.getString("partCategory");
                material = new Material(partId, type, minAmount, packages, category);
            }

        } catch (SQLException e) {
            System.out.println("Fail in DataMapper - getMaterial");
            System.out.println(e.getMessage());
        }
        return material;
    }

    public Customer getCustomer(String email) {
        Customer customer = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        String SQLString = "select * from Customers where cEmail = ?";
        try {
            stmt = conn.prepareStatement(SQLString);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int cID = rs.getInt("cID");
                String cName = rs.getString("cName");
                String cAddress = rs.getString("cAddress");
                int cZipcode = rs.getInt("cZipcode");
                int cPhone = rs.getInt("cPhone");
                String cEmail = rs.getString("cEmail");
                customer = new Customer(cID, cName, cAddress, cZipcode, cPhone, cEmail);
            }

        } catch (SQLException e) {
            System.out.println("Fail in DataMapper - getCustomer");
            System.out.println(e.getMessage());
        }
        return customer;
    }

}
