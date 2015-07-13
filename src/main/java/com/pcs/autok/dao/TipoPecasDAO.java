package com.pcs.autok.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pcs.autok.dao.connect.ConnectionDAO;
import com.pcs.autok.model.TipoPeca;

public class TipoPecasDAO extends ConnectionDAO {

	public List<TipoPeca> listarTipoPecas() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<TipoPeca> u = new ArrayList<TipoPeca>();
		
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			
			sql.append("select * from dbAutOK.tipo_pecas;");
			System.out.println(sql.toString());
			
			rs = stmt.executeQuery(sql.toString());
			
			TipoPeca o;
			
			while (rs.next()) {
				o = new TipoPeca();
				o.setDescrPeca(rs.getString("desctipo_pecas"));
				u.add(o);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u;
	}
}
