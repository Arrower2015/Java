package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** 
* @author lijin E-mail: lijin1@itcast.cn 
* @date   2017年9月22日 上午8:50:43 
* 类说明 
*/
public class JDBCTest {

	//1、加载驱动
	//2、创建连接
	//3、创建 Statement
	//4、设置SQL语句
	//5、设置参数
	//6、执行  返回结果集
	//7、遍历结果集
	//8、释放资源
	
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// 加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");

			// 通过驱动管理类获取数据库链接
			connection = DriverManager.getConnection("jdbc:mysql://192.168.162.108:3306/mybatis63?characterEncoding=utf-8", "root", "root");
			// 定义sql语句 ?表示占位符
			String sql = "select * from user where username = ?";//硬编码问题
			// 获取预处理statement
			preparedStatement = connection.prepareStatement(sql);
			// 设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
			preparedStatement.setString(1, "王五");//硬编码
			// 向数据库发出sql执行查询，查询出结果集
			resultSet = preparedStatement.executeQuery();
			// 遍历查询结果集
			while (resultSet.next()) {
				System.out.println(resultSet.getString("id") + "  " + resultSet.getString("username") + "" + resultSet.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	
}
