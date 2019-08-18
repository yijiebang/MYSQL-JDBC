package com.jdbc;

import java.sql.Connection;//支持多个数据库，如果实现mysql的connection只能使用msql的数据库
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

 
/**
 * MySQL的jdbc操作
 * @author Administrator
 *
 */
public class MysqlJdbc {
/**
 * DriverManager依赖jar包，没jar导致编译时出错
       * 解决依赖关系，使用反射加载驱动，没jar编译时不报错，运行时报错
 * @param args
 * @throws Exception
 */
	public static void main(String[] args) throws Exception {
		// 1.注册驱动，使用反射创建类对象
		Class.forName("com.mysql.jdbc.Driver");
 		// 1.注册驱动,
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//2.获取连接
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=UTF-8&useSSL=false","root","root");
		//3.获取操作数据库的预处理对象
		PreparedStatement psql=con.prepareStatement("select * from users");
		//4.执行sql获取返回
		ResultSet rst=psql.executeQuery();
		//5.封装结果集
		while (rst.next()) {
		   System.out.println(rst.getString("username"));
		}
		
		//6.释放资源
		rst.close();
		psql.close();
		con.close();

	}

}
