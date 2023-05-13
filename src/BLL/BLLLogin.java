package BLL;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BLLLogin 
{
    public static boolean login(String username, String password) throws SQLException
    {
        ResultSet rs = DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM Account");

        while(rs.next())
        {
            if(username.equals(rs.getString(2)) && password.equals(rs.getString(3)))
            {
                return true;
            }
        }
        return false;
    }
}