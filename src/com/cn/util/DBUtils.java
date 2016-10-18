package com.cn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	private static final DBUtils db = new DBUtils();

	private DBUtils() {
		getConnection();
	}

	public static DBUtils getDB() {
		return db;
	}

	private Connection conn;
	private Statement stat;
	private ResultSet result;

	private void getConnection() {
		// 第一步，加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 建立链接。有三个参数，第一个是访问数据库URL地址，第二个参数是账号，第三是密码
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialsearch", "root", "daiqing123");
			//创建发送SQL语句的stat对象
			stat=conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动加载失败，1、驱动未加载，2、驱动的名称写错");
		}// 字符串是驱动名称，这个名是包名+类名
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库链接错误，1、URL错误2、密码3、数据库不存在");
		}
	}
	//////////////////////////////////////////////////////////
	public ResultSet query(String sql){
		try {
			//发送sql语句到数据库中，数据库执行完sql语句后把结果封装到ResultSet对象中
			result=stat.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int delete(String sql){
		int count=0;
		try {
			count=stat.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("delete error");
		}
		return count;
	}
	
	public int update(String sql){
		int count=0;
		try {
			count=stat.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("update error");
		}
		return count;
	}
	public int insert(String sql){
		int count=0;
		try {
			count=stat.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(sql);
			System.out.println("insert error");
		}
		return count;
	}
}