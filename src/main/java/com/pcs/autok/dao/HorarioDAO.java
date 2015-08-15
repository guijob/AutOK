package com.pcs.autok.dao;

import java.sql.Connection;
import java.sql.Statement;

import com.pcs.autok.dao.connect.ConnectionDAO;
import com.pcs.autok.model.Agenda;
import com.pcs.autok.model.Horario;

public class HorarioDAO extends ConnectionDAO {

	public void setHorarioOcupado(Integer idHorario, boolean ocupado) {

		Connection conn = null;
		Statement stmt = null;
		
		int oc = ocupado? 1:0;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("update dbAutOK.horario ");
			sql.append("set ocupado = " + oc + " where id = " + idHorario
					+ ";");
			System.out.println(sql.toString());

			stmt.executeUpdate(sql.toString());
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
	}

}
