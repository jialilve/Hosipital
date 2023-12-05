package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;

public class AdminDao extends BaseDao
{
     

	public Admin selectAdmin(String name,String password,int lid) 
    {
    	String sqlstr="select * from user where name = ? and password = ? and status = ?";
    	Admin admin=null;
    	try
    	{
    		this.pSatement=this.con.prepareStatement(sqlstr);
    		
    		this.pSatement.setString(1, name);
    		this.pSatement.setString(2, password);
    		this.pSatement.setInt(3, lid);
    		System.out.println(this.pSatement);
    		ResultSet executeQuery=this.pSatement.executeQuery();
    		if(executeQuery.next())
    		{
    			admin=new Admin(executeQuery.getString(1),executeQuery.getString(2),executeQuery.getString(3),executeQuery.getInt(4));
    		}
    	}
    	catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally
    	{
    		this.close();
    	}
        return admin;
    }
}
