package com.nit.GetConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	static Connection con;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(DBInfo.URL, DBInfo.USERNAME, DBInfo.PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		return con;
	}
}