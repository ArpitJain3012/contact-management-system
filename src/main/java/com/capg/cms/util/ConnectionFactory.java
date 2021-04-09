package com.capg.cms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getconnection() throws SQLException{
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sample","sample123");
	}

}
