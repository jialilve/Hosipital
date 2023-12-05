package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBUtil;

public abstract class BaseDao 
{
    protected Connection con=DBUtil.getConnection() ;
    protected PreparedStatement pSatement=null;
    protected void close()
    {
    	try {
			this.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
