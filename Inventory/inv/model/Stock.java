package inv.model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.lang.annotation.Inherited;
import java.sql.Connection;
import java.sql.SQLException;

public class Stock {
    

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

    public static String ASto(String na,String cat,String qt,String ppu)
    {
        try{
            String sql="SELECT qty FROM stocks WHERE name=?";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, na);
            ResultSet rt=stmt.executeQuery();
            if(rt.next())
            {
                int qty=rt.getInt("qty");
                String sqq="UPDATE stocks SET qty=? WHERE name=?";
                PreparedStatement pt=con.prepareStatement(sqq);
                pt.setInt(1, Integer.valueOf(qt)+qty);
                pt.setString(2, na);
                int rrt=pt.executeUpdate();
                if(rrt>0)
                return "--Stock Added--";
                else
                return null;
            }
            else
            {
                String sq="INSERT INTO stocks (name,cat,qty,ppu) VALUES(?,?,?,?)";
                PreparedStatement pq=con.prepareStatement(sq);
                pq.setString(1,na);
                pq.setString(2,cat);
                pq.setString(3,qt);
                pq.setString(4,ppu);
                int rk=pq.executeUpdate();
                if(rk>0)
                return "--Stock Added--";
                else
                return null;
            }


        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static String Remove(String na)
    {
        try{
            String sql="UPDATE stocks SET sta=? WHERE id=?";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, "1");
            stmt.setString(2, na);
            int rt=stmt.executeUpdate();
            if(rt>0)
            return "--Removed Syccesfully--";
            else
            return null;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList SView()
    {
        try{
            String sql = "SELECT * FROM stocks WHERE sta LIKE '0'";
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

    public static String Bill(String med,String qty)
    {
        try{
            String ret="";
            String sql="SELECT * FROM stocks WHERE id=?";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, med);
            ResultSet rt=stmt.executeQuery();
            if(rt.next())
            {
                String na=rt.getString("name");
                int co=rt.getInt("ppu");
                int qt=rt.getInt("qty");
                if(qt<Integer.valueOf(qty))
                return null;
                ret+=na+"    "+qty+"    "+Integer.valueOf(qty)*co;
                return ret;
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static String Buy(String id,String med,String qty)
    {
        try{
            String sql="SELECT * FROM stocks WHERE id=?";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, med);
            ResultSet rt=stmt.executeQuery();
            if(rt.next())
            {
                int qt=rt.getInt("qty");
                String na=rt.getString("name");
                String cat=rt.getString("cat");
                int co=rt.getInt("ppu");
                if(qt<Integer.valueOf(qty))
                return null;
                String sq="UPDATE stocks SET qty=? WHERE id=?";
                PreparedStatement pt=con.prepareStatement(sq);
                pt.setInt(1, qt-Integer.valueOf(qty));
                pt.setString(2, med);
                int rq=pt.executeUpdate();
                if(rq>0)
                {
                    String ss="INSERT INTO his (a_id,name,qty,amt,date,cat) VALUES(?,?,?,?,CURRENT_TIMESTAMP,?)";
                    PreparedStatement pp=con.prepareStatement(ss);
                    pp.setString(1, id);
                    pp.setString(2, na);
                    pp.setString(3, qty);
                    pp.setInt(4, co*Integer.valueOf(qty));
                    pp.setString(5, cat);
                    int rk=pp.executeUpdate();
                    if(rk>0)
                    {
                        return "--Order Purchased--";
                    }
                    else
                    return null;
                }
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
