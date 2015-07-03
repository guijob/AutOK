package com.pcs.autok.dao.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDAO {

	public Connection startConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/default_schema", "root", "root1234");
	}
	
	public void sendQuery(String query) {
		
	}
	
}
