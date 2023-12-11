package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	// 定义JDBC驱动字符串
	private static String jbdcstr="com.mysql.cj.jdbc.Driver";
	
	// 定义获取数据库连接的方法
	public static Connection getConnection() 
	{
		try
		{
			// 加载JDBC驱动
			Class.forName(jbdcstr); 
			
			// 定义数据库URL，包含数据库地址、数据库名、SSL设置、字符编码设置和时区设置
			/*
这段代码定义了一个名为`url`的字符串，它是用于连接到MySQL数据库的JDBC（Java Database Connectivity）URL。

```java
// 定义数据库URL，包含数据库地址、数据库名、SSL设置、字符编码设置和时区设置
String url="jdbc:mysql://localhost:3306/ks?useSSL=true&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
```

这个URL包含了以下几个部分：

- `jdbc:mysql://`：这是JDBC URL的前缀，它表示这是一个JDBC连接，并且数据库类型是MySQL。
- `localhost:3306/`：这是数据库服务器的地址和端口号。在这个例子中，数据库服务器在本地机器上，端口号是3306，这是MySQL的默认端口号。
- `ks`：这是数据库的名称。
- `?useSSL=true`：这是一个参数，表示是否使用SSL（Secure Sockets Layer）来加密数据库连接。在这个例子中，SSL被设置为true，表示使用SSL。
- `&useUnicode=true`：这是一个参数，表示是否使用Unicode字符集。在这个例子中，Unicode被设置为true，表示使用Unicode。
- `&characterEncoding=utf-8`：这是一个参数，表示字符编码方式。在这个例子中，字符编码被设置为UTF-8。
- `&serverTimezone=Asia/Shanghai`：这是一个参数，表示服务器的时区。在这个例子中，时区被设置为Asia/Shanghai。

总的来说，这个URL定义了如何连接到数据库，包括数据库的位置、名称、连接参数等信息。
			 */
			String url="jdbc:mysql://localhost:3306/ks?useSSL=true&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
			
			// 定义数据库用户名
			String username="root";
			
			// 定义数据库密码
			String password="acm117";
			
			// 获取数据库连接
			Connection connection=DriverManager.getConnection(url,username,password);
			
			// 返回数据库连接
			return connection;
		} 
		catch (ClassNotFoundException e) 
		{
			// 如果加载JDBC驱动失败，打印错误信息
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			// 如果获取数据库连接失败，打印错误信息
			e.printStackTrace();
		}
		
		// 如果出现异常，返回null
		return null;
	}
}