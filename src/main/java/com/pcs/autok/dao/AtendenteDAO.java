package com.pcs.autok.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pcs.autok.dao.connect.ConnectionDAO;
import com.pcs.autok.model.Atendente;

public class AtendenteDAO extends ConnectionDAO {

	public void editarAtendente(Atendente atendente) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("update dbAutOK.atendente");
			sql.append(" set nomeatendente = '" + atendente.getNomeAtendente()
					+ "', telefoneatendente = " + atendente.getTelAtendente() + ",enderecoatendente = '"
					+ atendente.getEndAtendente() + "', emailatendente = '"
					+ atendente.getEmailAtendente() + "',senha = '"
					+ atendente.getSenhaAtendente() + "' where emailatendente = '" + atendente.getEmailAtendente() + "';");
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
	
	public void cadastrarAtendente(Atendente atendente) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("insert into dbAutOK.atendente");
			sql.append(" values " + "(0, " + "'" + atendente.getNomeAtendente()
					+ "', " + atendente.getTelAtendente() + ", '"
					+ atendente.getEndAtendente() + "', '"
					+ atendente.getEmailAtendente() + "', '"
					+ atendente.getSenhaAtendente() + "');");
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

	public boolean buscarEmail(Atendente atendente) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("select * from dbAutOK.atendente where");
			sql.append(" nomeatendente like '" + atendente.getEmailAtendente() + "';");
			System.out.println(sql.toString());

			rs = stmt.executeQuery(sql.toString());

			System.out.println(rs.next());
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
		return result;
	}
	
	public Atendente buscarRegistro(Atendente atendente) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Atendente u = null;
		
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			
			sql.append("select * from dbAutOK.atendente where");
			sql.append(" emailatendente like '" + atendente.getEmailAtendente() + "'"
					+ "and senha like '" + atendente.getSenhaAtendente() + "';");
			System.out.println(sql.toString());
			
			rs = stmt.executeQuery(sql.toString());
			
			if (rs.next()) {
				u = new Atendente();
				u.setIdAtendente(rs.getInt("idatendente"));
				u.setNomeAtendente(rs.getString("nomeatendente"));
				u.setTelAtendente(rs.getInt("telefoneatendente"));
				u.setEndAtendente(rs.getString("enderecoatendente"));
				u.setEmailAtendente(rs.getString("emailatendente"));
				u.setSenhaAtendente(rs.getString("senha"));
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
	
	public void excluirAtendente(Atendente atendente) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();

			sql.append("delete from dbAutOK.atendente");
			sql.append(" where emailatendente = '" + atendente.getEmailAtendente()
					+ "' and senha = '" + atendente.getSenhaAtendente()
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
	
	public boolean buscarAtendente(Atendente atendente) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
	
			sql.append("select * from dbAutOK.atendente where");
			sql.append(" emailatendente like '" + atendente.getEmailAtendente() 
						+ "' and senha like '" + atendente.getSenhaAtendente() + "';");
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

	public List<Atendente> listarTodos() {
		List<Atendente> atendentes = new ArrayList<Atendente>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			conn = startConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append(" select atendente.idAtendente, atendente.nomeAtendente, atendente.telAtendente");
			sql.append(" from atendente atendente");
			rs = stmt.executeQuery(sql.toString());

			@SuppressWarnings("unused")
			Atendente u = null;
			while (rs.next()) {
				u = new Atendente();
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
		return atendentes;
	}

}
