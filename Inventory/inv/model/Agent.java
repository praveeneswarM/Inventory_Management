package inv.model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.Connection;
import java.sql.SQLException;


public class Agent {

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


    public static String Aup(String na, String ma, String pa,String ph,String role) {
        try {
                String sql = "INSERT INTO user (name,mail,pass,role) VALUES(?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, na);
                stmt.setString(2, ma);
                stmt.setString(3, pa);
                stmt.setString(4, role);
                int rt = stmt.executeUpdate();
                if (rt > 0) {
                    String sq="SELECT id FROM user WHERE mail=?";
                    PreparedStatement pt=con.prepareStatement(sq);
                    pt.setString(1, ma);
                    ResultSet rrt=pt.executeQuery();
                    if(rrt.next())
                    {
                        String id=rrt.getString("id");
                        String sqq="INSERT INTO agent (id,name,mail,ph) VALUES(?,?,?,?)";
                        PreparedStatement ppt=con.prepareStatement(sqq);
                        ppt.setString(1,id);
                        ppt.setString(2,na);
                        ppt.setString(3,ma);
                        ppt.setString(4,ph);
                        int rk=ppt.executeUpdate();
                        if(rk>0)
                        return "--Added Succesfully--";
                    }
                } 

            }
            catch (SQLException e) {
            e.printStackTrace();
        }
        return "--Enter Valid--";
    }


    public static String Remove(String id)
    {
        try{
            String sq="UPDATE agent SET sta='1' WHERE id=?";
            PreparedStatement pt=con.prepareStatement(sq);
            pt.setString(1, id);
            int rk=pt.executeUpdate();
            if(rk>0)
            {
                String ss="UPDATE user SET sta='1' WHERE id=?";
                PreparedStatement st=con.prepareStatement(ss);
                st.setString(1, id);
                int sk=st.executeUpdate();
                if(sk>0)
                return "--Remove Succesful--";
                else
                return null;
            }
            else
            return null;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }


    public static ArrayList AView()
    {
        try{
            String sql = "SELECT * FROM agent WHERE sta LIKE '0'";
            PreparedStatement stmt=con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData metaData = (ResultSetMetaData)rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            ArrayList<ArrayList<Object>> resultList = new ArrayList<>();
            while (rs.next()) {
                ArrayList<Object> rowData = new ArrayList<>();
                for (int i = 1; i < columnCount; i++) {
                    Object data = rs.getObject(i);
                    rowData.add(data);
                }
                resultList.add(rowData);
                // System.out.println(rowData);
            }
            return resultList;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    
}
