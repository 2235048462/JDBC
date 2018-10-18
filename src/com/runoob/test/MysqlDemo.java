package com.runoob.test;

import java.sql.*;

public class MysqlDemo {
	// JDBC驱动名及数据库URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/mysql";
	// 数据库用户名及密码
	static final String USERNAME = "root";
	static final String PASSWORD = "123456";

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			// 注册JDBC驱动
			Class.forName(JDBC_DRIVER);

			// 打开链接
			System.out.println("数据库连接......");
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			// 执行查询
			String sql;
			System.out.println("实例化Statement对象...");
			statement = connection.createStatement();
			sql = "select Host,Db from db";
			ResultSet resultSet = statement.executeQuery(sql);

			// 展开结果集数据库
			while (resultSet.next()) {
				// 通过字段检索
				String host = resultSet.getString("Host");
				String data_base = resultSet.getString("Db");
				// 输出数据
				System.out.println("Host:" + host);
				System.out.println("Db:" + data_base);
			}
			// 完成后关闭
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException se) {
			// 处理JDBC错误
			se.printStackTrace();
		} catch (Exception e) {
			// 处理Class.forName错误
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException se2) {
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("结束...");
	}
}
