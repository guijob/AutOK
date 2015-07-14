package com.pcs.autok.dao.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SuperDAO {

	public ResultSet executeQueryCRUD(String query) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://autok-instance.cey5pxo5jpn2.sa-east-1.rds.amazonaws.com/dbAutOK", "root", "root1234");

			stmt = conn.createStatement();
			if(query.toLowerCase().contains("delete") 
					|| query.toLowerCase().contains("insert") 
					|| query.toLowerCase().contains("update")) {
				stmt.executeUpdate(query);
			} else if (query.toLowerCase().contains("select")) {
				rs = stmt.executeQuery(query);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}	
}