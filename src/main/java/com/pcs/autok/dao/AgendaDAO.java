package com.pcs.autok.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pcs.autok.dao.connect.ConnectionDAO;
import com.pcs.autok.model.Agenda;

public class AgendaDAO extends ConnectionDAO {

	public void editarAgenda(Agenda agenda) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("update dbAutOK.agenda");
			sql.append(" set idtecnico = " + agenda.getIdTecnico()
					+ ", dataagenda = " + agenda.getData()
					+ ", hora_08 = " + agenda.getHora_08()
					+ "', hora_09 = " + agenda.getHora_09()
					+ "', hora_10 = " + agenda.getHora_10()
					+ "', hora_11 = " + agenda.getHora_11()
					+ "', hora_12 = " + agenda.getHora_12()
					+ "', hora_13 = " + agenda.getHora_13()
					+ "', hora_14 = " + agenda.getHora_14()
					+ "', hora_15 = " + agenda.getHora_15()
					+ "', hora_16 = " + agenda.getHora_16()
					+ "', hora_17 = " + agenda.getHora_17() + "';");
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
	
	public void cadastrarAgenda(Agenda agenda) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("insert into dbAutOK.agenda");
			sql.append(" values " + "(0, " + agenda.getIdTecnico()
					+ ", " + agenda.getData() + ", '"
					+ agenda.getHora_08() + "', '"
					+ agenda.getHora_09() + "', '"
					+ agenda.getHora_10() + "', '"
					+ agenda.getHora_11() + "', '"
					+ agenda.getHora_12() + "', '"
					+ agenda.getHora_13() + "', '"
					+ agenda.getHora_14() + "', '"
					+ agenda.getHora_15() + "', '"
					+ agenda.getHora_16() + "', '"
					+ agenda.getHora_17() + "');");
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
	
	
	public void excluirAgenda(Agenda agenda) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("delete from dbAutOK.agenda");
			sql.append(" where idTecnico = '" + agenda.getIdTecnico()
					+ "' and data = '" + agenda.getData()
					+ "';");
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
	
	public boolean buscarAgenda(Agenda agenda) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
	
			sql.append("select * from dbAutOK.agenda where");
			sql.append(" idtecnico like '" + agenda.getIdTecnico() 
						+ "' and data like '" + agenda.getData() + "';");
			System.out.println(sql.toString());
			rs = stmt.executeQuery(sql.toString());
			result = rs.next();
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
		System.out.println(":::" + result);
		return result;
	}

	public List<Agenda> listarTodos() {
		List<Agenda> agendas = new ArrayList<Agenda>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append(" select agenda.idtecnico, agenda.data");
			sql.append(" from agenda agenda");
			rs = stmt.executeQuery(sql.toString());

			Agenda u = null;
			while (rs.next()) {
				u = new Agenda();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// conn.close();
				// stmt.close();
				// rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return agendas;
	}

}
