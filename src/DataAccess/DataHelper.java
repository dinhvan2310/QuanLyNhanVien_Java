package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataHelper 
{
    private static DataHelper _Instance;

    Connection _conn;


    private DataHelper() throws SQLException
    {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        _conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/baitapnhomjava", "root", "");
    }

    public static DataHelper getInstance() throws SQLException
    {
        if(_Instance == null)
        {
            _Instance = new DataHelper();
        }
        return _Instance;
    }

    public ResultSet getResultSet(String qr) throws SQLException
    {
        return _conn.createStatement().executeQuery(qr);
    }

    public int updateDatabase(String qr) throws SQLException
    {
        return _conn.createStatement().executeUpdate(qr);
    }


}