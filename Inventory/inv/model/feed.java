package inv.model;

import java.util.ArrayList;
import java.sql.*;

public class feed {
    static DB db=new DB();
    static Connection con;

    static{
        try{
            con=db.getConnection();
        }catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static String req(String na,String ma,String ph,String fee)
    {
        try{
            String sql="INSERT INTO feed(name,mail,ph,req,date) VALUES(?,?,?,?,CURRENT_TIMESTAMP)";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, na);
            stmt.setString(2, ma);
            stmt.setString(3, ph);
            stmt.setString(4, fee);
            int rt=stmt.executeUpdate();
            if(rt>0)
            return "--Feed Succesful--";
            else
            return null;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }


    public static ArrayList ReqView()
    {
        try{
            String sql="SELECt * FROM feed WHERE sta LIKE '0'";
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
            }
            return resultList;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static String AccReq(String id)
    {
        try{
            String sql="UPDATE feed SET sta='1' WHERE id=?";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, id);
            int rt=stmt.executeUpdate();
            if(rt>0)
            {
                String sq="SELECT * FROM feed WHERE id="+id;
                PreparedStatement pt=con.prepareStatement(sq);
                ResultSet rk=pt.executeQuery();
                if(rk.next())
                {
                    String na=rk.getString("name");
                    String ma=rk.getString("mail");
                    String ph=rk.getString("ph");
                    String ss=Agent.Aup(na, ma, "12345678", ph, "agent");
                    if(ss!=null)
                    return "--Accepted--";
                    else
                    return null;
                }
            }
            else
            return null;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
