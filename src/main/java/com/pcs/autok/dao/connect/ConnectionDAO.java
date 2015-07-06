package com.pcs.autok.dao.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {

	public Connection startConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://autok-instance.cey5pxo5jpn2.sa-east-1.rds.amazonaws.com/dbAutOK", "root", "root1234");
	}

	public void sendQuery(String query) {

	}

}
