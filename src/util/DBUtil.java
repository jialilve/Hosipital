package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static String jbdcstr="com.mysql.cj.jdbc.Driver";
	public static Connection getConnection() 
	{
		 try
		{
	     
		 Class.forName(jbdcstr); 
		 String url="jdbc:mysql://localhost:3306/ks?useSSL=true&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
		 String username="root";
		 String password="acm117";
		 Connection connection=DriverManager.getConnection(url,username,password);
		 return connection;
		} 
		 catch (ClassNotFoundException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		 
	}
  
}
