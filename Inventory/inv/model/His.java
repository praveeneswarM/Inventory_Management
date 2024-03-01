package inv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class His {
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

    public static ArrayList OView() {
        try {
            String sql = "SELECT * FROM his";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            ArrayList<ArrayList<Object>> resultList = new ArrayList<>();
            while (rs.next()) {
                ArrayList<Object> rowData = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    Object data = rs.getObject(i);
                    rowData.add(data);
                }
                resultList.add(rowData);
            }
            return resultList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static ArrayList AHis(String id)
    {
        try {
            String sql = "SELECT * FROM his WHERE a_id="+id;
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            ArrayList<ArrayList<Object>> resultList = new ArrayList<>();
            while (rs.next()) {
                ArrayList<Object> rowData = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    Object data = rs.getObject(i);
                    rowData.add(data);
                }
                resultList.add(rowData);
            }
            return resultList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
