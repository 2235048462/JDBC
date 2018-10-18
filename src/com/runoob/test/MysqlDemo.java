package com.runoob.test;

import java.sql.*;

public class MysqlDemo {
	// JDBC�����������ݿ�URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/mysql";
	// ���ݿ��û���������
	static final String USERNAME = "root";
	static final String PASSWORD = "123456";

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			// ע��JDBC����
			Class.forName(JDBC_DRIVER);

			// ������
			System.out.println("���ݿ�����......");
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

			// ִ�в�ѯ
			String sql;
			System.out.println("ʵ����Statement����...");
			statement = connection.createStatement();
			sql = "select Host,Db from db";
			ResultSet resultSet = statement.executeQuery(sql);

			// չ����������ݿ�
			while (resultSet.next()) {
				// ͨ���ֶμ���
				String host = resultSet.getString("Host");
				String data_base = resultSet.getString("Db");
				// �������
				System.out.println("Host:" + host);
				System.out.println("Db:" + data_base);
			}
			// ��ɺ�ر�
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException se) {
			// ����JDBC����
			se.printStackTrace();
		} catch (Exception e) {
			// ����Class.forName����
			e.printStackTrace();
		} finally {
			// �ر���Դ
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
		System.out.println("����...");
	}
}
