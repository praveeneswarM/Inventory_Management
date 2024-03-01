package inv.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.SQLException;

public class User {

    static DB db = new DB();
    static Connection con;

    static {
        try {
            con = db.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static String In(String mail, String pass) {
        try {
            String ret = "";
            String sql = "SELECT * FROM user WHERE mail=? and sta LIKE '0'";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, mail);
            ResultSet rt = stmt.executeQuery();
            if (rt.next()) {
                String na = rt.getString("name");
                String p = rt.getString("pass");
                String ro = rt.getString("role");
                String id=rt.getString("id");
                if (p.equals(pass)){
                    ret += na + "," + ro+","+id;
                    return ret;
                }
                else
                    return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String Up(String na, String ma, String pa) {
        try {
                String sql = "INSERT INTO user (name,mail,pass) VALUES(?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, na);
                stmt.setString(2, ma);
                stmt.setString(3, pa);
                int rt = stmt.executeUpdate();
                if (rt > 0) {
                    return "--Added Succesfully--";
                } 
            }
            catch (SQLException e) {
            e.printStackTrace();
        }
        return "--Enter Valid--";
    }
    public static String Up(String na, String ma, String pa,String role) {
        try {
                String sql = "INSERT INTO user (name,mail,pass,role) VALUES(?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, na);
                stmt.setString(2, ma);
                stmt.setString(3, pa);
                stmt.setString(4, role);
                int rt = stmt.executeUpdate();
                if (rt > 0) {
                    return "--Added Succesfully--";
                } 
            }
            catch (SQLException e) {
            e.printStackTrace();
        }
        return "--Enter Valid--";
    }


}
