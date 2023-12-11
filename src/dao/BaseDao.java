package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBUtil;

public abstract class BaseDao 
{
	// 创建一个Connection对象，用于数据库连接
	protected Connection con=DBUtil.getConnection() ;
	// 创建一个PreparedStatement对象，用于执行SQL语句
	protected PreparedStatement pSatement=null;
	
	// 定义一个关闭数据库连接的方法
	protected void close()
	{
		try {
			// 尝试关闭数据库连接
			this.con.close();
		} catch (SQLException e) {
			// 如果关闭失败，打印错误信息
			e.printStackTrace();
		}
	}
}