package com.jdbc;

import java.sql.Connection;//֧�ֶ�����ݿ⣬���ʵ��mysql��connectionֻ��ʹ��msql�����ݿ�
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

 
/**
 * MySQL��jdbc����
 * @author Administrator
 *
 */
public class MysqlJdbc {
/**
 * DriverManager����jar����ûjar���±���ʱ����
       * ���������ϵ��ʹ�÷������������ûjar����ʱ����������ʱ����
 * @param args
 * @throws Exception
 */
	public static void main(String[] args) throws Exception {
		// 1.ע��������ʹ�÷��䴴�������
		Class.forName("com.mysql.jdbc.Driver");
 		// 1.ע������,
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//2.��ȡ����
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=UTF-8&useSSL=false","root","root");
		//3.��ȡ�������ݿ��Ԥ�������
		PreparedStatement psql=con.prepareStatement("select * from users");
		//4.ִ��sql��ȡ����
		ResultSet rst=psql.executeQuery();
		//5.��װ�����
		while (rst.next()) {
		   System.out.println(rst.getString("username"));
		}
		
		//6.�ͷ���Դ
		rst.close();
		psql.close();
		con.close();

	}

}
